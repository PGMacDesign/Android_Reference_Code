	//This is an example of an intent
	/*
	Try to run this from within the activity. If running from within a class, make sure to cast! Use:
	Intent intent1 = new Intent((ParentActivity)getActivity(), NewClassToOpen.class);
	startActivity(intent1);
	*/
	try{
	    Intent intent1 = new Intent(context, ClassToOpen.class);
	    startActivity(intent1);
	} catch (Exception e) {
	    e.printStackTrace();
	}
