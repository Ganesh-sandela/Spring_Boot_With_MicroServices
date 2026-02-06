package in.ashokit.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Controller

public class UserController {
	@Autowired
	private JavaMailSender email;

	@GetMapping("/email")
	@ResponseBody
	public String email() throws MessagingException {

//	    SimpleMailMessage msg= new SimpleMailMessage();
//	    msg.setTo("sandelaganesh57@gmail.com");
//	    msg.setSubject("Hi this email form spring boot..... ");
//	    msg.setText("This is email body(test)");
//	    
//	    email.send(msg);

		MimeMessage mimeMessage = email.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
		helper.setTo("harishbobbili2002@gmail.com");
		helper.setSubject("hi ganesh this msg from spring boot");
		helper.setText("<h1> This is heading</h1>", true);
		File file= new File("C:\\Users\\user\\OneDrive\\Documents\\Ganesh RESUME.docx");
		helper.addAttachment(file.getName(),file);
		
		email.send(mimeMessage);

		return " succesfully msg sent";
	}
}
