
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Environment;

public class ExternalStorageExample extends Activity{

	//DO NOT FORGET, YOU MUST ADD THIS PERMISSION IN THE MANIFEST FOR THIS TO WORK:
	//<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	
	/*
	Different Types of external storage directory calls:

		public static File getExternalStorageDirectory();
		This method was deprecated from API 7 and onward. It gives you access to the 'primary' external
		method directory. This would be if they had 2 memory card slots. Also, if there are multiple
		users on the app, this saves it per the user using it.
		
		getExternalFilesDir(String type)
		The parameters that can go into the String type are:
		-DIRECTORY_MUSIC;
		-DIRECTORY_PODCASTS;
		-DIRECTORY_RINGTONES;
		-DIRECTORY_ALARMS;
		-DIRECTORY_NOTIFICATIONS;
		-DIRECTORY_DOWNLOADS;
		-DIRECTORY_PICTURES;
		-DIRECTORY_MOVIES;
		This returns the absolute path to the directory on the primary external where the application 
		can place a file it owns. They ARE internal to applications and generally are not visible to 
		the user as media. These files ARE deleted when the app is uninstalled.
		IE: File path = getExternalFilesDir("MyApp"); will return the directories on this pathway
		
		Context.getExternalFilesDir
		Private files to your application are returned via this function. They will be deleted once
		the app is removed from the phone.
		
		getExternalStoragePublicDirectory(String)
		This is used for public data (IE photos). These files are NOT deleted once the app is removed.
		This data can be seen by the user once installed. 
	
	 */
	
	//HOW TO WRITE DATA //
	
			//Save it to internal cache
			public void saveInternalCache(){
				//Set / get your text here for the writing of the file
				String data = "stuff_goes_here. ok?";
				
				//Get a reference to the directory to save
				File folder = getCacheDir();
				File myFile = new File (folder, "mydata1.txt");
				
				writeData(myFile, data);
			}
			
			//Save the file to the external cache
			public void saveExternalCache(){
				//Set / get your text here for the writing of the file
				String data = "stuff_goes_here. ok?";
				
				//Get a reference to the directory to save
				File folder = getExternalCacheDir();
				File myFile = new File (folder, "mydata2.txt");
				
				writeData(myFile, data);
			}
			
			//Saves data to a private external resource
			public void savePrivateExternalFile(){
				//Set / get your text here for the writing of the file
				String data = "stuff_goes_here. ok?";
				
				//Get a reference to the directory to save. Creates a new folder and the data txt file goes in it
				File folder = getExternalFilesDir("PGMacDesign"); //This creates a folder named PGMacDesign
				File myFile = new File (folder, "mydata3.txt");
				//This private file can go into a custom folder
				
				writeData(myFile, data);
			}
			
			//Save data to External Public file
			public void savePublicExternalFile(){
				//Set / get your text here for the writing of the file
				String data = "stuff_goes_here. ok?";
				
				//Get a reference to the directory to save. Using Downloads folder
				File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
				File myFile = new File (folder, "mydata4.txt");
				//This public file must go into one of the specified folders, it cannot go to a custom folder
				
				writeData(myFile, data);
			}
			
			//To prevent repetition, placing centralized code
			private void writeData(File myFile, String data){
				FileOutputStream fos = null;
				//Write the data with the fos
				try{
					fos = new FileOutputStream(myFile);
					//We want to write in the form of a text, but this writes int the form of a byte type
					fos.write(data.getBytes());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						//Since we initialized it to null up above, if it never gets initialized, we will be calling
						//Close on a null object which will cause a null pointer error. Fix with an If statement
						if (fos != null){
							fos.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	
	//HOW TO READ DATA //

			//load data from the internal cache
			public void loadInternalCache(){
				File folder = getCacheDir();
				File myFile = new File (folder, "mydata1.txt"); //Same as txt from write files
				
				String data = readData(myFile);
				
				if (data != null){
					//Do something with the returned data
				} else {
					//It returned null, the file was empty OR there was an error at the reader returned null
				}
			}
			
			//load data from the external cache
			public void loadExternalCache(){
				File folder = getExternalCacheDir();
				File myFile = new File (folder, "mydata2.txt"); //Same as txt from write files
				
				String data = readData(myFile);
				
				if (data != null){
					//Do something with the returned data
				} else {
					//It returned null, the file was empty OR there was an error at the reader returned null
				}
			}
			
			//load data from the private external file
			public void loadPrivateExternalFile(){
				//Pull data from the same folder we inserted into before, IE the PGMacDesign folder
				File folder = getExternalFilesDir("PGMacDesign"); //Find within that folder
				File myFile = new File (folder, "mydata3.txt"); //Same as txt from write files
				
				String data = readData(myFile);
				
				if (data != null){
					//Do something with the returned data
				} else {
					//It returned null, the file was empty OR there was an error at the reader returned null
				}
			}
			
			//Load data from the public external file
			public void loadPublicExternalFile(){
				//Pull data from the same folder we inserted into before, IE the downloads folder
				File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
				File myFile = new File (folder, "mydata4.txt"); //Same as txt from write files
				
				String data = readData(myFile);
				
				if (data != null){
					//Do something with the returned data
				} else {
					//It returned null, the file was empty OR there was an error at the reader returned null
				}
			}
			
			//To prevent repetition, placing centralized code
			private String readData(File myFile){
				
				//Reads Data
				FileInputStream is = null;
				
				try{ 
					//Initialize the fos with the passed file param
					is = new FileInputStream(myFile);
					
					int read = -1; //When the fos reads -1, it has finished reading the file
					
					//String buffer as it is mutable / editable
					StringBuffer sb = new StringBuffer();
					
					//Reads as, set int read to the input from the read() function. While that value
					//is NOT equal to -1 (IE, has not finished reading the file) perform action in loop
					while ((read = is.read()) != -1){ 
						
						//This will read input characters as one long string
						sb.append((char) read);
					}
					
					//Return the compiled string
					return sb.toString();
					
				} catch (FileNotFoundException e){
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					//Since we initialized it to null up above, if it never gets initialized, we will be calling
					//Close on a null object which will cause a null pointer error. Fix with an If statement
					if(is != null){
						try {
							is.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
				//If everything breaks, return null
				return null;	
			}
}
