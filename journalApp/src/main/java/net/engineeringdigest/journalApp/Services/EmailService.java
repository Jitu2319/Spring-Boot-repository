package net.engineeringdigest.journalApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import net.engineeringdigest.journalApp.utilities.Constants;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.*;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String to, String subject, String from, String body, String filePath) {
		try {

			// Get the first file from the directory
			File directory = new File(filePath);
			File[] files = directory.listFiles();

			if (files == null || files.length == 0) {
				System.err.println("No files found in the directory: " + filePath);
				return;
			}

			// Sort files by last modified date (oldest first) and pick the first file
			Arrays.sort(files, Comparator.comparingLong(File::lastModified));
			File firstFile = files[0];

			// Create a MimeMessage
			MimeMessage message = javaMailSender.createMimeMessage();

			// Use MimeMessageHelper to handle attachments
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom(from);
			helper.setText(body, true); // Enable HTML support in email body

			// Add Attachment
			FileSystemResource file = new FileSystemResource(firstFile);
			helper.addAttachment(Constants.FILE_NAME + ".pdf", file);

			// Send the email
			javaMailSender.send(message);
			System.out.println("Email with attachment sent successfully to: " + to);

		} catch (MessagingException e) {
			e.printStackTrace();
			System.err.println("Error sending email: " + e.getMessage());
		}
	}
}
