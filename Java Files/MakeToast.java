//This will make a toast of type short. Change short to long for longer timeouts.

	//Simple class that makes a popup (toast) with the activity name the user chose
	public void makeToast(String string){
		Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
	}
	
	//Example of usage
	makeToast("oh hai!");
	
	
// Can also make a toast that alters the location of it. IE
Toast toast = Toast.makeText(context, "In Center", Toast.LENGTH_LONG);

toast.setGravity(Gravity.TOP, 0, 0); //For Top
toast.setGravity(Gravity.CENTER, 0, 0); //For Center

toast.show(); //Show it after you have defined the location. Defaults to the bottom for the toast