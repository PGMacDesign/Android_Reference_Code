//This is for making an alert popup. It will overlay the screen with a window that will give them options

DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
	
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
		
			case DialogInterface.BUTTON_NEGATIVE:
				
				try {
					//mp.stop();
					//mp.release();
				} catch (Exception e) {
					Log.e("EXCEPTION", "can't stop player");
				}
				try {
					//clearNotification();
				} catch (Exception ex) {
				}
				
				//This next section basically creates a random int from 0-1 where 50% of the time they get adds (If you have an activity with ads)
				Random rand = new Random();
				int r_nr = rand.nextInt(2);
				if (r_nr == 1) {
					//startActivity(new Intent(mContext, ActivityAds.class)); //Starts an activity with adds if they choose not to rate it 50% of the time
				}
				
				//finish();
				break;
			case DialogInterface.BUTTON_POSITIVE:
				String app_url = "https://www.yourappurlgoeshere";
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(app_url));
				startActivity(browserIntent);
				Toast.makeText(getApplicationContext(), "Thank You Very Much!", Toast.LENGTH_LONG).show();
				break;
		}
	}
};
	
String rate_me = "Would you please rate this app? \nI would greatly appreciate it!";
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setMessage(rate_me).setNegativeButton("No   :(", dialogClickListener).setPositiveButton("Yes   :)", dialogClickListener).show();
