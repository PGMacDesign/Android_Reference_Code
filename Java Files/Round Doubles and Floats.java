
//This can be used to round a double or a float. Change the code to float if using that

	//This method is for rounding numbers
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	
	//Usage example:
	double x = 2.2;
	double y = 0.3213;
	double z = x/y; //<--This is not a pretty number at the moment!
	
	//Round it to 4 places
	z = round(z, 4);
	