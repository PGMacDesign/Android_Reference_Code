//To send an SMS
String smsNumber = "7145555555";
Uri smsUri = Uri.parse("sms:" + smsNumber);
Intent intent = new Intent(Intent.ACTION_VIEW, smsUri);
intent.putExtra("sms_body", "oh Hai!");
startActivity(intent);