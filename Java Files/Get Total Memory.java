//Returns an int of the total memory
public static int TotalMemory() {
	
	StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
	
	int Total = (statFs.getBlockCount() * statFs.getBlockSize()) / 1048576;
	
	return Total;
}

//Use like this:
int mem_used = TotalMemory();
