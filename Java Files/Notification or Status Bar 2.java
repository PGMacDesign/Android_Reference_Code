//On the top of the device is the notification / status bar. This will create an icon on the top
	//Do this code in either a separate method, or a callback method
		//On the top of the device is the notification / status bar. This will create an icon on the top

		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager mNotificationManager = (NotificationManager)getSystemService(ns);
		
		//Icon for the notification bar
		int icon = R.drawable.ic_launcher;
		
		CharSequence showText = "TEXT GOES HERE 1";
		long time = System.currentTimeMillis();
		
		Notification notification = new Notification(icon, showText, time);
		CharSequence contentTitle = "TEXT GOES HERE 2";
		CharSequence contentText = "TEXT GOES HERE 3";
		
		Intent notifIntent = new Intent(context, NAMEOFCLASS.class);
		
		notification.flags = Notification.FLAG_ONGOING_EVENT;
		notification.flags |= Notification.FLAG_NO_CLEAR;
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notifIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_SINGLE_TOP);
		
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notifIntent, PendingIntent.FLAG_CANCEL_CURRENT);
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		mNotificationManager.notify(1337, notification);
		//--------------------
	}
	
	//Removes the notification. MAKE SURE TO CALL THIS when the activity opens so that your icon will clear!!!
	public void clearNotification() {
		try {
			NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
			notificationManager.cancel(1337);
		} catch (Exception ex) {
			//Log the exception
		}
	}