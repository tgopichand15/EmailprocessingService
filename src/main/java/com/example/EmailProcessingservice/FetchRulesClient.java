package com.example.EmailProcessingservice;

import com.example.entities.ExistingIssue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FetchRulesClient {



    private static final Logger logger = LogManager.getLogger(FetchRulesClient.class);



    private final String issueUrl = "https://localhost:8761/issues_list/";

    private RestTemplate restTemplate;

    @Autowired
    public FetchRulesClient(RestTemplate r){
        this.restTemplate=r;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FetchRulesClient(){

    }




    //fetching issues that are listed in Rules service Db via API call
    public List<ExistingIssue> getIssues(FetchRulesClient f){


        logger.info("fetching issues from existing issues list Rules service");

        //Parse the string after getting the response
        List<ExistingIssue> l = (List<ExistingIssue>)f.getRestTemplate().getForObject(issueUrl,ExistingIssue.class);

        logger.info("getched issues list from rules service "+l);

        return l;
    }




}
