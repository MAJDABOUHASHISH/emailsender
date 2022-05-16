import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties; //represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream.
import javax.mail.*;
import javax.mail.internet.InternetAddress; //This class represents an Internet email address using the syntax of RFC822
import javax.mail.internet.MimeMessage; //This class represents a MIME style email message. It implements the Message abstract class and the MimePart interface.
import javax.mail.internet.MimeMultipart; //This Class is an implementation of the abstract Multipart class that uses MIME conventions for data.
import javax.mail.internet.MimeBodyPart; //This class represents a MIME body part. MimeBodyPart uses the InternetHeaders class to parse and store the headers of that body part.
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class sendEmails {
    public static void main(String[] args) {
        try {
            Scanner emails = new Scanner(new FileInputStream("src//main//resources//emails.txt")); //the path of the emails list
            while (emails.hasNextLine()) { //read the emails

                String to = emails.nextLine(); // Recipient's email ID

                if (!to.isEmpty()) { //to ignore any empty line in the text file.

                    // Sender's email ID needs to be mentioned
                    String from = "sender@gmail.com";
                    String password_sender = "password";

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
                            return new PasswordAuthentication(from, password_sender);  //Enter the email and password of the sender email
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
                        message.setSubject("Email title");

                        //add an attachment
                        Multipart multipart = new MimeMultipart();

                        MimeBodyPart attachmentPart = new MimeBodyPart();

                        MimeBodyPart textPart = new MimeBodyPart();

                        try {

                            File f = new File("C:\\Users\\majds\\desktop\\moon.png"); //the path of the attachment file

                            attachmentPart.attachFile(f);
                            textPart.setText("Email message");
                            multipart.addBodyPart(textPart);
                            multipart.addBodyPart(attachmentPart);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        message.setContent(multipart);

                        // Send message
                        Transport.send(message);

                    } catch (MessagingException mex) {
                        mex.printStackTrace();
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}