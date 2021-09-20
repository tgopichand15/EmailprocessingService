package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name="existing_issue")
public class ExistingIssue {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="issue_name")
    private String issueName;

    @Column(name="issue_frequency_for_ticket_creation")
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Column(name="ticket_assignation_team_name")
    private String teamName;


    @Override
    public String toString() {
        return "ExistingIssue{" +
                "id=" + id +
                ", issueName='" + issueName + '\'' +
                ", count=" + count +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
