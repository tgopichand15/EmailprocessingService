package com.example.client;

import org.junit.Test
import org.junit.jupiter.api.Test;

public class FetchDataClientTest {


    @Test
    public void getIssue(){

        //preparing data
        Issue i=new Issue(1,"CPU","10.20.230.40",false);

        when(r.getIssue().thenReturn(i));

        FetchDataClient f=new FetchDataClient();

        Issue k=new Issue(1,"CPU","10.20.230.40",false);

        assertTrue(f.getIssue()==k);

    }
}
