package com.example.EmailProcessingservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class GmailClientTest {

    @Test
    void check() {

        GmailClient g=new GmailClient();

        //prepare data
        ArrayList<String> testData=new ArrayList<String>();

        testData.add("10.20.800.200");


        assertTrue(g.check().contains("10.20.800.200"));
    }
}