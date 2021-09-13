package com.example.EmailProcessingservice;

import com.example.RulesService.entities.ExistingIssues;

public class CompareEmailandRulesData {


    public HashMap<String,String> compareEmailAndRulesdata(HashMap<String,Integer> hm,ArrayList<ExistingIssues> al){


        if(hm.isEmpty() || al.size() ==0){

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
                        issueToBeTicketed.put(a.getIssuename.split(" ")[0],a.getIssuename.split(" ")[1]);
                    }
                }
            }

        }

        //insert hashmap data which contains issues to be processed to solution service into DB for backup

        @Autowired
        private SaveDataClientTest savedataclient;











    }
}
