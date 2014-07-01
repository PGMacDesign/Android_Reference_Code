
//Code for Java File
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {

		//Place what you want to happen here
		Toast.makeText(context, "Airplane mode has been turned on!", Toast.LENGTH_SHORT).show();
	}

}

//This code must go into the manifest:
/*

    <receiver 
        android:name="com.pgmacdesign.calendarapplication.AirplaneReceiver" >
            
        <intent-filter >
            <action android:name="android.intent.action.AIRPLANE_MODE" />
        </intent-filter>

	</receiver>        
        
    
<!-- Must go before the end closing of </application> -->

*/