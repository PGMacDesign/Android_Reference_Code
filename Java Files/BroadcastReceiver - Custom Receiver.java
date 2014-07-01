//First make separate class to handle the receiver:
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {

		Toast.makeText(context, "Custom Broadcast Received", Toast.LENGTH_SHORT).show();
	}

}



//Next Define it in the manifest
    <receiver 
        android:name="com.pgmacdesign.multithreading.CustomReceiver" >
            
        <intent-filter >
            <action android:name="da_bears" />
        </intent-filter>

	</receiver>    
	<!-- Notice that the action android:name does not match any classes I have! -->
	

	
//Next where you want to activate the specific broadcast (Say via a button), write the code
	//XML Layout
	    <Button
        android:id="@+id/dasBroadcast"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="Das Broadcast" 
        android:onClick="sendBroadcast" 
        />
		
	//Java Code
		
	//Separate concept
	public void sendBroadcast(View v){
		//First create intent
		Intent intent = new Intent();
		intent.setAction("da_bears");
		sendBroadcast(intent);
		//Toast.makeText(this, "TESTING", Toast.LENGTH_SHORT).show();
	}
	