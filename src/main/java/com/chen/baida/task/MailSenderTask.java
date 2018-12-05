package com.chen.baida.task;

import com.chen.baida.ApplicationContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.StringUtils;

/**
 * @author HanHongmin 2017-12-13
 */
public class MailSenderTask implements Runnable{
    private static final String FROM = "donotreply@521ke.com";
    private static final Logger LOGGER = LoggerFactory.getLogger(MailSenderTask.class);

    private String to;
    private String subject;
    private String text;

    public MailSenderTask() {
        // empty
    }

    public MailSenderTask(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    @Override
    public void run() {
        if(!StringUtils.hasText(to)){
            LOGGER.error("邮件发送错误，没有找到收件人");
            return;
        }
        JavaMailSender mailSender = ApplicationContextUtils.getBean(JavaMailSender.class);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
