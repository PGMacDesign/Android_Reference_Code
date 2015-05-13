
//When I open a link, IE in pulse, and it opens up to chrome and then go to the home screen, if I click on pulse again, having this flag in it will PREVENT the app from opening up into chrome, it will open into pulse.

Intent shareIntent = new Intent(Intent.ACTION_SEND);
shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT ); //THIS IS THE KEY LINE HERE
shareIntent.putExtra("STUFF", "STUFF");
startActivity(shareIntent);

//Changed line 5 as per deprecation remarks in API 21+
