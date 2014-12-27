//Popup a dialog after 3 seconds with option to start directions
	Handler handler = new Handler(); 
	handler.postDelayed(new Runnable() { 
		 public void run() { 
			 
			 //
			 callTheMethodHereYouWant();
			 //
		 } 
	}, (1000*3));