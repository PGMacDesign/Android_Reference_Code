//This will open a link with the default browser, IE, open google.com in chrome or firefox

	try{
		
		//Opens a link directly to my play store download
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
		startActivity(browserIntent);
		
	} catch(Exception e){ 
		e.printStackTrace();
	}  