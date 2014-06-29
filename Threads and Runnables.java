//The onStart() will be called after the onCreate() has been established
	public void onStart(){
		super.onStart();
		
		//Creates the background activity where work is done
		Thread backgroundThread = new Thread (new Runnable(){
			public void run(){
				try{
					
					//Do stuff in the background
					
					
				} catch (Throwable t) {
					//Catch the throwable here
					}
				}
		});
			
			isRunning = true;
			backgroundThread.start();
		}//onStart