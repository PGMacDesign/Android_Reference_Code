private static long back_pressed;


public void onBackPressed()
{
	if (back_pressed + 2000 > System.currentTimeMillis()) 
		super.onBackPressed();
	else Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
		back_pressed = System.currentTimeMillis();
}