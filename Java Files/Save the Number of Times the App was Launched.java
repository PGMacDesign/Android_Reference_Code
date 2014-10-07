//Saves the amount of times that the app has been launched on the phone. Can be used for things like, "Rate my app!"
SharedPreferences prefs1 = mContext.getSharedPreferences("PREFS", 0);
launched_times = prefs1.getInt("launched_times",0);
Log.i("______launched times________", String.valueOf(launched_times));
SharedPreferences.Editor editor = prefs1.edit();
editor.putInt("launched_times",launched_times+1);
editor.commit();