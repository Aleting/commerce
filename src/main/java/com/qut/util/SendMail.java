package com.qut.util;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class SendMail {

    /*
     *@param [toMail, code]收件人 激活码
     */
    static public String getCode(int length){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<length; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }



    static public boolean sendMail(String name ,String toMail, String code) throws MessagingException {
        //设置邮件服务器
        Properties props = new Properties();
        //可以设置邮件服务器
        //网易的smtp服务器地址
        props.put("mail.smtp.host", "smtp.163.com");
        //SSLSocketFactory类的端口
        props.put("mail.smtp.socketFactory.port", "465");
        //SSLSocketFactory类
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        //网易提供的ssl加密端口,QQ邮箱也是该端口
        props.put("mail.smtp.port", "465");
        //使用ssl协议
        props.put("mail.smtp.ssl.enable", "true");

        //与邮件服务器的连接
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("YJ_Root@163.com","wyj980206");
            }
        });

        //创建邮件
        Message message = new MimeMessage(session);
        //设置收件人地址
        message.setFrom(new InternetAddress("YJ_Root@163.com"));
        //抄送
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
        //设置邮件的主体
        message.setSubject("尊敬的"+name+"客户");
        //设置内容
        String msg="<h1>请点击<a href='http://xbnzs.cn:8080/user/emailActivation?bemail="+name+"&state="+code+"'>此处</a>激活账户"
                + "如果点击上面内容失败，请点击该链接进行尝试:"+"http://xbnzs.cn:8080/user/emailActivation?bemail="+name+"&state="+code+"<h1>";
        message.setContent(msg, "text/html;charset=utf-8");
        //发送邮件
        Transport.send(message);

        System.out.println("邮件发送ok！");
        return true;
    }
}