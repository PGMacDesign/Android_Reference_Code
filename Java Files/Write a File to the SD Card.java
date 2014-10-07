public static Boolean writeToSDFile(String directory, String file_name, String text) {
	// Find the root of the external storage.
	// See
	// http://developer.android.com/guide/topics/data/data-storage.html#filesExternal
	
	File root = Environment.getExternalStorageDirectory();
	// See
	// http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder
	
	File dir = new File(root.getAbsolutePath() + "/" + directory);
	dir.mkdirs();
	File file = new File(dir, file_name);
	
	try {
	
		FileOutputStream f = new FileOutputStream(file);
		PrintWriter pw = new PrintWriter(f);
		pw.println(text);
		pw.flush();
		pw.close();
		f.close();
		// Log.v("File Writing", "file written to sd card");
		return true;
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		// Log.i(TAG, "******* File not found. Did you" + " add a WRITE_EXTERNAL_STORAGE permission to the manifest?");
		return false;
	} catch (IOException e) {
		e.printStackTrace();
	return false;
	}
}