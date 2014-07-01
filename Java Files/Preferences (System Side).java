/*
If the user needs to change preferences (IE, save their address, remove the music playing from the splash
screen, or adjust another feature, having this preferences (prefs) class / xml helps quite a bit
*/

//Prefs.java class
import android.os.Bundle;
import android.preference.PreferenceActivity;

//Preference activity to coincide with prefs options menu
	public class Prefs extends PreferenceActivity {

		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			//notice the reference to R.xml.prefs, not ID
			addPreferencesFromResource(R.xml.prefs); //This is deprecated, that is ok
		}
	}


//prefs.xml <--This goes into the res -> xml folder
	<?xml version="1.0" encoding="utf-8"?>
	<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android" >
		
		<EditTextPreference
			android:key="work_address_stored_xml"
			android:title="Work Address"
			android:summary="For use in the schedule">
			
		</EditTextPreference>
		
		<CheckBoxPreference
			android:key="checkBox"
			android:title="Music"
			android:defaultValue="true"
			android:summary="Play During the Splash Screen">
			
		</CheckBoxPreference>
		<!-- Don't forget the @array before referencing as it is needed
		for referencing a value. The value is listed under the values folder -->

	</PreferenceScreen>
