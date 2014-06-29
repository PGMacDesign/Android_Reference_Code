//This will make a toast of type short. Change short to long for longer timeouts.

	//Simple class that makes a popup (toast) with the activity name the user chose
	public void makeToast(String string){
		Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
	}
	
	//Example of usage
	makeToast("oh hai!");