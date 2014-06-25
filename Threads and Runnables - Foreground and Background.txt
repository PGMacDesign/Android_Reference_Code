//Threads and Runnables

//Declare the Handler First
	Handler myHandler = new Handler();

//Call this somewhere in the code, IE onCreate or within a button click
	onStart(); //This will run automatically after the onCreate is made. It can be run again by setting this within the onClick portion of a button

//Using the onStart() will call this function:
	protected void onStart() {
		super.onStart();
		//Prepare UI components
		btnDoItAgain.setEnabled(false); //If you clicked a button to get here, disable it so they cannot click it again
		
		//Create background thread were the busy work will be done
		Thread myBackgroundThread = new Thread( backgroundTask, "backAlias1" );
		myBackgroundThread.start();
	}

// FOREGROUND
	// this foreground Runnable works on behave of the background thread
	// updating the main UI which is unreachable to it
	private Runnable foregroundRunnable = new Runnable() {
		public void run() {
			try {
				
				//Update UI, observe globalVar is changed in back thread
				//Change the textView here
				//Change other UI settings here				
				//Advance ProgressBars
				
				} 
			} catch (Exception e) {
				Log.e("<<foregroundTask>>", e.getMessage()); //Log the error messages
			}
		}
	}; // foregroundTask
	 
	
//BACKGROUND
	//This is the back runnable that executes the slow work
	private Runnable backgroundTask = new Runnable() {
		public void run() {
			//busy work goes here...
			try {
				for (int n = 0; n <= 20; n++) {
					
					///Do complicated calculations here, IE database calculations
					
					//Change a global variable from here...
					globalVar++;
					
					//Post to the foreground by running the foreground method
					//Wake up foregroundRunnable delegate to speak for you
					myHandler.post(foregroundRunnable);
				}
			} catch (InterruptedException e) {
				Log.e("<<foregroundTask>>", e.getMessage()); //Log the error messages
			}
		}// run
	};// backgroundTask
