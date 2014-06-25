//Video View (IE, IE Mp4 or WMA format). Copy the file into the res/raw folder

	//XML code
		<VideoView android:layout_height="wrap_content"
			android:layout_width="wrap_content"
			android:id="@+id/videoView"  />
			
	//Java Code
		VideoView vv = (VideoView)this.findViewById(R.id.videoView);
		String fileName = "android.resource://" + getPackageName() + "/" + R.raw.my_video;
		vv.setVideoURI(Uri.parse(fileName));
		vv.start();


//Different method for embedding a youtube link for a video (intent out)

	String video_path = "http://www.youtube.com/watch_LINK_GOES_HERE";
	Uri uri = Uri.parse(video_path);

	// With this line the Youtube application, if installed, will launch immediately.
	// Without it you will be prompted with a list of the application to choose.
	uri = Uri.parse("vnd.youtube:"  + uri.getQueryParameter("v"));

	Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	startActivity(intent);