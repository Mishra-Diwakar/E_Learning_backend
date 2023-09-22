package com.clickncash.service;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	public JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String FROM_EMAIL;
	@Value("${spring.mail.password}")
	private String PASSWORD;
	@Value("${dailyReport.To}")
	private String ACC_REPORT_EMAIL;

	@Async
	public String sendMail(String to, String subject, String message) {
		Properties properties = System.getProperties();
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
			}
		});

		// compose message
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(FROM_EMAIL));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setContent(message, "text/html");

			emailSender.send(msg);
			return "success";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in sending mail to : " + to);
			return "Failure :" + e.getMessage();
		}
	}

}
