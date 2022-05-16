- V0.1: one email without an attachment
- Need to add these dependencies to pom.xml file in maven:
<p>
    <dependencies>
        <dependency>
            <groupId>com.sun.mail</groupId>
            <artifactId>javax.mail</artifactId>
            <version>1.6.2</version>
        </dependency>
    </dependencies>
</p>

- You need to access this link: https://myaccount.google.com/u/1/lesssecureapps, from the email ur sending the message from, and turn on "Less secure app access".
- Original Reference: https://netcorecloud.com/tutorials/send-email-in-java-using-gmail-smtp/
