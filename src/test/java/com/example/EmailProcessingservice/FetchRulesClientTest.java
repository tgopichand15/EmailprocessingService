package com.example.EmailProcessingservice;

import org.junit.jupiter.api.Test;

public class FetchRulesClientTest {

    @Test
    public void getIssuesWhenUserIdIsCorrectReturnsTop10 {
        // prep
        RestTemplate r = mock(RestTemplate.class);

        //loading test data
        List<ExistingIssue> l=new ArrayList<UnresolvedIssue>();
        ExistingIssue e=new ExistingIssue(1,"cpu",2);
        l.add(e);

        when(r.getIssues().thenReturn(l);


        ActionServiceClient c = new ActionServiceClient(r);

        // test
        List l = c.getIssues();

        //verify
        assertTrue(l.contains(1,"cpu",2);


    }

}
