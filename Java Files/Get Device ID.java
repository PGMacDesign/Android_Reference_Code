
//Gets the device ID (I think that's the same as the ESN)
public static String get_device_id(Context ctx) {
	
	final TelephonyManager tm = (TelephonyManager)
	ctx.getSystemService(Context.TELEPHONY_SERVICE);
	final String tmDevice, tmSerial, tmPhone, androidId;
	
	try {
		tmDevice = "" + tm.getDeviceId();
		tmSerial = "" + tm.getSimSerialNumber();
		
		androidId = "" + android.provider.Settings.Secure.getString(ctx.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
		
		UUID deviceUuid = new UUID(androidId.hashCode(), ((long)
		tmDevice.hashCode() << 32) | tmSerial.hashCode());
		String deviceId = deviceUuid.toString();
		
		return deviceId;
		
	} catch (Exception ex) {
		return "nodeviceid";
	}
}