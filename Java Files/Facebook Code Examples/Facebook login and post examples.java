//This is an example of code used to login to facebook and then post something. 
//DON'T forget to add the dependency to the build.gradle file. It is=      compile 'com.facebook.android:facebook-android-sdk:3.21.1'

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AppEventsLogger;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.RequestAsyncTask;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.LoginButton;
import com.facebook.widget.WebDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
This class has a login button for facebook and then a post button. The post button will allow the
 user to post something to facebook. The links are all hard-coded. The 3 different methods of posting
 are also commented out, choose the one that works.
 The 3 methods chosen here are:
 1) Feed Dialog
 2) Share Dialog
 3) API publish call
 Descriptions for each are posted above their respective methods

 Also, XML Buttons are defined at the bottom in comments for example purposes
 */
public class MainFragment0 extends Fragment implements View.OnClickListener {

	Button post_something;

	private static final List<String> PERMISSIONS = Arrays.asList("publish_actions");
	private static final String PENDING_PUBLISH_KEY = "pendingPublishReauthorization";
	private boolean pendingPublishReauthorization = false;

	//UI Helper, following guide from: https://developers.facebook.com/docs/android/login-with-facebook/v2.2
	private UiLifecycleHelper uiHelper;
	private static final String TAG = "Main Fragment: ";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiHelper = new UiLifecycleHelper(getActivity(), callback);
		uiHelper.onCreate(savedInstanceState);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_main, container, false);
		post_something = (Button) view.findViewById(R.id.post_something);
		post_something.setOnClickListener(this);


		//This is used for the authentication login button. It should go in the onCreateView() of a fragment
		LoginButton authButton = (LoginButton) view.findViewById(R.id.facebook_login_button);
		authButton.setFragment(this);
		/*
		The only 3 permissions that DO NOT require any further review are public_profile, user_friends, email. Any
		others require review: https://developers.facebook.com/docs/apps/review#submitlogin
		 */
		authButton.setReadPermissions(Arrays.asList("public_profile"));


		return view;
	}

	//Manages session state changes
	private void onSessionStateChange(Session session, SessionState state, Exception exception) {
		if (state.isOpened()) {
			Log.i(TAG, "Logged in...");
		} else if (state.isClosed()) {
			Log.i(TAG, "Logged out...");
		}
	}

	//Manages the callbacks for the UILifeCycleHelper
	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state, Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	//Handles the onclick for the buttons
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.post_something:
				try{

					if (Session.getActiveSession() == null || !Session.getActiveSession().isOpened()) {
						//Session.openActiveSession(getActivity(), true, callback);
						Toast.makeText(getActivity(), "You need to login before you can post", Toast.LENGTH_SHORT).show();
					} else {
						//publishFeedDialog(); //Line 195
						//publishStory(); //Line 122
						//publishShareDialog(); //Line 249
					}

				} catch (Exception e){
					e.printStackTrace();
					Toast.makeText(getActivity(), "Error! Perhaps you do not have facebook installed?", Toast.LENGTH_SHORT).show();
				}
				break;
		}
	}

	/*
	Publish something using the API calls instead. This DOES require you to submit it for review,
	which means a slight delay on release. What this does is auto-post it without the user being able
	to edit it. Similar to how some games will post automatically something that says, "I just reached
	level 10..." and whatnot.
	 */
	//This DOES require you to submit for review :/.
	private void publishStory() {
		Session session = Session.getActiveSession();

		if (session != null){

			// Check for publish permissions
			List<String> permissions = session.getPermissions();
			if (!isSubsetOf(PERMISSIONS, permissions)) {
				pendingPublishReauthorization = true;
				Session.NewPermissionsRequest newPermissionsRequest = new Session
						.NewPermissionsRequest(this, PERMISSIONS);
				session.requestNewPublishPermissions(newPermissionsRequest);
				return;
			}

			Bundle postParams = new Bundle();
			postParams.putString("name", "Facebook SDK for Android");
			postParams.putString("caption", "Build great social apps and get more installs.");
			postParams.putString("description", "The Facebook SDK for Android makes it easier and faster to develop Facebook integrated Android apps.");
			postParams.putString("link", "https://developers.facebook.com/android");
			postParams.putString("picture", "https://raw.github.com/fbsamples/ios-3.x-howtos/master/Images/iossdk_logo.png");

			Request.Callback callback= new Request.Callback() {
				public void onCompleted(Response response) {
					JSONObject graphResponse = response
							.getGraphObject()
							.getInnerJSONObject();
					String postId = null;
					try {
						postId = graphResponse.getString("id");
					} catch (JSONException e) {
						Log.i(TAG,
								"JSON error "+ e.getMessage());
					}
					FacebookRequestError error = response.getError();
					if (error != null) {
						Toast.makeText(getActivity()
										.getApplicationContext(),
								error.getErrorMessage(),
								Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(getActivity()
										.getApplicationContext(),
								postId,
								Toast.LENGTH_LONG).show();
					}
				}
			};

			Request request = new Request(session, "me/feed", postParams,
					HttpMethod.POST, callback);

			RequestAsyncTask task = new RequestAsyncTask(request);
			task.execute();
		}

	}

	//Call needed for publish story
	private boolean isSubsetOf(Collection<String> subset, Collection<String> superset) {
		for (String string : subset) {
			if (!superset.contains(string)) {
				return false;
			}
		}
		return true;
	}

	/*
	Feed Dialog is another method. Does NOT require the user to have the facebook app installed, but
	also looks more primitive, cannot share to others (other than yourself), and does not allow for
	tagging of your friends.
	 */
	private void publishFeedDialog() {
		Bundle params = new Bundle();
		params.putString("name", "Facebook SDK for Android");
		params.putString("caption", "Build great social apps and get more installs.");
		params.putString("description", "The Facebook SDK for Android makes it easier and faster to develop Facebook integrated Android apps.");
		params.putString("link", "https://developers.facebook.com/android");
		params.putString("picture", "https://raw.github.com/fbsamples/ios-3.x-howtos/master/Images/iossdk_logo.png");

		WebDialog feedDialog = (
				new WebDialog.FeedDialogBuilder(getActivity(),
						Session.getActiveSession(),
						params))
				.setOnCompleteListener(new WebDialog.OnCompleteListener() {

					@Override
					public void onComplete(Bundle values,
					                       FacebookException error) {
						if (error == null) {
							// When the story is posted, echo the success
							// and the post Id.
							final String postId = values.getString("post_id");
							if (postId != null) {
								Toast.makeText(getActivity(),
										"Posted story, id: "+postId,
										Toast.LENGTH_SHORT).show();
							} else {
								// User clicked the Cancel button
								Toast.makeText(getActivity().getApplicationContext(),
										"Publish cancelled",
										Toast.LENGTH_SHORT).show();
							}
						} else if (error instanceof FacebookOperationCanceledException) {
							// User clicked the "x" button
							Toast.makeText(getActivity().getApplicationContext(),
									"Publish cancelled",
									Toast.LENGTH_SHORT).show();
						} else {
							// Generic, ex: network error
							Toast.makeText(getActivity().getApplicationContext(),
									"Error posting story",
									Toast.LENGTH_SHORT).show();
						}
					}

				})
				.build();
		feedDialog.show();
	}

	/*
	This is another method, it is share Dialog. It looks a lot cleaner, requires the facebook app
	to be installed, but has one major flaw in that it allows you to "share on others' timeline"
	which does not work anymore (deprecated)
	 */
	private void publishShareDialog (){
		FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(getActivity())
				.setCaption("Caption Testing 2") //Goes over the front of the picture
				.setLink("http://imgs.xkcd.com/comics/move_fast_and_break_things.png") //Picture 1
				.setPicture("http://imgs.xkcd.com/comics/presidential_alert.png") //Picture 2
				.setDataErrorsFatal(true)
				.build();
		uiHelper.trackPendingDialogCall(shareDialog.present());
	}

	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();

		// Logs 'app deactivate' App Event.
		AppEventsLogger.deactivateApp(getActivity());
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}

	public void onResume() {
		super.onResume();
		uiHelper.onResume();

		/*
		For scenarios where the main activity is launched and user
		session is not null, the session state change notification
		may not be triggered. Trigger it if it's open/closed.
		 */
		Session session = Session.getActiveSession();
		if (session != null &&
				(session.isOpened() || session.isClosed()) ) {
			onSessionStateChange(session, session.getState(), null);
		}

		uiHelper.onResume();

		// Logs 'install' and 'app activate' App Events.
		AppEventsLogger.activateApp(getActivity());
	}


	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		uiHelper.onActivityResult(requestCode, resultCode, data, new FacebookDialog.Callback() {
			@Override
			public void onError(FacebookDialog.PendingCall pendingCall, Exception error, Bundle data) {
				Log.e("Activity", String.format("Error: %s", error.toString()));
			}

			@Override
			public void onComplete(FacebookDialog.PendingCall pendingCall, Bundle data) {
				Log.i("Activity", "Success!");
			}
		});
	}

	//This creates a Hash-Key, which is needed for facebook verification stuff
	private void generateHashKey(){
		try {
			PackageInfo info = getActivity().getPackageManager().getPackageInfo(
					"com.pgmacdesign.facebookexamples",
					PackageManager.GET_SIGNATURES);
			for (Signature signature : info.signatures) {
				MessageDigest md = MessageDigest.getInstance("SHA");
				md.update(signature.toByteArray());
				Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
			}
		} catch (PackageManager.NameNotFoundException e) {
			Log.d("Error", " Creating Key-Hash");
		} catch (NoSuchAlgorithmException e) {
			Log.d("Error", " Creating Key-Hash");
		}
	}

	/*
	XML Layout contains these 2 buttons:
	    <com.facebook.widget.LoginButton
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:id="@+id/facebook_login_button"
        android:layout_centerVertical="true"
        android:layout_centerHorizontal="true"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Post Something Button"
        android:id="@+id/post_something"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"/>

    Must use the facebook layout for the first to get a login option.

    Also, in your strings.xml (under values) include:
    <string name="facebook_app_id">1324567890</string>
    It can be obtained from the facebook dev website.

    Lastly, on the facebook dev website (under quickstart for Android) you will need to fill out
    your hash key information. I have provided a method above that will generate a hash key and
    you can use it for your app release. Method is aptly named: generateHashKey.
	 */
}
