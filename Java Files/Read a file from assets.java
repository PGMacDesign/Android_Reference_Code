//Assets is a folder similar to res. The biggest difference is best defined here: http://stackoverflow.com/questions/5583608/difference-between-res-and-assets-directories  
//Defined as: The assets directory is more like a filesystem and provides more freedom to put any file you would like in there. You then can access each of the files in that system as you would when accessing any file in any file system through Java. This directory is good for things such as game details, dictionaries,...etc
//This is how to access and read from said directory

public static String getQuestions(Context ctx, String file_name) {
	AssetManager assetManager = ctx.getAssets();
	ByteArrayOutputStream outputStream = null;
	InputStream inputStream = null;
	
	try {
		inputStream = assetManager.open(file_name);
		outputStream = new ByteArrayOutputStream();
		byte buf[] = new byte[1024];
		int len;
		
		try {
			while ((len = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, len);
			}
			
			outputStream.close();
			inputStream.close();
		} catch (IOException e) {
			//Log the exception if need be
		}
	} catch (IOException e) {
		//Log the exception if need be
	}
	
	return outputStream.toString();
}