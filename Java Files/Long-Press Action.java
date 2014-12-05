//This will show long pressing and how to create an action from it
	
//Going to create a MediaPlayer object so we have something to use	
//Object for Media player
MediaPlayer pew;

protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.test);
	
	//Creating a new view
	View v = new View(this);
	
	v.setOnClickListener(this); //For the normal click listener
	
	//OnLongClickListener for when you long press on the screen
	v.setOnLongClickListener(this);
	
	setContentView(v);
	//Reference the item you are using via the raw folder
	pew = MediaPlayer.create(this, R.raw.pew_pew);
}




	//This activity is for what happens when the long press occurs
	public boolean onLongClick(View arg0) {
		
		//Action here, IE, start an activity
		pew.start();
		return false;
	}
