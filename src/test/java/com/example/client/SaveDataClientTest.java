package com.example.client;


import org.junit.Test
import org.junit.jupiter.api.Test;

public class SaveDataClientTest {

    @Test
    public void test(){
        SaveDataClient s=new SaveDataClient();

        HistoricalIssue h=new HistoricalIssue(1,"CPU","10.20.30.245",2);

        when(s.createNewIssue(h).thenreturn(null);

        assertEqual(s.createNewIssue(h),null);

    }

    @Test
    public void test1(){
        SaveDataClient s=new SaveDataClient();

        HistoricalIssue h=new HistoricalIssue(1,"CPU","10.20.30.245",2);

        when(s.createHistoricalIssue(h).thenreturn(null);

        assertEqual(s.createHistoricalIssue(h),null);

    }

    @Test
    public void test2(){

    }







}
