/*
@Parameters: 
1st is the parameter passed into the doInBackground method
2nd is for the parameter in the onProgressUpdate 
3rd is the Value returned from the doInBackground which is passed into the onPostExecute
Can also use a constructor to pass in custom parameters. Example below
*/
private class VerySlowTask extends AsyncTask <String, Long, Void> {
	
	//Example optional variables. defined via the constructor below
	private String str;
	private List<String> the_list;
	private Object the_object;
	
		//Constructor. Optional if you want more custom arguments. Passes into variables defined on lines above
		public VerySlowTask(String str, List<String> passed_list, Object passed_object){
			this.str = str;
			this.the_list = passed_list;
			this.the_object = passed_object;
		} 
		
		// can use UI thread here
		protected void onPreExecute() {
			//this.dialog.setMessage("Wait\nSome SLOW job is being done...");
			//this.dialog.show();
			//Or add toasts here, it will pop up

		}
		
		// automatically done on worker thread (separate from UI thread)
		protected Void doInBackground(final String... args) {
			try {
				
				//STUFF YOU WANT DONE IN THE BACKGROUND GOES HERE
				
				
			} catch (Exception e) {
				//
			}
			return null;
		}

		// periodic updates - use this to update a progress bar/ progress dialogue
		@Override
		protected void onProgressUpdate(Long... value) {
			super.onProgressUpdate(value);
			//Update an editText field if need be here
		}
		
		// Finalize, use passed values, update UI Components
		protected void onPostExecute(final Void unused) {
			//Edit the EditTexts/ TextViews/ Images here
			//IE image_view.setImageBitmap(bm);
		}
	}//AsyncTask
	





//Different Ways to execute it:
1) new VerySlowTask().execute(); //If there is no constructor, use this
2) new VerySlowTask(parameter1, parameter2, parameter3).execute();//If there is a constructor use this
3) String response = new VerySlowTask(parameter1, parameter2, parameter3).execute().get(); //If you are waiting for a response (THIS WILL HALT THE UI THREAD), use this one. 
//Also, the object being returned (IE, String, Object, Int, etc) will be defined by the onDoInBackground method and its return value, which is defined by the third parameter in the "extends AsyncTask <String, Long, String>"
			