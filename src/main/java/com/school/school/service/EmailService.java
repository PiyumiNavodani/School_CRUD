package com.school.school.service;

import com.school.school.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    public String sendMail(Email details){
        try{
            SimpleMailMessage sendEmail = new SimpleMailMessage();

            sendEmail.setFrom(sender);
            sendEmail.setTo(details.getRecipient());
            sendEmail.setText(details.getMailBody());
            sendEmail.setSubject(details.getSubject());

            javaMailSender.send(sendEmail);
            return "Mail sent successfully";
        } catch (Exception e) {
            return "Mail sending failed";
        }
    }
}

//tutorial eka bln boru type karanawa
