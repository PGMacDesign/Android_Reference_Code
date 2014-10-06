//Check if device has internet 

public static boolean isOnline(Context ctx) {
	ConnectivityManager cm = (ConnectivityManager)
	ctx.getSystemService(DUtils.CONNECTIVITY_SERVICE);
	NetworkInfo netInfo = cm.getActiveNetworkInfo();
	if (netInfo != null && netInfo.isConnectedOrConnecting()) {
		return true;
	} else {
		return false; 
	}
}