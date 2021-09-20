package com.example.EmailProcessingservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionServiceClient {

    private static final Logger logger = LogManager.getLogger(ActionServiceClient.class);

    private final String ACTION_URL = "https://localhost:8080/Action_service/get";

    RestTemplate restTemplate;

    private SaveDataClientTest savedataclienttest;

    @Autowired
    public ActionServiceClient(RestTemplate r, SaveDataClientTest s) {
        this.restTe
    }


    public  List<unResolvedIssues> getnresolvedIssues(){

        logger.info("ferching list of unresolved issues from Action service via Interservice communincation calling api /Action_service");

        new RestTemplate()

        //Parse the string after getting the response
        List<unResolvedIssues> l = restTemplate.getForObject(actionServiceGetIssuesEndpointUrl, String.class);

        // get 10

        logger.info("fetched unresolved issues from Actionservice "+l);

        return l;
    }



    private void insertIssues (SaveDataClientTest savedataclienttest){

        logger.info("inserting unresolved issues into Db for later processing");

        //inserting unresolved issues to database

        savedataclienttest.insertUnresovedIsseus(getunresolvedIssues());
    }












}
