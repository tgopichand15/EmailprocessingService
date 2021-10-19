package com.example.EmailProcessingservice;

import com.example.entities.ExistingIssue;
//import com.example.entities.UnresolvedIssue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SolutionServiceClient extends Thread {
    private static final Logger logger = LogManager.getLogger(SolutionServiceClient.class);


    private final String SolutionURL = "http://localhost:8766/Issues_to_be_forwared_to_actionService";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }



    public List<String> getIssues(){

        logger.info("ferching list of unresolved issues from Action service via Interservice communincation calling api /Action_service");


        RestTemplate restTemplate=new RestTemplate();
        //Parse the string after getting the response



            System.out.println(restTemplate.getForObject(SolutionURL, Object.class));



        //logger.info("fetched unresolved issues from Actionservice "+l);

        return null;
    }


    public static void main(String args[]){
        SolutionServiceClient s=new SolutionServiceClient();
        s.getIssues();
        //System.out.println(s.start());
    }



}
