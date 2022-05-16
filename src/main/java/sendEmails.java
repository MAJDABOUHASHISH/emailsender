import java.util.Properties; //represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream.
import javax.mail.*;
import javax.mail.internet.InternetAddress; //This class represents an Internet email address using the syntax of RFC822
import javax.mail.internet.MimeMessage; //This class represents a MIME style email message. It implements the Message abstract class and the MimePart interface.

public class sendEmails {
    public static void main(String[] args) {

        // Recipient's email ID needs to be mentioned.
        String to = "sender@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "reciever@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object (Session class represents a mail session).
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() { //(This class is simply a repository for a username and a password.)
                return new PasswordAuthentication("sender@gmail.com", "senderPassword");  //Enter the email and password of the sender email
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject");

            // Now set the actual message
            message.setText("This is actual message"); //if u add an attachment this message will be ignored and the message will be the textPart

            // Send message
            Transport.send(message);

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}