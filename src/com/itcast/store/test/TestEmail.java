package com.itcast.store.test;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class TestEmail {
    @Test
    public static void main(String[] args) throws Exception {
        // 0.1 服务器的设置
        Properties props = new Properties();
        // props.setProperty("mail.host", "smtp.126.com");
        // props.setProperty("mail.smtp.auth", "true");
        // 0.2 账号和密码
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 126账号和密码（模拟账号，需要自己注册）
                // return new PasswordAuthentication("itcast", "123456");
                return new PasswordAuthentication("bbb@store.com", "bbb");
            }
        };

        // 1 与126服务器建立连接：Session
        Session session = Session.getDefaultInstance(props, authenticator);

        // 2 编写邮件：Message
        Message message = new MimeMessage(session);
        // 2.1 发件人（模拟账号）
        // message.setFrom(new InternetAddress("itcast@126.com"));
        message.setFrom(new InternetAddress("bbb@store.com"));
        // 2.2 收件人 , to:收件人 ， cc ：抄送，bcc：暗送（密送）。（模拟账号）
        message.setRecipient(RecipientType.TO, new InternetAddress("aaa@store.com"));
        // 2.3 主题
        message.setSubject("这是我们得第一份邮件");
        // 2.4 内容
        message.setContent("哈哈，您到我的商城注册了。", "text/html;charset=UTF-8");

        // 3 将消息进行发送：Transport
        Transport.send(message);

    }

}