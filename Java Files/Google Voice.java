public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	/* Call Activity to Open Google Voice */
	Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	
	try {
		startActivityForResult(intent, 1);
	} catch (ActivityNotFoundException a) {
		Log.d("LOG",a.getMessage());
	}
}


public void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);
	switch (requestCode) {
		case 1: {
			if (resultCode == Activity.RESULT_OK && null != data) {
				ArrayList text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
				Log.d("LOG","You have speak : "+text,get(0));
			}
			break;
		}
	}
}