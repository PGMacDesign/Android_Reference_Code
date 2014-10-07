//For opening web links
String webURL = "https://www.google.com";
Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webURL));
startActivity(browserIntent);