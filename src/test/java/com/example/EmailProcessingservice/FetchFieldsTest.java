package com.example.EmailProcessingservice;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;


th dummy input and also specifying return value as predefined
        when(r.getUnresolvedIssues(hm,l).thenReturn(hm1);
public class FetchFieldsTest {

    //preparing data
    ArrayList<String> email=new ArrayList<String>();
    email.add("10.20.30.245,cpu,cpu spike to very high percentage,98");

    HashMap<String,Integer> hm1=new HashMap<String,Integer>();
    hm1.put("10.20.30.245 cpu",1);


    when(r.getIssueData(email).thenReturn(hm1);

    FtechFields f=new FetchFields();

    @Test
    public boolean checkFields(){
        HashMap<String,Integer> output=f.getIssueData(email);

        if(hm.contains("10.20.30.245 cpu") && hm.get("10.20.30.245 cpu") ==1){
            return true;
        }
        return false;
    }

}
