//Code is used for ending an app/ program after X amount of seconds. Call it wherever, just make sure to add the number of seconds when you want it to end

//Call this wherever
callFinishAfter(10); //This basically means that 10 seconds after this method is called, the app will close (finish()) and it will close it. Code can be altered within the run() method if need be

public void callFinishAfter(int seconds){
	L.m("Seconds total: " + 1000*seconds);
	Handler handler = new Handler(); 
	handler.postDelayed(new Runnable() { 
		 public void run() { 
			 
			 //
			 finish();
			 L.m("Finish called");
			 //
		 } 
	}, (1000*seconds));
}