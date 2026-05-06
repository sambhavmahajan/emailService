package github.sambhavmahajan.emailasaservice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class MainController {
    @Value("${app.password}")
    private String password;
    @Value("${app.username}")
    private String from;
    private final JavaMailSender javaMailSender;
    @Autowired
    public MainController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @PostMapping("/send-email")
    public ResponseEntity<Object> sendEmail(@Valid @RequestBody EmailDTO email) {
        if(email.getPassword() == null || !password.equals(email.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email.getTo());
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getBody());
        simpleMailMessage.setFrom(from);
        try {
            javaMailSender.send(simpleMailMessage);
        } catch(Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).body("Server error");
        }
        return ResponseEntity.ok("Email sent!");
    }
}
