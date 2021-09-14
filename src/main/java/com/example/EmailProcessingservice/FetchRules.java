package com.example.EmailProcessingservice;

import com.example.RulesService.entities.ExistingIssues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FetchRules {



    private static final Logger logger = LogManager.getLogger(FetchRules.class);


    //fetching issues that are listed in Rules service Db via API call
    public List<ExistingIssues> getIssues(){


        logger.info("fetching issues from existing issues list Rules service");

        private final String URI_USERS_ID = "https://localhost:8080/issues_list/";

        @Autowired
        RestTemplate restTemplate;


        //Parse the string after getting the response
        List<ExistingIssues> l = restTemplate.getForObject(URI_USERS_ID, String.class);

        logger.info("getched issues list from rules service "+l);

        return l;
    }




}
