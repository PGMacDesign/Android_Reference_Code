//This utilizes the camera function on the phone. First Create an int 
	//This is a variable for return data from the camera. 
	final static int camera_Data = 0;
	
//Next call the intent that will use the camera
	//This accesses the 'MediaStore' which houses the info for taking pictures
	intent1 = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	
	//We want to start the activity, but also to return data
	//@ Parameters, 1st passes in intent, second is variable return data is stored in
	startActivityForResult(intent1, camera_Data);
	
//It calls this method, which can then perform actions with the image
	//@Params, request code, result code, intent to pass in
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		super.onActivityResult(requestCode, resultCode, data);
		
		//This translates to = "If result comes out ok then, "
		if (resultCode == RESULT_OK){
			Bundle extras = data.getExtras();
			
			//Create the bitmap. Make a global var if using elsewhere
			Bitmap bmp;
			bmp = (Bitmap) extras.get("data");
			
			//Now that you have the image, do what you want with it. IE, set an ImageView
			image_View.setImageBitmap(bmp);
			
		}
		
	}