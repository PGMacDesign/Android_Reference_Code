//Gets the amount of memory being used:
public static int BusyMemory() {
	StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
	
	int Total = (statFs.getBlockCount() * statFs.getBlockSize()) / 1048576;
	int Free = (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576;
	
	int Busy = Total - Free;
	
	return Busy;
}

//Use Like this
int busy_memory = BusyMemory();
