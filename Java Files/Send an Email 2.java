import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public void postMail( String recipients[ ], String subject, String message , String from) throws MessagingException {
	boolean debug = false;
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.example.com");
	Session session = Session.getDefaultInstance(props, null);
	session.setDebug(debug);
	Message msg = new MimeMessage(session);
	InternetAddress addressFrom = new InternetAddress(from);
	msg.setFrom(addressFrom);
	InternetAddress[] addressTo = new InternetAddress[recipients.length];
	
	for (int i = 0; i < recipients.length; i++) {
		addressTo[i] = new InternetAddress(recipients[i]);
	}
	
	msg.setRecipients(Message.RecipientType.TO, addressTo);
	msg.addHeader("MyHeaderName", "myHeaderValue");
	msg.setSubject(subject);
	msg.setContent(message, "text/plain");
	Transport.send(msg);
}