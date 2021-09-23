package com.example.EmailProcessingservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import javax.mail.search.FlagTerm;
import org.apache.log4j.xml.DOMConfigurator;
import java.util.*;
import java.io.*;

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
                    String username = "t.gopichand15@gmail.com";// change accordingly
                    String password = "Password";// change accordingly

                    properties.put("mail.smtp.host","smtp.gmail.com");
                    properties.put("mail.smtp.port", "25");
                    properties.put("mail.smtp.starttls.enable", "true");
                    properties.put("mail.smtp.auth","true");
                    Session emailSession = Session.getDefaultInstance(properties);

                    //create the POP3 store object and connect with the pop server
                    Store store = emailSession.getStore("pop3s");

                    logger.info("started connecting to host ");
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

                            System.out.println("---------------------------------");
                            System.out.println("Email Number " + (i + 1));
                            System.out.println("Subject: " + message.getSubject());
                            System.out.println("From: " + message.getFrom()[0]);
                            System.out.println("Text: " + message.getContent().toString());

                          logger.info("adding fetched Message to arraylist ");
                            if(message.getSubject() == "Issue"){
                                al.add(message.getContent().toString());
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



}



