package com.example.EmailProcessingservice;

import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;

/*public class FetchFields {




    String ip="";
    String issueype="";
    String Description="";
    String Threshold="";

    HashMap<String,Integer> hm=new HashMap<String,Integer>();

    //fetches ip address from input mail mail content
    private static String fetchIpFromString(String a){
        String IPADDRESS_PATTERN =
                "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(a);
        if (matcher.find()) {
            return matcher.group();
        } else{
            return "0.0.0.0";
        }

    }




    //function to check if issue is already processed or not
    private static boolean isIssueProcessed(int Issuename){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
           Query query1=session.createQuery("from Issues where Issue_name = :Isuuename and isProcessed:=1");
           Issues i=query1.getUniqueResult();

           if(i!=null){
               rerurn true;
           }
           else {
               return false;
           }

        }
        catch(HibernateException e){
            e.printStackTrace();

        }
    }


    //funcioncall from Gmailclient to fetch all mails
    //ArrayList<String> input=gmailclient.check();

     private HashMap<String,Integer> getIssueData(ArrayList<String> input) {

         HashMap<String,Integer> hm=new HashMap<String,Integer>();
         for (i = 0; i < input.length; i++) {
             String temp = input.get(i);
             String lines[] = temp.split("\\r?\\n");

             //fetching fields from email
             ip = fetchIpFromString(lines[0]);
             issuetype = lines[1].split(":")[1];
             Description = lines[2].split(":")[1];
             Threshold = lines[3].split(":")[1];


             String r = ip + " " + issuetype;

             boolean a = isIssueProcessed(r);
             if (a) {
                 if (hm.containsKey(r)) {
                     hm.put(r, hm.get(r) + 1);
                 } else {
                     hm.put(r, 1);
                 }
             }
         }
         return hm;
     }





}*/
