/*package com.example.EmailProcessingservice;

import org.junit.jupiter.api.Test;

public class ActionServiceClientTest {


    @Test
    public void getIssuesWhenUserIdIsCorrectReturnsTop10 {
        // prep
        RestTemplate r = mock(RestTemplate.class);

        //loading test data
        List<UnresolvedIssue> l=new ArrayList<UnresolvedIssue>();
        UnresolvedIssue u=new UnresolvedIssue(1,"Wintel","10.20.220.55");
        l.aad(u);

        when(r.getUnresolvedIssues().thenReturn(l);


        ActionServiceClient c = new ActionServiceClient(r);

        // test
        List l = c.getUnresolvedIssues();

        //verify
        assertTrue(l.contains(1,"Wintel,"10.20.220.55");


    }


}*/
