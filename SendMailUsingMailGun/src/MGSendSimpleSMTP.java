
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;

import javax.mail.*;

import javax.mail.internet.*;

import com.sun.mail.smtp.*;

public class MGSendSimpleSMTP {

	public static void main(String args[]) throws Exception {

		Properties props = System.getProperties();
		props.put("mail.smtps.host", "smtp.mailgun.org");
		props.put("mail.smtps.auth", "true");

		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("ahmedreza@zeesense.com"));
		/*msg.setRecipients(, );*/

		InternetAddress[] addrs = InternetAddress.parse("ahmedreza@zeesense.com", false);
		msg.setRecipients(Message.RecipientType.TO, addrs);
		
//		InternetAddress[] addrs1 = InternetAddress.parse("ahmedreza@zeesense.com", false);
//		msg.setRecipients(Message.RecipientType.TO, addrs);
//		InternetAddress[] addrs2 = InternetAddress.parse("shaikhreza43@gmail.com", false);
//		msg.setRecipients(Message.RecipientType.TO, addrs);

		msg.setSubject("This is a Test Mail From Shaikh Ahmed Reza");
		msg.setText("Hey There,,This is a Test Mail From Shaikh Ahmed Reza for verifying mailGun Api");
		msg.setSentDate(new Date());

		SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
		t.connect("smtp.mailgun.com", "postmaster@sandbox210c7c5e74be41ad896208621e36c7fb.mailgun.org",
				"e61ce5eaeb33f74889ef75213b190c5c-9b463597-bb924f6f");
		t.sendMessage(msg, msg.getAllRecipients());

		System.out.println("Response: " + t.getLastServerResponse());

		t.close();
	}
}
