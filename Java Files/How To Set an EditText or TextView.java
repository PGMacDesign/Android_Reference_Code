//First make the EditText Variable. Making it global in this example

EditText et;

TextView tv;

//Then in your onCreate() or Initialize() method, define it with link to xml
et = (EditText) findViewById(R.id.name_of_id_in_xml_code_1);

tv = (TextView) findViewById(R.id.name_of_id_in_xml_code_2);

//Lastly, set the text fields as you so desire in other areas of code


et.setText("0"); //In XML, this is defined as String, therefore, fill it with "x" 
tv.setText("stuff"); //Same as above