//This is to setup a simple splash screen. It has both Java and the XML code listed

//Java code
	import android.app.Activity;
	import android.content.Intent;
	import android.content.SharedPreferences;
	import android.media.MediaPlayer;
	import android.os.Bundle;
	import android.preference.PreferenceManager;

	public class SplashScreen extends Activity {

	MediaPlayer ourIntroSong;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			setContentView(R.layout.splash);
			
			//Remember: Sound pool used for small clips (gun, explosion, etc.) and Media player used for larger clips (background music)
			ourIntroSong = MediaPlayer.create(SplashScreen.this, R.raw.short_clip_used_for_intro_music);;
			
			//getPrefs variable to determine if they have turned off the music preference in the introduction
			SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
			boolean music = getPrefs.getBoolean("checkBox", true);
			if (music == true){
				ourIntroSong.start();
			}
		
			//Determines length of time splash screen is open
			Thread thread = new Thread() {
				public void run() {
					try {
						//In Milliseconds, set to 3 seconds at this point
						sleep(1000 * 3);
					} catch (InterruptedException e01) {
						e01.printStackTrace();
					} finally {
						//After thread has run, transition to main class for menu options
						Intent intent = new Intent("com.package.name.MAIN");
						startActivity(intent);
					}
				}
			};
			thread.start();
			
		}

		@Override
		protected void onPause() {
			super.onPause();
			
			//This kills the music so it isn't carried over between splash screens
			ourIntroSong.release();
			
			finish(); 
		}	
	}
	
//splash.xml
	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:tools="http://schemas.android.com/tools"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:orientation="vertical" 
		tools:context=".Main"
		android:background="@drawable/logo_or_initial_picture_from_drawable_folder"
		>

	</LinearLayout>
