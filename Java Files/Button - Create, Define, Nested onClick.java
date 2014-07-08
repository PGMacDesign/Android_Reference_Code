//First define the button. I am doing it as a global so it can be used for different methods.

Button button1;

//Next define it in your onCreate() or Initialize() methods

button1 = (Button) findViewById(R.id.button_id_defined_in_xml_code);
//Lastly, right after defining it as above, set it to an onClickListener so it can be clicked.
button1.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				
				//Code here will determine what the button does
				
			}
		});

//The above code 