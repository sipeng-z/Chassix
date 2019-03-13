package com.system.service;


import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


@Service
public class SMTPEmailService  {


    private String host = "192.168.241.35";

    private String auth = "";

    private String username ="ChassixMaterial";

    private String domainUser;

    private String password;


    /**
     * 发送邮件
     * @param to          接收人
     * @param subject	     标题
     * @param msgtext	     内容
     * @return
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public boolean SendMail(String [] to,String subject,String msgtext) throws MessagingException, UnsupportedEncodingException
    {
        boolean flag = false;

        Properties properties = new Properties();
        //设置smtp协议
        properties.put("mail.transport.protocol", "SMTP");
        //设置服务器连接地址
        properties.put("mail.smtp.host", host);
        //设置TLS保护连接，默认为false
        properties.put("mail.smtp.starttls.enable", "true");
        //设置身份校验
        properties.put("mail.smtp.auth", "true");
        //设置默认端口号
        properties.put("mail.smtp.port", 25);

        //使用环境属性和授权信息，创建邮件会话
        Session session = Session.getDefaultInstance(properties);

        //控制台打印日志
        session.setDebug(true);
        //创建邮件消息
        Message msg = new MimeMessage(session);

        //设置发件人
        InternetAddress from = new InternetAddress(username);
        msg.setFrom(from);

        if(to.length > 0)
        {
            InternetAddress [] toAddr = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                toAddr[i] = new InternetAddress(to[i]);
            }
            //设置收件人的邮箱
            msg.setRecipients(RecipientType.TO, toAddr);
            //设置邮件标题
            msg.setSubject(subject);
            //设置发送时间
            msg.setSentDate(new Date());
            //设置邮件的内容体
            BodyPart mbp = new MimeBodyPart();
            mbp.setContent(msgtext, "text/html;charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mbp);
            msg.setContent(multipart);

            msg.saveChanges();
            //建立邮件传输对象
            Transport transport = session.getTransport("smtp");
            //与服务端建立连接
//            transport.connect(host,"admin@cams.net", "123456");

            transport.connect(host,"","");
            //发送邮件
            transport.sendMessage(msg, msg.getAllRecipients());
            //关闭
            transport.close();

            flag = true;
        }
        else
        {
            System.out.println("接收用户为空");
        }

        return flag;
    }







}
