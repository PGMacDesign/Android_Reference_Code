
/*
This is similar to the other soundpool .java file but is designed for multiple
clicks to do more sounds. Also, differentiates between long-pressing for sounds.
*/

//Global Variables

	SoundPool sp;
	private HashMap<Integer, Integer> soundMap;
	
	//For sound marking
	int sound1 = 1;
	int sound2 = 2; 
	
	int fSpeed = 1;
	
	//Object for Media player
	MediaPlayer pew;
	
	Random myRandom = new Random();
	int hit = myRandom.nextInt(4)+1;
	
//In the main onCreate()
protected void onCreate(Bundle savedInstanceState) {
		
		//Creating a new view
		View v = new View(this);
		v.setOnClickListener(this);
		v.setOnLongClickListener(this); //Using the same for regular and long-click
		
		/*
		Creates a sound pool. @Parameters
		1st is max stream (Number of sounds allowed at same time)
		2nd is way to stream audio, (STREAM_MUSIC) is standard 
		3rd is sample rate. 0 is default, fairly useless atm
		*/
		sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 100);
		
		//Hashmap input for sound choices
		soundMap = new HashMap<Integer, Integer>();
		
		soundMap.put(sound1, sp.load(this, R.raw.SOUND_BYTE_NAME_USE_LOWERCASE, 1));
		soundMap.put(sound2, sp.load(this, R.raw.SOUND_BYTE_NAME_USE_LOWERCASE, 1));
		
		//Mediaplayer is for the long press. Can use soundmap for long press as well.
		pew = MediaPlayer.create(this, R.raw.pew_pew);
	}

//In the onClick() method
	public void onClick(View arg0) {
	
		Random myRandom = new Random();
		//2 Items in the hashmap. Change that according to soundMap size
		int hit = myRandom.nextInt(2)+1;
		
		/* 
		Plays the sounds. @ Parameters:
		1st is sound ID to play
		2nd is left volume (range 0.0 - 1.0)
		3rd is right volume (range 0.0 - 1.0)
		4th is priority (0 is lowest priority)
		5th is loop (0 = no loop | -1 = loop forever)
		6th is rate playback rate (1.0 = normal)(Range is 0.5-2.0)
		*/
		sp.play(hit, 1, 1, 0, 0, 1);
	}
	
//Long press it will call this method and it will call the mediaPlayer
	public boolean onLongClick(View arg0) {
		//MediaPlayer instead of the soundPool
		pew.start();
		return false;
	}	