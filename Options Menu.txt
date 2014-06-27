/*
This is designed to create a popup window of options. It is specifically activated when someone presses
the menu button. 
*/

	//This goes outside of the onCreate() method as a separate method
	//Creates a boolean where the user hits the menu/ settings/ 3 little line button/ checkerbox (on the old Droid X).
	public boolean onCreateOptionsMenu(android.view.Menu menu_settings) {
	
		//menu inflater 
		MenuInflater blowUp = getMenuInflater(); 
		blowUp.inflate(R.menu.cool_menu, menu_settings);
		return true;
		
	}
	
	//This will determine which option they click and act appropriately
	//When the menu button is pressed (boolean above) a mini-menu opens up with these options
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		
		case R.id.aboutus:
			//Bring up a page with about us information
			//Do stuff here. create an intent, popup, whatevs
			startActivity(intent1);
			
			break;
			
		case R.id.preferences:
			//Bring up a page for the user to adjust preferences
			Intent intent2 = new Intent("com.package.name.CLASS"); //Note all capitals
			startActivity(intent2);		
			break;
			
		case R.id.send_Bug_Report:
			//Do bug reporting stuff
			//Send an email, log something, enter info to database, create an intent
			startActivity(intent3);	
			break;
						
		case R.id.Exit:
			//Exits / Closes the application
			finish();
			
			break;
		}
		
		return false;
	}
	
	
	//Use this code in the the res -> menu folder
	
	//cool_menu.xml
	<?xml version="1.0" encoding="utf-8"?>
	<menu xmlns:android="http://schemas.android.com/apk/res/android" >
		
		<!-- This menu is for when someone hits menu/ 3 lines/ options 
		on their android and it usually gives preferences/ about us info-->
		
		<item
			android:id="@+id/aboutus"
			android:title="About Us"
			android:numericShortcut="1"
			android:alphabeticShortcut="a"
			/>
		<!-- Numeric shortcut (hit 1) or alphabetic (a) for opening -->
			
		<item
			android:id="@+id/preferences"
			android:title="Preferences"
			/>
		
		<item
			android:id="@+id/send_Bug_Report"
			android:title="Send Bug Report"
			/>
		
		<item
			android:id="@+id/Exit"
			android:title="Exit"
			/>
	</menu>
	
	//These layouts go into the standard res -> layout folder
	//about_us.xml
	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:orientation="vertical" >
		
		<TextView
			android:layout_height="wrap_content"
			android:layout_width="wrap_content"
			android:text="Text goes here">
		</TextView>
			

	</LinearLayout>