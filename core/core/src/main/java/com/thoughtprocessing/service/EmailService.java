package com.thoughtprocessing.service;

import com.thoughtprocessing.model.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(MessageDto message) {

        SimpleMailMessage email = new SimpleMailMessage();
        //set the Receiver mailId from backend spring boot EmailService
        // to get the details of React contact send message form details info from Sender side
        email.setTo("veerababusingu@gmail.com");
        email.setSubject(Optional.ofNullable(message.getSubject()).orElse("No Subject"));
        //Sender side contact info getting from Frontend React Contact Send Message form
        email.setText("From: " + message.getName() +
                  "\nEmail: " + message.getEmail() +
                  "\nMobile: " + message.getMobile() +
                  "\n\nMessage:\n" + Optional.ofNullable(message.getMessage()).orElse("No Message"));


        mailSender.send(email);

    }
    //This is testing purpose suppose if it doesnt work dirctly by using SMTP method as shown above
    public void sendTestEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("singuveerababu10@gmail.com");
        message.setSubject("Test Email");
        message.setText("This is a test from Spring Boot.");
        message.setFrom("veerababusingu@gmail.com");
        mailSender.send(message);
    }




}
