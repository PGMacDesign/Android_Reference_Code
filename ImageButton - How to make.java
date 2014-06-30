/*
This is how to make an ImageButton (IE, a picture that you can click to 
open a link or call some type of intent/ action)
*/

import android.widget.ImageButton;

//Define it in the global variables
ImageButton button1;

//Define this in your onCreate() or your Initialize() function
button1 = (ImageButton) findViewById(R.id.REFERENCE_XML_ID_HERE);
button1.setOnClickListener(this);

//Lastly, define what you want the image to do when clicked on via the onClick method
public void onClick(View arg0) {
	switch (arg0.getId()){
		
	case R.id.REFERENCE_XML_ID_HERE:
		try{
			
			//Put here what you want the button to do
			
		} catch(Exception e){ 
			e.printStackTrace();
		}  
	}
}