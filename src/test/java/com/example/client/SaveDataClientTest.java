package com.example.client;


import org.junit.Test
import org.junit.jupiter.api.Test;

public class SaveDataClientTest {

    @Test
    public void createNewIssue(){
        SaveDataClient s=new SaveDataClient();

        HistoricalIssue h=new HistoricalIssue(1,"CPU","10.20.30.245",2);

        s.createNewIssue(h);




    }


}
