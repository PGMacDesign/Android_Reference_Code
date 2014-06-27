//This will open up the calculator on the phone to the default calculator.
//For whatever reason, this is not working on HTC phones. Will research later

//This first one should try to run the default calculator. 

		ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();
		
		try{
		     ApplicationInfo info = getPackageManager()
		                             .getApplicationInfo("com.android.calculator2", 0 );

		    } catch( PackageManager.NameNotFoundException e ){
		     //application doesn't exist
		}
		
		//PackageManager pm;
		final PackageManager pm = getPackageManager();
		
		List<PackageInfo> packs = pm.getInstalledPackages(0);  
		
		for (PackageInfo pi : packs) {
			if( pi.packageName.toString().toLowerCase().contains("calcul")){
			    HashMap<String, Object> map = new HashMap<String, Object>();
			    map.put("appName", pi.applicationInfo.loadLabel(pm));
			    map.put("packageName", pi.packageName);
			    items.add(map);
			}
		}
	
		if(items.size()>=1){
			String packageName = (String) items.get(0).get("packageName");
			Intent i = pm.getLaunchIntentForPackage(packageName);
			if (i != null)
				startActivity(i);
				finish();
		}
		
			//Testing for HTC phones
				final String CALCULATOR_PACKAGE ="com.android.calculator2";
				final String CALCULATOR_CLASS ="com.android.calculator2.Calculator";
				  Intent intent = new Intent();

				    intent.setAction(Intent.ACTION_MAIN);
				         intent.addCategory(Intent.CATEGORY_LAUNCHER);
				        intent.setComponent(new ComponentName(
				         CALCULATOR_PACKAGE,
				         CALCULATOR_CLASS));
		        finish();
			
		