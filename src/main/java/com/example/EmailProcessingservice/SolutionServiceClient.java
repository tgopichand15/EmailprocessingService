package com.example.EmailProcessingservice;

import com.example.entities.ExistingIssue;
import com.example.entities.UnresolvedIssue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class SolutionServiceClient {
    private static final Logger logger = LogManager.getLogger(SolutionServiceClient.class);


    private final String SolutionURL = "https://localhost:8080/Action_service/get";

    private RestTemplate restTemplate;


    @Autowired
    public SolutionServiceClient(RestTemplate r) {
        this.restTemplate=r;
    }




    public  List<UnresolvedIssue> getIssues(){

        logger.info("ferching list of unresolved issues from Action service via Interservice communincation calling api /Action_service");


        //Parse the string after getting the response
        List<UnresolvedIssue> l = restTemplate.getForObject(SolutionURL, String.class);


        logger.info("fetched unresolved issues from Actionservice "+l);

        return l;
    }





    //fetching issues that are listed in Rules service Db via API call
    /*public List<ExistingIssue> getIssues(){

        logger.info("calling issues after solution service which are to be forwarded to Action service");


        //Parse the string after getting the response
        List<Issue> l = restTemplate.getForObject(SolutionServiceUrl, String.class);

        logger.info("issues to be forwarded to action service from solution service is "+l);

        return l;
    }*/

}
