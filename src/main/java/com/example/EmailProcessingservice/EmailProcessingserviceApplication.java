package com.example.EmailProcessingservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
@EnableEurekaClient
public class EmailProcessingserviceApplication extends SpringBootServletInitializer {

	private static final Logger LOGGER = LogManager.getLogger(EmailProcessingserviceApplication.class);


	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(EmailProcessingserviceApplication.class, args);

		@Autowired
		private  GmailClient gmailclient;

		@Autowired
		private FetchFields fetchfields;

		//data removing duplicates

		logger.info("fetching latest emaails from Gmail client and getting issue data from rules service ");

		HashMap<String,Integer> h=fetchfields.getIssueData(gmailclient.check());


		@Autowired
		private SaveDataClientTest savedataclienttest;

		logger.info("fetching existing rules from Rules service so that it can be compared with Mail data");
		@Autowired
		private FetchRules fetchrules;
		//fetching existing rules from Rules service
		ArrayList<ExistingIssues> rules=fetchrules.getIssues();


        @Autowired
		private FetchIssuesTobeTakenAction fetchissues;

        logger.info("fetching issues to be taken action from end of soluton service");
        ArrayList<Issues> a=fetchissues.getIssues();


        //test



	}
}