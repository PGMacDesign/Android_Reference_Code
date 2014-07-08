//This is an easy way to use logging within the debugger. 
//Make a class named L. Put this code in it
public class L {

	public static void myLog(String message){
		Log.d("Log Note", message);
	}
	
}

//Then simply call it like this:

L.myLog("Danger Will Robinson!");
