import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 
 The 3 steps to creating a database
 1) Define the schema - database name, version, table name, column names
 2) Create the database - write queries to create / modify the database
 3) Execute queries - perform insert, update, and delete operations
 
 */

//This is an adapter class to help encapsulate data.
public class DatabaseAdapter {
	
	//Helper object 
	DatabaseHelper helper;
	
	//Constructor
	public DatabaseAdapter(Context context){
		helper = new DatabaseHelper(context);
	}
	
	//Returns a long to determine if the insert was successful
	public long insertData(String name, String password){
		//Creates an object of the SQLiteDatabase itself and then opens / creates a writeable database
		SQLiteDatabase db = helper.getWritableDatabase(); //This returns a database object
				
		//Create a content values object to help put data in
		ContentValues contentValues = new ContentValues();
		//Put data. Parameters are Key, Value
		contentValues.put(helper.TABLE_NAME, name);
		
		//Put the data into the database itself
		long result = db.insert(helper.TABLE_NAME, null, contentValues);
		
		return result;
		
	}
	
	//Returns ALL of the data in the database via a string
	public String getAllData(){
		//First make the object
		SQLiteDatabase db = helper.getWritableDatabase();
		
		//Cursor object for traversing the results of the database
		Cursor cursor;
		
		//Create a string array of data
		String[] columns = {helper.UID, helper.NAME, helper.PASSWORD };
		
		//Query the database. Third param is the search params, null returns ALL
		//This returns a cursor object
		cursor = db.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null); //May need to add more Null arguments
		
		//Stringbuffer to hold the data from the cursor
		StringBuffer buffer = new StringBuffer();
		
		//While the cursor can move to the next (while there are more rows)
		while(cursor.moveToNext()){
			//Integer is retrieving the column number where the UID is. We do know it is at 0, but, 
			//it could change eventually, so this is better programming for now. 
			int index1 = cursor.getColumnIndex(DatabaseHelper.UID);
			//Get the integer from the column UID (Unique Identifier)
			int cid = cursor.getInt(index1);
			
			//Integer is retrieving column number where the name is
			int index2 = cursor.getColumnIndex(DatabaseHelper.NAME);
			//Get the String from the column Name
			String name0 = cursor.getString(index2);
			
			//Integer is retrieving column number where the password is
			int index3 = cursor.getColumnIndex(DatabaseHelper.PASSWORD);
			//Get the String from the column password
			String password = cursor.getString(index3);
			
			//Add the items to the buffer
			buffer.append(cid + " " + name0 + " " + password + "\n");
		}
		
		return buffer.toString();
	}
	
	//This returns a specific query, the password for the username entered
	public String getPassword(String name){
		//First make the object
		SQLiteDatabase db = helper.getWritableDatabase();
		
		//Cursor object for traversing the results of the database
		Cursor cursor;
		
		//Create a string array of data
		String[] columns = {helper.NAME, helper.PASSWORD };
		
		//Query the database. Third param are the search params. This returns a cursor object
		cursor = db.query(DatabaseHelper.TABLE_NAME, columns,
				helper.NAME + " = '" + name + "'", null, null, null, null); //May need to add more Null arguments
		
		//Stringbuffer to hold the data from the cursor
		StringBuffer buffer = new StringBuffer();
		
		//While the cursor can move to the next (while there are more rows)
		while(cursor.moveToNext()){
			
			//Integer is retrieving column number where the name is
			int index2 = cursor.getColumnIndex(DatabaseHelper.NAME);
			//Get the String from the column Name
			String name1 = cursor.getString(index2);
			
			//Integer is retrieving column number where the password is
			int index3 = cursor.getColumnIndex(DatabaseHelper.PASSWORD);
			//Get the String from the column password
			String password = cursor.getString(index3);
			
			//Add the items to the buffer
			buffer.append(name1 + " " + password + "\n");
		}
		
		return buffer.toString();
	}
	
	//This returns the User ID of the user whose username and pw matches parameters
	public String getUID(String name, String pw){
		//First make the object
		SQLiteDatabase db = helper.getWritableDatabase();
		
		//Cursor object for traversing the results of the database
		Cursor cursor;
		
		//Create a string array of data to pass in for the second argument
		String[] columns = {helper.UID};
		
		//Create a string array of data to pass in for the third argument
		String[] selectionArgs = { name, pw };
		
		//Query the database. Third param are the search params. This returns a cursor object
		cursor = db.query(DatabaseHelper.TABLE_NAME, columns,
				helper.NAME + " =? AND " + helper.PASSWORD + " =?", //selectionArgs holds strings to answer the ? vars
				selectionArgs, null, null, null, null); //May need to add more Null arguments
		
		//Stringbuffer to hold the data from the cursor
		StringBuffer buffer = new StringBuffer();
		
		//While the cursor can move to the next (while there are more rows)
		while(cursor.moveToNext()){
			
			//Integer is retrieving column number where the name is
			int index1 = cursor.getColumnIndex(DatabaseHelper.UID);
			//Get the String from the column Name
			int id1 = cursor.getInt(index1);
			
			//Add the items to the buffer
			buffer.append(id1 + "\n");
		}
		
		return buffer.toString();
	}
	
	//Updates a name in the database
	public int updateName(String oldName, String newName){
		
		//Creating an SQL database by referencing the adapter, 
		//which references the helper object, which opens the database
		SQLiteDatabase db = helper.getWritableDatabase();
		
		//Content values for passing in data
		ContentValues contentValues = new ContentValues();
		
		//Put the values into the content values so that it can update
		contentValues.put(helper.NAME,  newName);
		
		//The last parameter in update needs a string array, not a string, so creating the array here
		String[] whereArgs = {oldName};
		
		//Update. Follows the command: UPDATE TABLE SET NAME = "" WHERE NAME = ?
		//Returns a count of how many rows were updated
		int count = db.update(helper.TABLE_NAME, contentValues, helper.NAME + " =?", whereArgs);
		
		return count; 
		
	}
	
	//Deletes a row in the database
	public int deleteRow(String name_to_delete){
		
		//Creating an SQL database by referencing the adapter, 
		//which references the helper object, which opens the database
		SQLiteDatabase db = helper.getWritableDatabase();
		
		//The last parameter in update needs a string array, not a string, so creating the array here
		String[] whereArgs = {name_to_delete};
		
		//Delete. Follows the command: DELETE * FROM TABLE WHERE NAME = ""
		int count = db.delete(helper.TABLE_NAME, helper.NAME + "=?", whereArgs);
		
		return count;
	}
	
/////////////////////////////////////////////////////////////////////////////////
		//This class creates an object which extends to the database for commands
		//It is nested to encapsulate it
		static class DatabaseHelper extends SQLiteOpenHelper{
	
		private static final String DATABASE_NAME = "pgmacdesigndatabase";
		private static final String TABLE_NAME = "table_1";
		private static final int DATBASE_VERSION = 1;
		private static final String UID = "_id";
		private static final String NAME = "name";
		private static final String PASSWORD = "password";
		private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;
		
		private Context context; //In case we need context
		
		//Create table statement
		private static final String CREATE_TABLE = "CREATE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255));";
		
		//Constructor
		//Parameters are usually: Context context, String database_name, CursorFactory custom_cursor, int datbase_version
		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATBASE_VERSION);
			this.context = context;
		}
	
		//This is called when the database is called for the first time
		public void onCreate(SQLiteDatabase db) {
			
			try {
				db.execSQL(CREATE_TABLE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		//This is called when the database schema is changed (IE new columns or tables or deleting tables)
		//YOU CAN use the ALTER TABLE call instead whenever you change a table if you don't want to use this
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			
			try {
				db.execSQL(DROP_TABLE);
				onCreate(db);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}