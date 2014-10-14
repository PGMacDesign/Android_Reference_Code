//GPS Location with listener
locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
// Define a listener that responds to location updates
locationListener = new LocationListener() {
	public void onLocationChanged(Location location) {
	
	// Called when a new location is found by the network location provider.
	longitude = String.valueOf(location.getLongitude());
	latitude = String.valueOf(location.getLatitude());
	Log.d(TAG, "changed Loc : " + longitude + ":" + latitude);
	}
	
	public void onStatusChanged(String provider, int status, Bundle extras) {
	}
	
	public void onProviderEnabled(String provider) {
	}
	
	public void onProviderDisabled(String provider) {
	}
	
	};


// getting GPS status
isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

// check if GPS enabled
	if (isGPSEnabled) {
		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		
		if (location != null) {
			longitude = String.valueOf(location.getLongitude());
			latitude = String.valueOf(location.getLatitude());
			locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
			locationListener);
		} else {
			location =
			locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		
		if (location != null) {
			longitude = String.valueOf(location.getLongitude());
			latitude = String.valueOf(location.getLatitude());
			locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,
			locationListener);
		} else {
			longitude = "0.00";
			latitude = "0.00";
		}
		}
	}
}