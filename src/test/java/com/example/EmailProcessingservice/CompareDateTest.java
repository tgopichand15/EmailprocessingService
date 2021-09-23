package com.example.EmailProcessingservice;

import org.junit.jupiter.api.Test;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.HashMap;

public class CompareDateTest {

    //preparing data
    List testData = new ArrayList<ExistingIssue>();
    ExisitingIssue e=new ExistinfIssue(1,"CPU",2);
    ExistingIssue e1=new ExisitngIssue(2,"Memory",3);
    testData.add(e);
    testdata.add(e1);



    HashMap<String,Integer> hm=new HashMap<String,Integer>();
    hm.put("10.20.30.44 CPU",2);


    HashMap<String,Integer> hm1=new HashMap<String,Integer>();
    hm1.put("10.20.30.44 CPU",2);
    hm1.put("10.30.40.56 Memory",4);

    //since we wont have live input just verifying with dummy input and also specifying return value as predefined
    when(r.getUnresolvedIssues(hm,l).thenReturn(hm1);


    @Test
    public boolean compareEmailAndRulesdata(HashMap<String,Integer> hm,ArrayList<ExistingIssue> l){



        CompareData c=new CompareData();
        HashMap<String,String> h=c.compareEmailAndRulesData(hm,l);

        AssertTrue(h.contians(e.issuename)));
        AssertTrue(h.get("10.20.30.44 CPU") ==2);

    }

}

