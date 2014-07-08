//This activity shows how to utilize bundles to send data between classes via intents

//This section of code is from the class the data is being transferred FROM
	//First make the bundle object you will be using
	Bundle basket = new Bundle(); //Think basket as it is carrying data

	//Next get some things you want carried over
	String str = "She is a perfect ";
	int rank = 10;
	String str2 = "/nWhat do you think?";
	double rank2 = 9.5;

	//Add these items to the Bundle object
	basket.putString("key_or_label_name_1", str);
	basket.putInt("key_or_label_name_2", rank);
	basket.putString("key_or_label_name_3", str2);
	basket.putDouble("key_or_label_name_4", rank2);

	//Create the intent to pass the data
	Intent intent = new Intent(Name_Of_Current_Class.this, Class_That_Will_Be_Opened.Class);

	//Add the data we made above into the intent
	intent.putExtras(basket); 
	//Start the activity to open the class (IE via a button click)
	startActivity(intent);
	
//This section of code is from the class the data is being transferred TO
	//In the new class, first you make a bundle object to receive the data
	Bundle gotBasket = getIntent().getExtras();
	
	//Next retrieve data by accessing the keys using the gotBasket object to pull the data
	String bob_said = gotBasket.getString("Key_or_label_name_1");
	double barbara = gotBasket.getDouble("Key_or_label_name_4");
	String al_said = gotBasket.getString("Key_or_label_name_3");
	int jessica = gotBasket.getInt("Key_or_label_name_2");
	//The above order for receiving the data means nothing. 
	
	//Lastly, use the data (The Strings, double, and int) where you need them