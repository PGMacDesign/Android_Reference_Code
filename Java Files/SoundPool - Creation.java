/*
This class will create a SoundPool, which is a grouping of short sounds (Like recordings) and runs them through
a randomized array sorter to activate them in a random order. It does not have to be random, just did that here
*/

//Global Variables

	//Sound pool
	SoundPool sp;
	private HashMap<Integer, Integer> soundMap;
	
	//Choices
	int yes = 1;
	int no = 2; 
	int maybe = 3;
	
	int fSpeed = 1;
	
	//Random number generator
	Random myRandom = new Random();
	
	//Used in cycling through the array of choices
	int hit;
	
	//Define within the onCreate method
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.magic_ball);
		
		sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 100);
		soundMap = new HashMap<Integer, Integer>();
		
		soundMap.put(yes, sp.load(this, R.raw.short_sound_clip_1, 1));   
		soundMap.put(no, sp.load(this, R.raw.short_sound_clip_1, 2));
		soundMap.put(maybe, sp.load(this, R.raw.short_sound_clip_3, 1));


	}

	//The sound byte can be activated via any method, but here I am using a button click

	public void onClick(View arg0) {
		switch (arg0.getId()){
		case R.id.button_clicked_from_xml:
			hit = myRandom.nextInt(3)+1;
			sp.play(hit, 1, 1, 0, 0, 1);
			break;
		}
	}