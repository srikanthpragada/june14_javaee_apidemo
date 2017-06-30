package mail;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendMailWithAttachment  {

     public static void main(String args[]) {
        String to = "james@java.com";
        String from = "gavin@java.com";
        String subject = "John";
        String body = "Here is John .....";
        
        Properties props = System.getProperties();
        
        Authenticator auth = new Authenticator(){
            @Override 
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("gavin@java.com","g");
            }
        };
        
        // authentication required 
        props.setProperty("mail.smtp.auth","true");
        Session session = Session.getDefaultInstance(props,auth);
                
        try {
            
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            // create and fill the first message part
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setText(body);
            
            // create the second message part
            MimeBodyPart mbp2 = new MimeBodyPart();
            FileDataSource fds = new FileDataSource(new File("f:\\images\\john.jpg"));
            // attach the file to the message
            mbp2.setDataHandler(new DataHandler(fds));
            mbp2.setFileName(fds.getName());
            
            // create the Multipart and its parts to it
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);
            mp.addBodyPart(mbp2);
            
            msg.setContent(mp);  // add the Multipart to the message
            
            Transport.send(msg);
            System.out.println("Mail has been sent with attachment"); 
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
