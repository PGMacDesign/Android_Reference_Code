/*
This code should be used when making calculations or taking information from editText fields to confirm
that the fields actually have data in them and are not being left blank
*/

//If a String
	String test1;
	if (editText.getText().toString().equals("")){
		test1 = ""; //Default value in case it is left blank
	} else {
		daily_hour_start = editText.getText().toString();
	}
	
//If an Integer
	int test2;
	if (editText.getText().toString().equals("")){
		test2 = 0; //Default value in case it is left blank
	} else {
		test2 = Integer.parseInt(editText.getText().toString());
	}
	
//If a Double
	double test3;
	if (editText.getText().toString().equals("")){
		test3 = 0.0; //Default value in case it is left blank
	} else {
		test3 = Double.parseDouble(editText.getText().toString());
	}