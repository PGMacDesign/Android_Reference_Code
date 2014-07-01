private class VerySlowTask extends AsyncTask <String, Long, Void> {
	private final ProgressDialog dialog = new ProgressDialog(CLASS_NAME.this); //Not needed, but adding for pop up purposes
		
		// can use UI thread here
		protected void onPreExecute() {
			startingMillis = System.currentTimeMillis();
			editText.setText("Start Time: " + startingMillis);
			//this.dialog.setMessage("Wait\nSome SLOW job is being done...");
			//this.dialog.show();
			Toast.makeText(getApplicationContext(), "Some SLOW work is being done!", Toast.LENGTH_SHORT).show();
		}
		
		// automatically done on worker thread (separate from UI thread)
		protected Void doInBackground(final String... args) {
			try {
				
				//STUFF YOU WANT DONE IN THE BACKGROUND GOES HERE
				
				}
			} catch (InterruptedException e) {
				//
			}
			return null;
		}

		// periodic updates - it is OK to change UI
		@Override
		protected void onProgressUpdate(Long... value) {
			super.onProgressUpdate(value);
			//editText.append("\nworking..." + value[0] + " Seconds"); //Update an editText field if need be here
		}
		
		// can use UI thread here
		protected void onPostExecute(final Void unused) {
			if (this.dialog.isShowing()) {
				this.dialog.dismiss();
			}
			// cleaning-up, all done
			editText.append("\nEnd Time:"
					+ (System.currentTimeMillis()-startingMillis)/1000 + " Seconds");
			editText.append("\nDone!");
		}
	}//AsyncTask
	
	
}//ThreadsMessagesThreeAsyncTask




//To execute it:
//new VerySlowTask().execute();
			