//This is for making an alert popup. It will overlay the screen with a window that will give them options

AlertDialog.Builder builder = new AlertDialog.Builder(this);
	builder.setCancelable(true);
	builder.setTitle("Title Goes Here");
	builder.setMessage("Message will go here. IE, Did you know 20% of statistics are made up?");
	builder.setInverseBackgroundForced(true);
	builder.setPositiveButton("Dismiss",
			new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog,
						int which) {
					dialog.dismiss();
				}
			});
	builder.setNegativeButton("Show Me", new DialogInterface.OnClickListener() {
		   public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
				//This will open up an intent when they click the "Show Me" option
				Intent intent = new Intent("com.package.name.CLASSNAME");
				startActivity(intent);		
		   }
		});
	AlertDialog alert = builder.create();
	alert.show();	