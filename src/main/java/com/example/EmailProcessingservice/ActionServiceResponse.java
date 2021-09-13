package com.example.EmailProcessingservice;

public class ActionServiceResponse {

    public static List<UnresolvedIssues> getunresolvedIssues(){


        private final String URI_USERS_ID = "https://localhost:8080/Action_service/";

        @Autowired
        RestTemplate restTemplate;


        //Parse the string after getting the response
        List<UnresolvedIssues> l = restTemplate.getForObject(URI_USERS_ID, String.class);

        return l;
    }


    @Autowired
    private SaveDataClientTest savedataclienttest;

    //inserting unresolved issues to database
    savedataclienttest.insertUnresovedIsseus(getunresolvedIssues());









}
