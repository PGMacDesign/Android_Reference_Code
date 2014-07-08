//First define the button. I am doing it as a global so it can be used for different methods.

Button button1;

//Next define it in your onCreate() or Initialize() methods

button1 = (Button) findViewById(R.id.button_id_defined_in_xml_code);
//Lastly, right after defining it as above, set it to an onClickListener so it can be clicked.
button1.setOnClickListener(this); //Here, notice the this, which means more will need to be done

//Next the Class will have to implement onClickListener(). 
//On Click Method
	public void onClick(View arg0) {
		//This method of using a switch statement is helpful for more than 1 button used within any activity. 
		
		switch (arg0.getId()){
		
		case R.id.button_id_defined_in_xml_code:
			
			try {
				
				//Write what you want the button click to do
				
			} catch (Exception e){
				e.printStackTrace();
			}
			break;
			
		case R.id.button_id_defined_in_xml_code_other:
			try {
			
			//Write what you want the button click to do
				
			} catch (Exception e){
				e.printStackTrace();
			}
			break;
			
		}
	}