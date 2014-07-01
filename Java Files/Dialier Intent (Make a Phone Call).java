
//This is to make a phone call. It will send the user to the dial screen of their respective phone with the #

	Intent intent = new Intent(Intent.ACTION_DIAL);
	intent.setData(Uri.parse("tel:8001234567")); //Place number here for call out
	startActivity(intent); 