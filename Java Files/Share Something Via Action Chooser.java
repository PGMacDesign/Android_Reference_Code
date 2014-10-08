//This will allow info to be shared via another app (IE sms, gmail, yahoo, etc)
Intent sharingIntent = new Intent(Intent.ACTION_SEND);
sharingIntent.setType("text/plain");
String shareBody = "https://www.google.com";
sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Stuff!");
sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
startActivity(Intent.createChooser(sharingIntent,"Choose sharing method"));