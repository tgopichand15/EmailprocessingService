package com.example.entities;


import javax.persistence.*;
import javax.xml.ws.WebServiceProvider;

@Entity
@Table(name="Issue")
public class Issue {


    @Id
    @Column(name = "issue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Issue_name")
    private String Issuename;

    @Column(name="hostname")
    private String hostname;

    @Column(name = "isProcessed")
    private int isProcessed;

    public String getIssuename() {
        return Issuename;
    }

    public void setIssuename(String issuename) {
        Issuename = issuename;
    }

    public int getIsProcessed() {
        return isProcessed;
    }

    public void setIsProcessed(int isProcessed) {
        this.isProcessed = isProcessed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @Override
    public String toString() {
        return "Issues{" +
                "id=" + id +
                ", Issuename='" + Issuename + '\'' +
                ", hostname='" + hostname + '\'' +
                ", isProcessed=" + isProcessed +
                '}';
    }
}




