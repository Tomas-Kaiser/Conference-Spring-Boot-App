package com.tomas.conferencedemo.models;

import javax.persistence.*;

@Entity(name = "speakers")
public class Speaker {
    @Column(name = "speacker_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long speackerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String title;
    private String company;

    @Column(name = "speaker_bio")
    private String speakerBio;

    public Speaker() {
    }

    public long getSpeackerId() {
        return speackerId;
    }

    public void setSpeackerId(long speackerId) {
        this.speackerId = speackerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeakerBio() {
        return speakerBio;
    }

    public void setSpeakerBio(String speakerBio) {
        this.speakerBio = speakerBio;
    }
}
