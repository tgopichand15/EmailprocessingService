package com.example.EmailProcessingservice;

import com.example.RulesService.entities.ExistingIssues;



public class FetchRules {


    //fetching issues that are listed in Rules service Db via API call
    public List<ExistingIssues> getIssues(){


        private final String URI_USERS_ID = "https://localhost:8080/issues_list/";

        @Autowired
        RestTemplate restTemplate;


        //Parse the string after getting the response
        List<ExistingIssues> l = restTemplate.getForObject(URI_USERS_ID, String.class);

        return l;
    }




}
