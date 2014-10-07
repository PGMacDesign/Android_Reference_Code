//Send an email via Intent

Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType("plain/text");

String email_to_send = "bob@yahoo.com";
intent.putExtra(Intent.EXTRA_EMAIL, new String[] {email_to_send});

String subject = "Yo, dinner?";
intent.putExtra(Intent.EXTRA_SUBJECT, subject);

startActivity(intent);