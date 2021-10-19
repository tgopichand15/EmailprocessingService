package com.example.EmailProcessingservice;

import com.example.entities.ExistingIssue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@SpringBootApplication
@EnableEurekaClient
public class EmailProcessingserviceApplication  {

	private static final Logger LOGGER = LogManager.getLogger(EmailProcessingserviceApplication.class);


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Autowired
    static FetchRulesClient fetchrules;


    @Autowired
     private static RestTemplate restTemplate;



    public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(EmailProcessingserviceApplication.class, args);

        SpringApplication.run(EmailProcessingserviceApplication.class, args);

        System.out.println(fetchrules.getIssues(fetchrules));


		/*@Autowired
		public  GmailClient gmailclient;

		@Autowired
		public FetchFields fetchfields;




		//data removing duplicates

		logger.info("fetching latest emaails from Gmail client and getting issue data from rules service ");

		HashMap<String,Integer> h=fetchfields.getIssueData(gmailclient.check());


		@Autowired
		public SaveDataClientTest savedataclienttest;

		logger.info("fetching existing rules from Rules service so that it can be compared with Mail data");


		savedataclienttest.createIssueforProcessingintoDB()*/

		//fetching existing rules from Rules service
		//List<ExistingIssue> rules=restTemplate.getIssues(fetchrules);


		//System.out.println("rules are "+rules);


        /*@Autowired
		public SolutionServiceClient fetchissues;

        logger.info("fetching issues to be taken action from end of soluton service");
        ArrayList<Issue> a=fetchissues.getIssues();*/


        //test



	}
}