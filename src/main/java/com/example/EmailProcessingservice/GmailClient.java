

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import org.apache.log4j.xml.DOMConfigurator;
import java.util.*;
import java.io.*;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;


import javax.mail.*;

@Component
public class GmailClient {

   private static final Logger logger = LogManager.getLogger(GmailClient.class);


    public static ArrayList<String> check() {
        ArrayList<String> al=new ArrayList<String>();


        String[] output;
        DOMConfigurator.configure("/Users/gopi/Desktop/EmailProcessingservice/src/main/resources/log4j2.xml");
        logger.info("Started fetching unread emails from gmail");

        try {



            //create properties field
            Properties properties = new Properties();


            String host = "smtp.gmail.com";// change accordingly
            String mailStoreType = "smtp";
            String username = "gopitumati1@gmail.com";// change accordingly
            String password = "Newpassword2021(";// change accordingly

            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port", "25");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.auth","true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            //logger.info("started connecting to host ");
            store.connect(host, username, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);


            // Fetch unseen messages from inbox folder
            //need to check
            Message[] messages = emailFolder
                    .search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));


            // retrieve the messages from the folder in an array and print it
            //Message[] messages = emailFolder.getMessages();

            System.out.println("messages.length---" + messages.length);
            //System.exit(0);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];

                //System.out.println(message.getSubject());
                if (message.getSubject().contains("Issue")) {

                    /*System.out.println("---------------------------------");
                    System.out.println("Email Number " + (i + 1));
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("From: " + message.getFrom()[0]);*/
                    String result = "";
                    if (message.isMimeType("text/plain")) {
                        result = message.getContent().toString();
                        al.add(result);
                    } else if (message.isMimeType("multipart/*")) {
                        MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
                        result = getTextFromMessage(message);
                        al.add(result);
                    }
                    System.out.println(result);
                    //Sytem.out.println("Text: " + message.getContent().toString());


                    logger.info("adding fetched Message to arraylist ");

                }
            }

            //close the store and folder objects


            logger.info("closing email stream");
            emailFolder.close(false);
            store.close();
            return al;

        } catch (NoSuchProviderException e) {
            logger.error("No such provider Exception");
            e.printStackTrace();
        } catch (MessagingException e) {
            logger.error("Messaging exception");
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("messagging exception");
            e.printStackTrace();
        }
        logger.info("returning arraylist");
        return al;
    }

    private static  String getTextFromMessage(Message message) throws Exception {
        if (message.isMimeType("text/plain")){
            return message.getContent().toString();
        }else if (message.isMimeType("multipart/*")) {
            String result = "";
            MimeMultipart mimeMultipart = (MimeMultipart)message.getContent();
            int count = mimeMultipart.getCount();
            for (int i = 0; i < count; i ++){
                BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/plain")){
                    result = result + "\n" + bodyPart.getContent();
                    break;  //without break same text appears twice in my tests
                } else if (bodyPart.isMimeType("text/html")){
                    String html = (String) bodyPart.getContent();
                    result = result + "\n" + Jsoup.parse(html).text();

                }
            }
            return result;
        }
        return "";
    }






}



