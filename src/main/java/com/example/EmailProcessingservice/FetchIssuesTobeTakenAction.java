package com.example.EmailProcessingservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FetchIssuesTobeTakenAction {
    private static final Logger logger = LogManager.getLogger(FetchIssuesTobeTakenAction.class);


    logger.info("fetching issues which are to be taken action after solution service which are to be processed to action service");
    //fetching issues that are listed in Rules service Db via API call
    public List<ExistingIssues> getIssues(){

        logger.info("calling issues after solution service which are to be forwarded to Action service");


        private final String URI_USERS_ID = "https://localhost:8080/Issues_to_be_forwared_to_actionService/";

        @Autowired
        RestTemplate restTemplate;


        //Parse the string after getting the response
        List<Issues> l = restTemplate.getForObject(URI_USERS_ID, String.class);

        logger.info("issues to be forwarded to action service from solution service is "+l);

        return l;
    }

}
