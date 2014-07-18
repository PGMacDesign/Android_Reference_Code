//This is how to create a method that will take a voice input and convert it to text

//First part I am doing on the onClick(), but it can be done anywhere really
public void onClick(View v) {
		//Must use both of these lines below in Speech recogniztion!
		
		//Create an intent first to recognize speech
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		
		//Determine which language is being spoken
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		
		//Optional
		//Prompt to come up when the speaking voice icon pops up. 
		i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Wait for the beep before you start speaking");
		
		//Passing in the request code (check)
		startActivityForResult(i, check);
		
	}
	
//This method (ActivityForResult) is called
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == check && resultCode == RESULT_OK){
			
			//Collect data from the voice results and put them into an ArrayList of type String
			ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			
			//Now it can be converted to 1 string, IE:
			String uberString = "";
			for (int i = 0; i< results.size(); i++){
				uberString = results.get(0).toString(); //Takes the first one in the array
			}
		
			//Or, you can put them into a list view for the user to see/ click
			//Note, need to create these in the onCreate() method
			ListView lv;
			lv = (ListView)findViewById(R.id.XML_LISTVIEW_ID)
			//These two line should be in the onCreate() method, then go below to next
			
			lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results));4
		}
		
		super.onActivityResult(requestCode, resultCode, data);
	}