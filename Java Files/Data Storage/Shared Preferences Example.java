import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

//Example of shared preferences
public class SharedPreferencesExample extends Activity {

	/*
	Most ideal uses of Shared Preferences:
	-Check if the user is using the app for the Xth time
	-Check when the app was last updated
	-Remembering username and pw credentials
	-Remembering user settings
	-Location caching
	 */
	
	public static final String DEFAULT = "N/A";
	
	public void saveData(){
		//Create the shared preferences object
		SharedPreferences sharedPreferences = getSharedPreferences("My_Data", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		
		editor.putString("Name", "username goes here");
		editor.putString("Password", "password goes here");
		
		editor.commit();
	}
	
	//Load the data
	public void loadData(){
		SharedPreferences sp = getSharedPreferences("MyData", Context.MODE_PRIVATE);
		String name = sp.getString("Name", DEFAULT);
		String pw = sp.getString("Password", DEFAULT);
		
		if (name.equals(DEFAULT)){
			//Load did not work
		} else {
			//Load worked
		}
	}
}
