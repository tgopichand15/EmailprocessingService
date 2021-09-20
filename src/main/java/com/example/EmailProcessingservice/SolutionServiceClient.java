package com.example.EmailProcessingservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SolutionServiceClient {
    private static final Logger logger = LogManager.getLogger(SolutionServiceClient.class);

    logger.info("fetching issues which are to be taken action after solution service which are to be processed to action service");

    private final String SolutionServiceUrl = "https://localhost:8080/Issues_to_be_forwared_to_actionService/";

    @Autowired
    RestTemplate restTemplate;


    //fetching issues that are listed in Rules service Db via API call
    public List<ExistingIssue> getIssues(){

        logger.info("calling issues after solution service which are to be forwarded to Action service");


        //Parse the string after getting the response
        List<Issues> l = restTemplate.getForObject(SolutionServiceUrl, String.class);

        logger.info("issues to be forwarded to action service from solution service is "+l);

        return l;
    }

}
