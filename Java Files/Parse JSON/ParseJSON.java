import info.androidhive.jsonparsing.R;
import java.util.ArrayList;
import java.util.HashMap;
 
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
 
public class ParseJSON {
 
	//List to hold the data
	List<Patient> patient_list;
 
    // URL to get contacts JSON
    private static String url = "http://netbrains-interview.s3.amazonaws.com/mobile/PatientList.json";
 
  
    //Pings the URL for the JSON data, converts it into serialized data via GSON and then adds it into Patient Objects
	private class GetContacts extends AsyncTask<Void, Void, Void > {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... arg0) {

			try {
				// Creating service handler class instance
				ServiceHandler sh = new ServiceHandler();

				// Making a request to url and getting response
				String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);
				Log.d("JSON STRING = ", jsonStr);

				try {

					GsonBuilder gsonBuilder = new GsonBuilder();
					Gson gson = gsonBuilder.create();

					//List<Patient> patients = new ArrayList<Patient>();
					patient_list = Arrays.asList(gson.fromJson(jsonStr, Patient[].class));


					for(Patient patient : patient_list) {
						//Log.d("TESTING", patient.first_name);
					}
				} catch (Exception ex) {
					Log.e("Error", "Failed to parse JSON due to: " + ex);
				}
			} catch(Exception ex) {
				Log.e("Error", "Failed to send HTTP POST request due to: " + ex);
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);

		}

	}
 
}