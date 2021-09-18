package com.example.EmailProcessingservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionServiceClient {

    private static final Logger logger = LogManager.getLogger(ActionServiceClient.class);

    private final String actionServiceGetIssuesEndpointUrl = "https://localhost:8080/Action_service/";

    @Autowired
    RestTemplate restTemplate;


    @Autowired
    private SaveDataClientTest savedataclienttest;


    public  List<unResolvedIssues> getunresolvedIssues(String actionServiceGetIssuesEndpointUrl,RestTemplate restTemplate){


        logger.info("ferching list of unresolved issues from Action service via Interservice communincation calling api /Action_service");



        //Parse the string after getting the response
        List<unResolvedIssues> l = restTemplate.getForObject(actionServiceGetIssuesEndpointUrl, String.class);

        logger.info("fetched unresolved issues from Actionservice "+l);

        return l;
    }



    logger.info("inserting unresolved issues into Db for later processing");
    //inserting unresolved issues to database
    savedataclienttest.insertUnresovedIsseus(getunresolvedIssues());









}
