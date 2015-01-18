
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

//This is an example of the main activity that is used when you are working with databases
public class DatabaseMainActivity extends Activity{

	//Object of the Database Adapter class, this is an adapter
	DatabaseAdapter dbHelper;
	//Object of the 

	//Standard onCreate
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); //Change layout here
		
		//Creates the object of the database helper
		dbHelper = new DatabaseAdapter(this);
		
		
	}
	
	//Add a new row with data to insert
	private void addOneDataRowExample(){
		String name = "Pat";
		String password = "password1";
		
		//Return ID to confirm it was inserted. <0 means it did not successfully insert
		long returnID = dbHelper.insertData(name, password);
		
		if (returnID < 0){
			//Something went wrong! Should not return a negative number
			//Error message of some sort
		} else {
			//It successfully inserted a row
			//Do something to confirm it
		}
	}
	
	//This pulls the data from ALL of the rows in the database and converts it into one string str
	public void getAllData(){
		String str = dbHelper.getAllData();
		//Do something with the data now that it has been retrieved from the database
	}
	
	//Gets the pw with the username entered
	public void getThePassword(){
		String str = "Pat";
		String str1 = dbHelper.getPassword(str);
		//Do something with the data now that it has been retrieved from the database
	}
	
	//To retrieve the User ID (Row #) of the one that matches the username / pw entered
	public void getTheUID(){
		
		String str = "Pat 123"; //Username and pw mashed together
		//If the username and pw is easily separated out, you do not need to do this. 
		//Say you are pulling from a text file, if they are concantenated and need to be split: 
		String name_sub = str.substring(0, str.indexOf(" "));
		//Start the second string 1 spot AFTER the end of the first finished pulling the user name in
		String pw_sub = str.substring(name_sub.indexOf(" ") + 1); 
		
		//Query via passing in the username and PW and returns the row number in which the data is stored
		String results = dbHelper.getUID(name_sub, pw_sub);
	}
	
	//Essentually this is like find and replace in cntrl + f, updates a record
	public void updateName(){
		
		//Name you want to update to
		String newName = "bob";
		//Returns the number of rows updated where the db was successfully updated with the respective params
		int count = dbHelper.updateName("Pat", newName);
		
	}
	
	//Delete a row from the database
	public void deleteRow(){
		
		//Returns the number of rows that was deleted where the parameter matches the name Pat
		int count = dbHelper.deleteRow("Pat");
	}
}
