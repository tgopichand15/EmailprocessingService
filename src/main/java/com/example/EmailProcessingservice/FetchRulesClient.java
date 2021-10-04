/*package com.example.EmailProcessingservice;

import com.example.RulesService.entities.ExistingIssues;
import com.example.entities.ExistingIssue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class FetchRulesClient {



    private static final Logger logger = LogManager.getLogger(FetchRulesClient.class);



    private final String issueUrl = "https://localhost:8080/issues_list/";

    private RestTemplate restTemplate;

    @Autowired
    public FetchRulesClient(RestTemplate r){
        this.restTemplate=r;
    }




    //fetching issues that are listed in Rules service Db via API call
    public List<ExistingIssue> getIssues(){


        logger.info("fetching issues from existing issues list Rules service");

        //Parse the string after getting the response
        List<ExistingIssue> l = restTemplate.getForObject(issueUrl, String.class);

        logger.info("getched issues list from rules service "+l);

        return l;
    }




}*/
