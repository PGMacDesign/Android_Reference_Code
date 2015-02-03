import android.app.Application;
import android.content.Context;

//This class MUST Be declared in the manifest under the application tag as: android:name=".MyApplication"
//This class is an actual representation of the application itself. It is a custom application class
public class MyApplication extends Application {
	private static MyApplication sInstance;

	public void onCreate(){
		super.onCreate();
		sInstance = this;
	}

	//Returns the instance
	public static MyApplication getsInstance(){
		return sInstance;
	}

	//Returns the context
	public static Context getAppContext(){
		return sInstance.getApplicationContext();
	}
}