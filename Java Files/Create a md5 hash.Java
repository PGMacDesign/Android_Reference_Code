//Creates an MD5 Hash
public static final String md5(final String s) {
	try {
		// Create MD5 Hash
		MessageDigest digest = MessageDigest.getInstance("MD5");
		digest.update(s.getBytes());
		byte messageDigest[] = digest.digest();
		// Create Hex String
		StringBuffer hexString = new StringBuffer();
		
		for (int i = 0; i < messageDigest.length; i++) {
			String h = Integer.toHexString(0xFF & messageDigest[i]);
			
			while (h.length() < 2)
			h = "0" + h;
			hexString.append(h);
		}
		return hexString.toString();
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	return "";
}