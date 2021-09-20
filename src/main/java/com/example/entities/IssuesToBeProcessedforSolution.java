package com.example.entities;

import javax.persistence.*;

@Entity
@Table(name="Issues_to_be_processed")
public class IssuesToBeProcessedforSolutions {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="issueName")
    private String issueName;

    @Column(name="hostname")
    private String hostname;

    @Column(name="frequency")
    private int frequency;

    @Column(name="Description")
    private String Description;


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

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "IssuesToBeProcessedforSolutions{" +
                "id=" + id +
                ", issueName='" + issueName + '\'' +
                ", hostname='" + hostname + '\'' +
                ", frequency=" + frequency +
                ", Description='" + Description + '\'' +
                '}';
    }
}
