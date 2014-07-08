private class VerySlowTask extends AsyncTask <String, Long, Void> {
	private final ProgressDialog dialog = new ProgressDialog(CLASS_NAME.this); //Not needed, but adding for pop up purposes
		
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

		// periodic updates - it is OK to change UI
		@Override
		protected void onProgressUpdate(Long... value) {
			super.onProgressUpdate(value);
			//editText.append("\nworking..." + value[0] + " Seconds"); //Update an editText field if need be here
		}
		
		// can use UI thread here
		protected void onPostExecute(final Void unused) {

			// cleaning-up, all done
			//Edit the EditTexts/ TextViews/ Images here
			//IE image_view.setImageBitmap(bm);
		}
	}//AsyncTask
	





//To execute it:
//new VerySlowTask().execute();
			