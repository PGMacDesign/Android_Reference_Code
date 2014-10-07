
//Returns a string which is the user's cell Number
public static String getMyPhoneNumber(Context ctx) {
	try {
		TelephonyManager mTelephonyMgr;
		mTelephonyMgr = (TelephonyManager)
		ctx.getSystemService(Context.TELEPHONY_SERVICE);
		return mTelephonyMgr.getLine1Number();
	} catch (Exception e) {
		return "";
	}
}
	
public static String getMy10DigitPhoneNumber(Context ctx) {
	try {
		String s = getMyPhoneNumber(ctx);
		return s.substring(2);
	} catch (Exception e) {
		return "";
	}
}