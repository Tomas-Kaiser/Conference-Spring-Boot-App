package com.tomas.conferencedemo.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
public class Speaker {
    @Column(name = "speaker_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long speakerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String title;
    private String company;

    @Column(name = "speaker_bio")
    private String speakerBio;

    @ManyToMany(mappedBy = "speakers")
    private List<Session> sessions;

    // This is for binary data. Lob => Large Object
    @Column(name = "speaker_photo")
    @Lob
//    @Type(type = "org.hibernate.type.binaryType")
    private byte[] speakerPhoto;

    public Speaker() {
    }

    public byte[] getSpeakerPhoto() {
        return speakerPhoto;
    }

    public void setSpeakerPhoto(byte[] speakerPhoto) {
        this.speakerPhoto = speakerPhoto;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(long speackerId) {
        this.speakerId = speackerId;
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
