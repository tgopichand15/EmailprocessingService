package com.example.EmailProcessingservice;

public class FetchIssuesTobeTakenAction {

    //fetching issues that are listed in Rules service Db via API call
    public List<ExistingIssues> getIssues(){


        private final String URI_USERS_ID = "https://localhost:8080/Issues_to_be_forwared_to_actionService/";

        @Autowired
        RestTemplate restTemplate;


        //Parse the string after getting the response
        List<Issues> l = restTemplate.getForObject(URI_USERS_ID, String.class);

        return l;
    }

}
