package com.example.EmailProcessingservice;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SolutionServiceClientTest {

    @Test
    public void getIssuesWhenUserIdIsCorrectReturnsTop10 {
        // prep
        RestTemplate r = mock(RestTemplate.class);

        //loading test data
        List<UnresolvedIssue> l=new ArrayList<ExistingIsuues>();
        UnresolvedIssue u=new UnresolvedIssue(1,"wintel","10.20.30.245");
        l.aad(u);

        when(r.getIssues().thenReturn(l);


        SolutionServiceClient c = new SolutionServiceClient(r);

        // test
        List l = c.getIssues();

        //verify
        assertTrue(l.contains(1,"Wintel,"10.20.220.55");


    }

}
