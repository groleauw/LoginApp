package com.login;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RegistrationEmail {

	/**
	 * This method sends the email from specific user to the registered email id
	 */
	public void sendRegistrationMail(RegisterBean register) {

		/*
		 * final String username = "username"; final String password =
		 * "password";
		 * 
		 * Properties props = new Properties(); props.put("mail.smtp.auth",
		 * "true"); props.put("mail.smtp.starttls.enable", "true");
		 * props.put("mail.smtp.host", "mail.your_domain.com");
		 * props.put("mail.smtp.port", "587");
		 */
		
		final String username = "username@gmail.com";
		final String password = "password";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
					
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
		});

		try{
			/*
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(register.getEmail()));
			message.setSubject("Thank you " + register.getName().toUpperCase()
					+ " " + register.getLastname().toUpperCase()
					+ " for Registration");
			message.setContent(
					"Thank you "
							+ register.getName()
							+ " for Registration, "
							+ "Following are the details of your account,"
							+ "<br/>*************************************** "
							+ "<br/>Username : <b>"
							+ register.getUsername()
							+ "</b>"
							+ "<br/>Password : <b>"
							+ register.getPassword()
							+ "</b>"
							+ "<br/>Name : <b>"
							+ register.getName()
							+ " "
							+ register.getLastname()
							+ "</b>"
							+ "<br/>DOB : <b>"
							+ register.getDob()
							+ "</b>"
							+ "<br/>Click the link to activate your account : "
							+ "<a href='http://localhost:8080/LoginExample/validateRegister.do?uname="
							+ register.getUsername() + "&email="
							+ register.getEmail() + "'>Activate Account</a>"
							+ "<br/>*************************************** ",
					"text/html");
			Transport.send(message);

			System.out.println("Email Sent Successfully");
			*/
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("to-email@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done");

		} catch (MessagingException e) {
			System.out.println("Error while sending the Mail");
			throw new RuntimeException(e);
		}
	}
}