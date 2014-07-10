//Widgets - TONS of stuff here
//First off, this code needs to go into your manifest
//DO NOT FORGET TO CHANGE .MyWidget IF YOU CHOSE A DIFFERENT CLASS NAME!
	<!-- Widget class  -->
	<receiver 
		android:name=".MyWidget"
		android:label="Name of Widget in Apps" 
		>
		<intent-filter>
			<action android:name="android.appwidget.action.APPWIDGET_UPDATE"/>
		</intent-filter>
		<meta-data 
			android:name="android.appwidget.provider"
			android:resource="@xml/widget_stuff" />    
	</receiver>
	
	<!-- This activity configures the widget -->
	<activity
		android:name=".WidgetConfig"
		android:label="Widget Configuration" >
		<intent-filter>
			<action android:name="android.appwidget.action.APPWIDGET_CONFIGURE"
				/>
		</intent-filter>
	</activity>        
      
	  
//Next, in the Res folder, create (or if exists, use) a folder called XML, create an XML class there. Just name it widget_stuff.xml. Then copy this code in
	<?xml version="1.0" encoding="utf-8"?>
	<appwidget-provider 
		xmlns:android="http://schemas.android.com/apk/res/android" 
		android:configure="com.Your.Package.WidgetConfig" 
		android:minWidth="40dp" 
		android:minResizeHeight="40dp" 
		android:minHeight="40dp" 
		android:minResizeWidth="40dp"
		android:updatePeriodMillis="1800000"
		android:resizeMode="horizontal|vertical">
	   <!-- 1,800,000 milliseconds is a 1/2 hour. Updates every 0.5 hours --> 
	</appwidget-provider>
		  
		  
//This shows how to Create a widget. Use this within the class you want the widget made in
			
	public class WidgetConfig extends Activity {
		
		//Define these as global variables
		int awID;
		AppWidgetManager awm;
		Context c;
		
		//Doing this part within an onCreate, but can be done elsewhere
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.NAME_OF_WIDGET_XML_LAYOUT_YOU_ARE_USING);

			c = Name_Of_Your_Class.this;
			
			info = (EditText) findViewById(R.id.edit_text_widget_config);
			
			//An intent is opening this class, therefore, must make one
			Intent i = getIntent();
			
			//Create a bundle since info is being passed around (Which app launched this activity)
			Bundle extras = i.getExtras();
			
			//As long as the extras had something, setup the app widget id
			if (extras != null){
				//Get an ID and pass it in. IE, a way to checking which widget activated this class
				awID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
				//This returns 1 App widget ID
			} else {
				//In case something gets a-broken!
				finish();
			}
			
			awm = AppWidgetManager.getInstance(c); 	
		
			createTheWidget(); //You may want to put this as a button instead of inside the onCreate. 
		}
		
		//This creates the actual widget
		public void createTheWidget(){
			
			//If you need to get info from EditText windows, do so first. 
			
			//Setup a remoteview referring to the context and relating to the widget
			RemoteViews v1 = new RemoteViews(c.getPackageName(), R.layout.NAME_OF_WIDGET_XML_LAYOUT_YOU_ARE_USING);
			
			//Set the remote view (remote meaning on the homescreen widget) to any TextViews setup within the widget.xml (AKA NAME_OF_WIDGET_XML_LAYOUT_YOU_ARE_USING)
			//v1.setTextViewText(R.id.text_view_config_input, "String and whatnot");
			
			//This intent opens a class when clicked. Again, note C for context
			Intent intent = new Intent(c, Name_Of_Class_You_Want_To_Open.class);
			
			//A pending intent is also needed. Again, note the C for context
			PendingIntent pendingIntent = PendingIntent.getActivity(c, 0, intent, 0);
			
			//If you have a button within the widget icon, link it to an ID here
			v1.setOnClickPendingIntent(R.id.button_widget_id_in_xml, pendingIntent);	
			
			//Update the widget with the remote view
			awm.updateAppWidget(awID, v1);
			
			//Lastly, need to set a result
			Intent result = new Intent();
			
			//Updating the ID that is being called
			result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, awID);
			
			//Confirm the result works then set it
			setResult(RESULT_OK, result);
			
			//We want this to finish. Might be smart to include this when the button is clicked so that the user can choose when to end it
			finish();
		}
	}

//This shows how to Update a widget. First make the widget class
	public class MyWidget extends AppWidgetProvider{

		//When the widget is deleted, this will run, pop up window 
		public void onDeleted(Context context, int[] appWidgetIds) {
			super.onDeleted(context, appWidgetIds);
			Toast.makeText(context, "Widget removed", Toast.LENGTH_SHORT).show();
			//Or do whatever here
		}

		/*
		 * When the widget updates (Every 1/2 hour in this example) @Params:
		 *1) Context - Package name to refer to intents/ layouts
		 *2) Appwidgetmanager - Refer to for update
		 *3) AppwidgetIDs - Reference multiple IDs (IE in xml, 2 textViews or EditTexts) 
		 */
		public void onUpdate(Context context, AppWidgetManager appWidgetManager,
				int[] appWidgetIds) {

			super.onUpdate(context, appWidgetManager, appWidgetIds);
			
			//Amount of IDs entered
			final int N = appWidgetIds.length;
			
			for (int i = 0; i < N; i++){
				
				int app_widget_ID = appWidgetIds[i];
				//
				RemoteViews v = new RemoteViews(context.getPackageName(), R.layout.NAME_OF_WIDGET_XML_LAYOUT_YOU_ARE_USING);
				
				//Make changes here to UI. For example
				v.setTextViewText(R.id.text_view_widget_id, "Words and Stuff!");
				
				//Calls the method to update the widget. Affects this specific view
				appWidgetManager.updateAppWidget(app_widget_ID, v);
			}	
		}
	}

//Lastly, these are some sample XML layouts that can be used
	
	//widget.xml
		<?xml version="1.0" encoding="utf-8"?>
		<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:orientation="vertical" >

			<TextView
				android:id="@+id/text_view_config_input"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:text="TextView" />

			<Button
				android:id="@+id/button_widget_open"
				style="?android:attr/buttonStyleSmall"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:text="Button" />

			<TextView
				android:id="@+id/text_view_widget_update"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:text=" " />


		</LinearLayout>

	//widgetconfig.xml -- This is if you want the user to type something to go into the widget itself. IE a message or something that will edit a TextView/ EditText
		<?xml version="1.0" encoding="utf-8"?>
		<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
			android:layout_width="match_parent"
			android:layout_height="match_parent"
			android:orientation="vertical" >

			<TextView
				android:id="@+id/textView1"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"
				android:layout_gravity="center"
				android:text="Enter the text you want above the widget" />

			<EditText
				android:id="@+id/edit_text_widget_config"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:ems="10" >

			</EditText>

			<Button
				android:id="@+id/button_widget_config"
				android:layout_width="match_parent"
				android:layout_height="wrap_content"
				android:text="Button" />

		</LinearLayout>
