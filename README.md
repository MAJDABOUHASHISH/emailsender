#Send One to Multiple emails with an attachment by one click at once without BCC or the recipients to know you send to other people.

- V0.3: one to multiple email sender with an attachment, emails will be read from a text file.
- the dependencies in pom.xml file must exits.
- You need to access this link: https://myaccount.google.com/lesssecureapps, from the email ur sending the message from, and turn on "Less secure app access", you can turn it off, once you send the emails.
- What you need to update in the code (sendEmails.java) to work with you:
  - You need to update the sender email ("from" variable).
  - You need to update the sender password ("password_sender" variable).
  - You need to update the emails you will send to in src//main//resources//emails.txt.
  - You need to update the email header.
  - You need to update the message.
  - You need to update the path for the attachment file.

- Original Reference: https://netcorecloud.com/tutorials/send-email-in-java-using-gmail-smtp/