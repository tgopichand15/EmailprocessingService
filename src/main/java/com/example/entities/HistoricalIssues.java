package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name="HistoricalIssues")
public class HistoricalIssues {

    @Id
    @Column(name="HistoricalIssie_id")
    @GeneratedValue(Strategy=GenerationType.IDENTITy)
    int id;

    @Column(name="Issue_name")
    String Issue;

    @Column(name="hostname")
    String Hostname;

    @Column(name="count")
    int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssue() {
        return Issue;
    }

    public void setIssue(String issue) {
        Issue = issue;
    }

    public String getHostname() {
        return Hostname;
    }

    public void setHostname(String hostname) {
        Hostname = hostname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "HistoricalIssues{" +
                "id=" + id +
                ", Issue='" + Issue + '\'' +
                ", Hostname='" + Hostname + '\'' +
                ", count=" + count +
                '}';
    }
}
