package com.example.springboot.thymeleafdemo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_detail")
public class EmployeeDetail {
    
    public EmployeeDetail() {}
    
    public EmployeeDetail(String linkedinProfile, String hobby) {
        this.linkedinProfile = linkedinProfile;
        this.hobby = hobby;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="linkedin_profile")
    private String linkedinProfile;

    @Column(name="hobby")
    private String hobby;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkedinProfile() {
        return linkedinProfile;
    }

    public void setLinkedinProfile(String linkedinProfile) {
        this.linkedinProfile = linkedinProfile;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "EmployeeDetail [id=" + id + ", linkedinProfile=" + linkedinProfile + ", hobby=" + hobby + "]";
    }    

}
