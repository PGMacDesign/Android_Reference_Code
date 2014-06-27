//This class will create a calendar event. 

	//Create a DatePicker variable
	DatePicker date_picker;
	
	//Define the DatePicker via the Initialize() or the onCreate() methods
	date_picker = (DatePicker) findViewById(R.id.date_picker_defined_in_xml);

	//Need to pass in 3 string parameters and then a DatePicker for the 4th. 
	public void CreateEvent(String title, String address, String description, DatePicker dp){
		
		//Define the end times (Exclude if using a TimePicker for end time.
		GetEndTimes();
		
		//Create an intent that will enter data into the calendar
		Intent calIntent = new Intent(Intent.ACTION_INSERT);
		calIntent.setType("vnd.android.cursor.item/event");
		
		//Put information into the intent
		calIntent.putExtra(Events.TITLE, title); 
		calIntent.putExtra(Events.EVENT_LOCATION, address); 
		calIntent.putExtra(Events.DESCRIPTION, description);
		
		/*
		SIDE NOTE
		This specifically is calculating end times based on hours chosen for the length of the event, but, 
		it can also be done via a time picker combined with a date picker. It would look more like this:
		
		//Have the date and TimePickers already defined:
		TimePicker tp;
		DatePicker dp;
		String endTimeDate = dp.getYear() + "-" + (dp.getMonth() + 1) + "-" + dp.getDayOfMonth() + " "+ tp.getCurrentHour() + ":" + tp.getCurrentMinute();
		*/
		
		//Start and End Timing
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
		
		//Format: startTime.set(year, month, day, hourOfDay, minute)
		startTime.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(), hour_start_variable, min_start_variable);
		endTime.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(), hour_end_variable, min_end_variable);
		
		//Put the calculated start and end time into the calIntent Intent
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
		startTime.getTimeInMillis());
		calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
		endTime.getTimeInMillis());

		
		//Puts event into calendar
		startActivity(calIntent); 
	}
	
	//Calculated the end times via epoch time 
	public void GetEndTimes(){
			
		double lengthOfDailyEventHours1 = 0.0;
		double lengthOfDailyEventMinutes1 = 0.0;
		int hour_start_variable, min_start_variable, hour_end_variable, min_end_variable;
		hour_start_variable = min_start_variable = hour_end_variable = min_end_variable = 0;
		
		//Get the numbers for these variables via editTexts OR code them in via passed parameters
				
		//Convert the length of time, start time in minutes, and start time in seconds to one large seconds pool
		int lengthtotalsecshour1 = (int) (lengthOfDailyEventHours1*3600); 
		int lengthtotalsecsmin1 = (int) ((lengthOfDailyEventMinutes1*3600)/60);
		int starttimeseconds1 = (daily_hour_start * 3600) + ((daily_min_start*3600)/60); 
		int totalsecs1 = starttimeseconds1 + lengthtotalsecsmin1 + lengthtotalsecshour1; 
		
		//Get the hours and minutes
		int hours1 = totalsecs1 - (totalsecs1 % 3600); 
		int minutes1 = totalsecs1 - hours1; 
		
		//Convert those hours and minutes
		daily_hour_end = hours1 / 3600; 
		daily_min_end = (minutes1*60) / 3600; 
	}
	
	
	
	
	
