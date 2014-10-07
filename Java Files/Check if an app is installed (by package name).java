
//Returns a true or false if the package is installed, AKA, the app
public static boolean isAppInstalled(Context ctx,String uri) {
	
	PackageManager pm = ctx.getPackageManager();
	boolean installed = false;
	
	try {
		pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
		installed = true;
	} catch (PackageManager.NameNotFoundException e) {
		installed = false;
	}
	return installed;
}