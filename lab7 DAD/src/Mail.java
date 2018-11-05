import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String username = "tiniekhairi26@gmail.com";
		final String password = "";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");//put = To asks the server to edit/update an existing resource.
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator()
				{
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
				});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tiniekhairi26@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("tiniekhairi26@gmail.com"));
			message.setSubject("Hello");
			message.setText("This message is for Distributed Application Development Subject Testing");
			Transport.send(message);
			System.out.println("Message Sent!");
		}catch(MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
