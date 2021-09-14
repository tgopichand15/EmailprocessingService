package com.example.EmailProcessingservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionServiceResponse {

    private static final Logger logger = LogManager.getLogger(ActionServiceResponse.class);


    public static List<UnresolvedIssues> getunresolvedIssues(){


        logger.info("ferching list of unresolved issues from Action service via Interservice communincation calling api /Action_service");
        private final String URI_USERS_ID = "https://localhost:8080/Action_service/";

        @Autowired
        RestTemplate restTemplate;




        //Parse the string after getting the response
        List<UnresolvedIssues> l = restTemplate.getForObject(URI_USERS_ID, String.class);

        logger.info("fetched unresolved issues from Actionservice "+l);

        return l;
    }


    @Autowired
    private SaveDataClientTest savedataclienttest;

    logger.info("inserting unresolved issues into Db for later processing");
    //inserting unresolved issues to database
    savedataclienttest.insertUnresovedIsseus(getunresolvedIssues());









}
