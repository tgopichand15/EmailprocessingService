//package com.example.EmailProcessingservice;


//import com.example.util.HibernateUtil;
import com.example.EmailProcessingservice.GmailClient;
import com.example.client.SaveDataClient;
import com.example.entities.Issue;
import com.example.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class FetchFields  {

    private static final Logger logger = LogManager.getLogger(FetchFields.class);


    String ip="";
    String issueype="";
    String Description="";
    String Threshold="";

    //logger.info("fetching all required fields from Mail content so that they can be processed to next service");

    HashMap<String,Integer> hm=new HashMap<String,Integer>();

    //fetches ip address from input mail mail content
    private static String fetchIpFromString(String a){
        logger.info("fetching Ip pattern from the email content");
        String IPADDRESS_PATTERN ="(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(a);
        if (matcher.find()) {
            logger.info("found Ip pattern in email "+matcher.group());
            return matcher.group();
        } else{
            logger.info("no ip found with pattern so returning 0.0.0.0");
            return "0.0.0.0";
        }

    }




    //function to check if issue is already processed or not
    private static boolean isIssueProcessed(String Issuename){
        logger.info("check if issues is already processed or not");
        try{
                Session session = HibernateUtil.getSessionFactory().openSession() ;

                String issuetype=Issuename.split(" ")[1];

                String hostname=Issuename.split(" ")[0];
                int processed=1;


            System.out.println("issue type is "+issuetype);
            System.out.println("hostname is "+hostname);

            Query query1=session.createQuery("from Issue where Issue_name = :issuetype and hostname = :hostname and isProcessed=:processed");
            query1.setParameter("issuetype",issuetype);
            query1.setParameter("hostname",hostname);
            query1.setParameter("processed",processed);



            Issue i=(Issue)query1.uniqueResult();


            System.out.println("i si "+i);
            if(i!=null){
                return true;
            }
            else {
                return false;
            }

        }
        catch(HibernateException e){
            //logger.info("got an exception while checking if issue is already processed or not "+e.printStackTrace());
            e.printStackTrace();

        }
        return false;
    }


    //funcioncall from Gmailclient to fetch all mails
    //ArrayList<String> input=gmailclient.check();

    public HashMap<String,Integer> getIssueData(ArrayList<String> input) throws ArrayIndexOutOfBoundsException {

        //System.out.println("input is " + input);


        logger.info("getting mails list and fetching details using various function defined above");

        String r="";

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < input.size(); i++) {
            String temp = input.get(i);

            // System.out.println("temp is "+temp);
            String lines[] = (String[]) temp.split("\\r?\\n");

            //System.out.println(Arrays.toString(lines));


            //fetching fields from email

            System.out.println("lines is " + lines[1]);

            String ip = lines[1].split(":")[1];
            //System.out.println("lines[1] is "+lines[1]);
            String issuetype = lines[2].split(":")[1];
            String Description = lines[3].split(":")[1];
            String Threshold = lines[4].split(":")[1];

            System.out.println("ip is " + ip);
            System.out.println("issuetyoe is " + issuetype);
            System.out.println("Descriptiion is " + Description);
            System.out.println("Threshold is " + Threshold);


            r = ip + " " + issuetype;


            System.out.println("r is " + r);
            //hm.put(r,1);


            boolean a = isIssueProcessed(r);
            if (a == false) {
                if (hm.containsKey(r)) {
                    hm.put(r, hm.get(r) + 1);
                } else {
                    hm.put(r, 1);
                }
            }

        }


        return hm;
    }

    @Autowired
    static GmailClient gmailclient;

    @Autowired
    static SaveDataClient savedataclient;


    public static void main(String[] args){


        FetchFields fetchfields=new FetchFields();

        HashMap<String,Integer> h=fetchfields.getIssueData(gmailclient.check());

        System.out.println("h is "+h);

        savedataclient.createIssueforProcessingintoDB(h);



    }





}
