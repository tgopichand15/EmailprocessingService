package com.example.EmailProcessingservice;

import com.example.RulesService.entities.ExistingIssues;
import com.example.client.FetchDataClientTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompareEmailandRulesData {

    private static final Logger logger = LogManager.getLogger(CompareEmailandRulesData.class);



    public HashMap<String,String> compareEmailAndRulesdata(HashMap<String,Integer> hm,ArrayList<ExistingIssues> al){

        logger.info("comparing Email hashmap values and Rules defined in DB for matches");


        if(hm.isEmpty() || al.size() ==0){
            logger.info("hashmap for emails empty to chech in DB");
            System.out.println("no Entries to check or no issues in Db");
            return;
        }

        Iterator hmIterator = hm.entrySet().iterator();

        HashMap<String,String> issueToBeTicketed=new HashMap<String,String>();

        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            int count = ((int)mapElement.getValue());
            foreach(ExistingIssues e:al){
                if(a.getIssuename().split(" ")[0] == mapElement){
                    int DbCount=a.getCount();
                    if(count >= Dbcount){
                         logger.info("issue found in Hashmap which has to be ticketed");
                        issueToBeTicketed.put(a.getIssuename.split(" ")[0],a.getIssuename.split(" ")[1]);
                    }
                }
            }

        }

        //insert hashmap data which contains issues to be processed to solution service into DB for backup

        @Autowired
        private SaveDataClientTest savedataclient;

        logger.info("inserting the hashmap values obtained after comparing mails and RUles data storing as backup in Issues");

        savedataclienttest.insertIssuestobeProcessedBysolutionService(issueToBeTicketed);











    }
}
