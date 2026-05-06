package github.sambhavmahajan.emailasaservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class Config {
    @Value("${app.host}")
    private String host;
    @Value("${app.port}")
    private int port;
    @Value("${app.username}")
    private String username;
    @Value("${app.emailpassword}")
    private String emailPassword;
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl ret = new JavaMailSenderImpl();
        ret.setHost(host);
        ret.setPort(port);
        ret.setUsername(username);
        ret.setPassword(emailPassword);
        Properties props = ret.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.debug", "true");
        return ret;
    }
}
