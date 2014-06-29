	public void onClick(View v) {
		String to_field = "abc@gmail.com";
		String subject = "You have won a free tablet";
		
		//Email address (to send to) Creates an array of a single string
		String emailaddress[] = { to_field };

		//The"Message" portion of the email
		String message = "\n     "
				+ bulk_message
				+ "\n\n DO NOT EDIT BELOW THIS LINE:\n\n\n\n\n\n\n\n"
				+ "Some code here for referencing"
				+ " /End";

		//Below code is to actually send an email. 
		Intent email_Intent_Bug = new Intent(android.content.Intent.ACTION_SEND);
		
		//Takes in a string array as second parameter
		//This is the "to" field of the email
		email_Intent_Bug.putExtra(android.content.Intent.EXTRA_EMAIL, emailaddress);
		
		//For the subject line
		email_Intent_Bug.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
		
		//Standard formatting/ font
		email_Intent_Bug.setType("plain/text");
		
		//Adds in the message/ bulk of the email
		email_Intent_Bug.putExtra(android.content.Intent.EXTRA_TEXT, message);
		
		//Actually starts the activity, don't forget or it won't work!
		startActivity(email_Intent_Bug);
		
	}