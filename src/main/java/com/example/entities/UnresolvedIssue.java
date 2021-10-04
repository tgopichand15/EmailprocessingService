package com.example.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UnresolvedIssue {

    @Id
    @Column(name="issue_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="assignedtoteam")
    private String assignedToTeam;

    @Column(name="issuetype")
    private String issuetype;

    public String getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(String issuetype) {
        this.issuetype = issuetype;
    }

    @Column(name="Hostname")
    private String Hostname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssignedToTeam() {
        return assignedToTeam;
    }

    public void setAssignedToTeam(String assignedToTeam) {
        this.assignedToTeam = assignedToTeam;
    }

    public String getHostname() {
        return Hostname;
    }

    public void setHostname(String hostname) {
        Hostname = hostname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnresolvedIssue that = (UnresolvedIssue) o;
        return id == that.id &&
                Objects.equals(assignedToTeam, that.assignedToTeam) &&
                Objects.equals(issuetype, that.issuetype) &&
                Objects.equals(Hostname, that.Hostname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assignedToTeam, issuetype, Hostname);
    }


    @Override
    public String toString() {
        return "UnresolvedIssue{" +
                "id=" + id +
                ", assignedToTeam='" + assignedToTeam + '\'' +
                ", issuetype='" + issuetype + '\'' +
                ", Hostname='" + Hostname + '\'' +
                '}';
    }
}

