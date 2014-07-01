//This is to add a notification reminder in the notification bar on top of the screen. 
//It is being activated via a button click here

	button.setOnClickListener(new OnClickListener(){
		public void onClick(View v){

			//Do what needs to be done here to save data (IE shared preferences) if need be
			addNotification(); //This calls the method for adding a notification
			finish();
		}
	});
		
//This code will go outside of the onCreate() method.
	//This will add the notification. 	
	public void addNotification() {

		String title = "Reminder:";
    	String body = "Go back and finish!";
		
	    NotificationCompat.Builder builder =  
	            new NotificationCompat.Builder(this)  
	            .setSmallIcon(R.drawable.choose_a_picture_here)  //But remember to keep the size in pixels at about 27x27
	            .setContentTitle(title)  
	            .setContentText(body);  

	    //Change what you want opened here in the second Parameter
	    Intent notificationIntent = new Intent(this, NameOfYourClass.class); //This will open up a specific class in the app
	    PendingIntent intent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);  
	    builder.setContentIntent(intent);  
	
	    //Add as notification  
	    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
	    manager.notify(uniqueID, builder.build());  
    } 
	
	//This will remove a notification from the notification bar. 
	private void removeNotification() {  
	    NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  
	    manager.cancel(uniqueID);  
	}
	
//Lastly, MAKE SURE this is in the onCreate() or onResume() of the class that is being called when the reminder is clicked else it will never be removed!
	removeNotification();