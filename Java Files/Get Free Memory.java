//Returns the amount of FREE memory
public static int FreeMemory() {
	StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
	
	int Free = (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576;
	return Free;
}