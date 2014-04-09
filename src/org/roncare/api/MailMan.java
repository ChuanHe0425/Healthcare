package org.roncare.api;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * Used code example from: http://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
 */
public class MailMan {
	private String username;
	private Session session;
	
	private static final MailMan instance = new MailMan();
	
	public static MailMan createMailMan()	{
		return instance;
	}
	
	private MailMan()	{
		String smtpHost = "smtp.gmail.com";
		String socketFactoryPort = "465";
		String socketFactoryClass = "javax.net.ssl.SSLSocketFactory";
		String smtpAuth = "true";
		String smtpPort = "465";
		final String username = "roncaresCS673@gmail.com";
		this.username = username;
		final String password = "RonCares!";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.socketFactory.port", socketFactoryPort);
		props.put("mail.smtp.socketFactory.class", socketFactoryClass);
		props.put("mail.smtp.auth", smtpAuth);
		props.put("mail.smtp.port", smtpPort);	

		session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
	}

	public boolean sendMail(String to, String title, String message) throws AddressException, MessagingException {
		Message m = new MimeMessage(session);
		m.setFrom(new InternetAddress(username));
		m.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
		m.setSubject(title);
		m.setText(message);

		Transport.send(m);
		
		return true;
	}
}
