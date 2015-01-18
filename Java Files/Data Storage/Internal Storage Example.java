import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

//Shows an example of how to save to and load from internal storage
public class InternalStorageExample extends Activity{

	//Name of the file
	String fileName = "Pat.txt";
	
	//Save the data
	public void save(){
		String data1 = "Stuff to save 1";
		String data2 = "Stuff to save 2";
		
		//Add a new line after save 1 just to create a cleaner looking txt file
		data1 += "/n";
		
		//Create the File output stream here so it can be closed in the finally of the try catch below
		FileOutputStream fs = null;
		
		//Create the file
		File file = null;
		
		//Need to surround with try catch for anything file related
		try {
			//Get the files directory
			file = getFilesDir();
			
			//If Context.MODE_PRIVATE, it will be overridden when try to edit
			//If Context.MODE_APPEND, new data will be added to the file
			fs = openFileOutput(fileName, Context.MODE_APPEND); //File output stream writes
			
			//This writes via a byte [] array, NOT strings, need to convert first to byte array
			fs.write(data1.getBytes());
			fs.write(data2.getBytes()); //The getBytes() function converts it into a byte array
			
			//Lists where the file was saved to using the file object to display it
			Log.d("InternalStorageExample", "Storage data saved to: " + file + ".txt");
			
		} catch (FileNotFoundException e) {
			//File not found exception!
			e.printStackTrace();
		} catch (IOException e) {
			//Input output exception!
			e.printStackTrace();
		} finally { //This always executes regardless of a catch being caught or not
			//Need a nested try catch for using the close function
			try {
				//Prevent memory leaks
				fs.close();
			} catch (IOException e) {
				//File writer has been closed
				e.printStackTrace();
			}
		}
	}

	//Load the data
	public void load(){
		
		//FIS object to be used to read data
		FileInputStream is = null;
		
		try {
			
			//Set the object = to the data within the file
			is = openFileInput(fileName);
			
			int read = -1;
			
			//Have to use String buffer as String is immutable, this is not
			StringBuffer buffer = new StringBuffer();
			
			//Reads one byte (numbers). If it is -1, it is empty, if not, returning data
			while ((read=is.read()) != -1){
				//Need to cast as char as it returns int instead
				buffer.append((char)read); //By the end, the buffer Var will look like: 32, 113, 9231, 1, 23, // STOP-1
			}

			//Decompile the String buffer of tons of stuff
			String text1 = buffer.substring(0, buffer.indexOf(" ")); //IE, uses the space as the deliminator
			String text2 = buffer.substring(buffer.indexOf(" " + 1)); //Start AFTER the first buffer hits and runs to the end. (No end marker)

			if (text1.equalsIgnoreCase("") || text2.equalsIgnoreCase("")){
				//It did not load correctly, as in, they stored nothing in one of the fields
			} else {
				//Adjust textViews or whatever you need to work on as it has been confirmed with data in the file
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}