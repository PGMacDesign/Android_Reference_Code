//This code is to setup a spinner (Drop down menu)

//This code goes in your global variables
	//Spinners
		Spinner choice_spinner;
		String[]color_choices = {"Red", "Blue", "Green", "Orange", "Yellow", "Indigo"};
		
//This code goes in the Initialize() or onCreate() method
	//Array Adapter for Spinner use with the daily tab
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, daily_paths); //The android.R.layout.simple_spinner_item is embedded system
	
	//Spinner setup
		choice_spinner = (Spinner) findViewById(R.id.name_of_spinner_in_xml); 
		choice_spinner.setAdapter(adapter);
		choice_spinner.setOnItemSelectedListener(this);
		
//This code is outside of the onCreate() method in its own. Should be implemented (IE implements View.OnClickListener, OnItemSelectedListener )

	//When an item is selected with the spinner
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	
		//Position variable to determine which option the spinner is pointing to
		int position = choice_spinner.getSelectedItemPosition();
		
		switch (position){
		
		//Red
		case 0:
			//Color Red chosen			
			break;
			
		//Blue
		case 1:
			//Color Blue chosen	
			break;
			
		//Green
		case 2:
			//Color Green chosen
			break;
							
		//Orange
		case 3:
			//Color Orange chosen	
			break;
			
		//Yellow
		case 4:
			//Color Yellow chosen	
			break;	
			
		//Indigo
		case 5:
			//Color Indigo chosen
			break;							
		}
	}