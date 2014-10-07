//
/**
* Method to read in a text file placed in the res/raw directory of the
* application. The method reads in all lines of the file sequentially.
*/
public static void readRaw(Context ctx, int res_id) {
	
	InputStream is = ctx.getResources().openRawResource(res_id);
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr, 8192); // 2nd arg is buffer size
	// More efficient (less readable) implementation of above is the
	// composite expression
	/*
	* BufferedReader br = new BufferedReader(new InputStreamReader(
	* this.getResources().openRawResource(R.raw.textfile)), 8192);
	*/
	try {
		String test;
		while (true) {
			test = br.readLine();
			// readLine() returns null if no more lines in the file
			if (test == null)
			break;
		}
			isr.close();
			is.close();
			br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}