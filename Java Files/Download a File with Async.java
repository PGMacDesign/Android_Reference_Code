//This will download a file using Async to run in the background via multi-threading
private class DownloadSong extends AsyncTask<String, Integer, Boolean> {
	private String source;
	private String download_mp3_link = "";
	private String song_title = "";
	protected Boolean doInBackground(String... params) {
	
		String DownloadUrl = params[0];
		String fileName = params[1];
		
		try {
			File root = android.os.Environment.getExternalStorageDirectory();
			File dir = new File(root.getAbsolutePath() + "/MusicFree");
			
			if (dir.exists() == false) {
				dir.mkdirs();
			}
			
			URL url = new URL(DownloadUrl); // you can write here any link
			File file = new File(dir, fileName);
			song_title = fileName;
			long startTime = System.currentTimeMillis();
			Log.d("DownloadManager", "download begining");
			Log.d("DownloadManager", "download url:" + url);
			Log.d("DownloadManager", "downloaded file name:" + fileName);
			
			/* Open a connection to that URL. */
			URLConnection ucon = url.openConnection();
			
			/*
			* Define InputStreams to read from the URLConnection.
			*/
			
			InputStream input = ucon.getInputStream();
			int fileLength = ucon.getContentLength();
			OutputStream output = new FileOutputStream(root.getAbsolutePath() + "/MusicFree/" + fileName + ".mp3");
			download_mp3_link = (root.getAbsolutePath() + "/MusicFree/" + fileName + ".mp3");
			byte data[] = new byte[1024];
			long total = 0;
			int count;
			
			while ((count = input.read(data)) != -1) {
				total += count;
				// publishing the progress....
				publishProgress((int) (total * 100 / fileLength));
				output.write(data, 0, count);
			}
			
			output.flush();
			output.close();
			input.close();
			return true;
			
		} catch (IOException e) {
			Log.d("DownloadManager", "Error: " + e);
			return false;
		}
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
		mProgressDialog.setProgress(values[0]);
		/*
		contentText = String.valueOf(values[0]) + "% complete";
		notification.setLatestEventInfo(getApplicationContext(), contentTitle, contentText,
		contentIntent);
		notificationManager.notify(HELLO_ID, notification);
		*/
	}
	
	protected void onPreExecute() {
		super.onPreExecute();
		mProgressDialog.show();
		// ------ taskbar notification ---------
		/*
		String ns = Context.NOTIFICATION_SERVICE;
		notificationManager = (NotificationManager) getSystemService(ns);
		icon = R.drawable.ic_launcher;
		tickerText = "Downloading...";
		time = System.currentTimeMillis();
		notification = new Notification(icon, tickerText, time);
		contentTitle = "MusicFree download in progress";
		contentText = "0% complete";
		Intent notificationIntent = new Intent(Intent.ACTION_VIEW);
		notificationIntent.setDataAndType(Uri.fromFile(new
		File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() +
		"/MusicFree/"+song_name+".mp3")), "audio/*");
		contentIntent = PendingIntent.getActivity(getApplicationContext(), 0,
		notificationIntent, 0);
		notification.setLatestEventInfo(getApplicationContext(), contentTitle, contentText,
		contentIntent);
		notificationManager.notify(HELLO_ID, notification);
		*/
	}
	protected void onPostExecute(Boolean result) {
		super.onPostExecute(result);
		if (result) {
			Toast.makeText(mContext, "file downloaded to SDcard/MusicFree",
			Toast.LENGTH_LONG).show();
		}
		
		try {
			mProgressDialog.dismiss();
		} catch (Exception e) {
			Log.e("EXCEPTION", "!!!!");
		}
	}
}