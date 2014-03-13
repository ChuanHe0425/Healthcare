package org.roncare.api;

import static org.junit.Assert.*;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.BeforeClass;
import org.junit.Test;

public class MailManTest {

	private static MailMan mm;
	
	@BeforeClass
	public static void createMailMan()	{
		mm = MailMan.createMailMan();
	}
	
	@Test
	public void sendMail_valid() throws AddressException, MessagingException	{
		assertTrue(mm.sendMail("parkwp@bu.edu", "Junit Test @" + new Date(), "JUnit Test Message"));
	}
	
	@Test (expected=MessagingException.class)
	public void sendMail_incorrectEmail_MessagingException() throws AddressException, MessagingException	{
		mm.sendMail("invalidEmailAddress", "invalid email Title", "invalid email message");
	}
	
	@Test (expected=AddressException.class)
	public void sendMail_invalidCharInEmail_AddressException() throws AddressException, MessagingException	{
		mm.sendMail("invalidEmailAddress;'!", "invalid email Title", "invalid email message");
	}
}
