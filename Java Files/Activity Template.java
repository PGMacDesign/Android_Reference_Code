import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TemplateSetup extends Activity implements View.OnClickListener {

	//Shared Preferences
	public static final String PREFS_NAME = "NAME_OF_PREFS_FILE";	
	SharedPrefs sp = new SharedPrefs();
	SharedPreferences settings;
	SharedPreferences.Editor editor;
	
	//Define global variables/ objects here
	double dbl;
	String str;
	Button btn;
	EditText et;
	TextView tv;
	
	
	//Main - When the activity starts
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.XML_FILE_NAME);

		//Initialize Variables
		Initialize();
		
	}

	//Initialize Variables
	private void Initialize(){
		//Shared Preferences Stuff
		settings = getSharedPreferences(PREFS_NAME, 0);
		editor = settings.edit();
		
		//Initialize other variables as needed
		btn = (Button) findViewById(R.id.NAME_OF_ID_FROM_XML_1);
		et = (EditText) findViewById(R.id.NAME_OF_ID_FROM_XML_2);
		tv = (TextView) findViewById(R.id.NAME_OF_ID_FROM_XML_3);
		
		//Setup onClickListeners for all buttons
		btn.setOnClickListener(this); 
		//Either nest the onClick where the 'this' is, or define a separate handler
	}
	
	//On Click Method
	@Override
	public void onClick(View arg0) {
		//Switch case to determine what is clicked
		switch (arg0.getId()){
		
		case R.id.NAME_OF_ID_FROM_XML_1:
			//Do Stuff
			break;
		}
		*/
	}
	
	//On Pause happens when the activity is minimized, backed out of, or the home screen is pressed
	protected void onPause() {
		super.onPause();
		finish();
	}

}
