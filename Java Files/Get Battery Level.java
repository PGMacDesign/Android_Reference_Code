//this makes a broadcast receiver which will determine the battery level
private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
	public void onReceive(Context ctx, Intent intent) {
		int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
		Log.i("Battery Level", String.valueOf(level) + "%");
	}
};