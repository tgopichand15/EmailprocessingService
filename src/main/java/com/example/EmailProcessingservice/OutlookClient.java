package com.example.EmailProcessingservice;

//public class OutlookClient implements Email throws Exception {

    //implement multithreading to fetch emails
    //implemeny logginh
    //write test cases

    /*public int getCount(){
        return 0;
    }
    public String[] getEmail(){


        //unable to test due to Multi factor authenication for outlook account

            Properties props = System.getProperties();
            props.setProperty("mail.store.protocol", "imap");
            props.setProperty("mail.imap.ssl.enable", "true");
            props.setProperty("mail.imaps.partialfetch", "false");
            props.put("mail.mime.base64.ignoreerrors", "true");

            Session mailSession = Session.getInstance(props);
            mailSession.setDebug(true);
            Store store = mailSession.getStore("imap");
            store.connect("outlook.office365.com", "gopichand.t@hcl.com", "YOUR PASSWORD");


            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            System.out.println("Total Message:" + folder.getMessageCount());
            System.out.println("Unread Message:" + folder.getUnreadMessageCount());

            messages = folder.getMessages();

            for (Message mail : messages) {



                System.out.println("*********************************");
                System.out.println("MESSAGE : \n");

                System.out.println("Subject: " + mail.getSubject());
                System.out.println("From: " + mail.getFrom()[0]);
                System.out.println("To: " + mail.getAllRecipients()[0]);
                System.out.println("Date: " + mail.getReceivedDate());
                System.out.println("Size: " + mail.getSize());
                System.out.println("Flags: " + mail.getFlags());
                System.out.println("ContentType: " + mail.getContentType());
                System.out.println("Body: \n" + getEmailBody(mail));
                System.out.println("*******************************");

            }
        }
        return null;
    }
    public boolean markEmailAsRead(){
        return false;
    }*/


//}
