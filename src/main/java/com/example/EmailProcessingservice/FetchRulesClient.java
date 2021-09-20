package com.example.EmailProcessingservice;

import com.example.RulesService.entities.ExistingIssues;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FetchRulesClient {



    private static final Logger logger = LogManager.getLogger(FetchRulesClient.class);



    private final String issueUrl = "https://localhost:8080/issues_list/";

    @Autowired
    private RestTemplate restTemplate;




    //fetching issues that are listed in Rules service Db via API call
    public List<ExistingIssues> getIssues(){


        logger.info("fetching issues from existing issues list Rules service");

        //Parse the string after getting the response
        List<ExistingIssues> l = restTemplate.getForObject(issueUrl, String.class);

        logger.info("getched issues list from rules service "+l);

        return l;
    }




}
