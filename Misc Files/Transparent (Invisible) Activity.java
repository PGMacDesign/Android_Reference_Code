//First, place this in the manifest
	<!-- This activity is for (Description)-->
	<activity       
		android:name=".MainActivity2"
		android:label="Main Activity 2"  
		android:theme="@style/Theme.Transparent"
	>
	
//Next, Under res --> values --> styles.xml, add this:
	<style name="Transparent">
	    <item name="android:windowIsTranslucent">true</item>
	    <item name="android:windowAnimationStyle">@android:style/Animation.Translucent</item>
	    <item name="android:colorForeground">#fff</item>
	    <item name="android:windowBackground">@color/transparent</item>
	    <item name="android:colorBackground">@color/transparent</item>
	</style>    
	
//Lastly, either copy the colors.xml out of the xml values files folder, or, Create a color.xml file under res --> values and add:
	<?xml version="1.0" encoding="utf-8"?>
	<resources>
		<color name="transparent">#00000000 </color>
	</resources>