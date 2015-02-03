
/*
IMPORTANT:

This needs to be added into your build.gradle file in order to include the volley library:
compile 'com.mcxiaoke.volley:library:1.0.+'
Under the dependencies section:
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:21.0.3'
    compile 'com.mcxiaoke.volley:library:1.0.+'
}

*/


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends Activity {

	//Documentation URL: http://developer.rottentomatoes.com/docs/read/json/v10
	//Movie JSON Request URL: http://developer.rottentomatoes.com/docs/read/json/v10/Movies_Search

	String API_KEY = "abc_easy_as_123";
	
	//Sample movie call searching for "The matrix"
	String sample_url_call_the_matrix =
			"http://api.rottentomatoes.com/api/public/v1.0/movies.json?q=the+matrix&apikey=" + API_KEY;

	//Movies currently in the box office
	String sample_url_call_box_office_movies =
			"http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=" + API_KEY;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String url_link = "http://php.net/";
		//RequestQueue requestQueue = Volley.newRequestQueue(this); //You would use this if you did NOT have a Singleton class
		RequestQueue requestQueue = VolleySingleton.getsIntance().getmRequestQueue(); //This is utilizing the singleton

		//One big StringRequest object
		StringRequest request = new StringRequest(Request.Method.GET, sample_url_call_the_matrix, new Response.Listener<String>(){
			public void onResponse(String response){
				Toast.makeText(getApplicationContext(), "RESPONSE: " + response, Toast.LENGTH_SHORT).show();
				
				//Do something here with the string response (IE parse with GSON).
				
				Log.d("RESPONSE", response);
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(getApplicationContext(), "ERROR: " + error.getMessage(), Toast.LENGTH_SHORT).show();
				Log.d("ERROR", error.getMessage());
			}
		});

		//Add it to the request queue
		requestQueue.add(request);

	}

}