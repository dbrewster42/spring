package com.teks.users.user.model;

import javax.persistence.*;

@Entity
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
    @Id
    @Column(nullable = false, unique = true)
    private String userId;

    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private String encryptedPassword;
    private boolean emailVerificationStatus = false;

    public User(String firstName, String lastName, String email) {
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
//        this.encryptedPassword = encryptedPassword;
    }

    public User(){
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return userId;
    }
    public void setEmailVerificationStatus(boolean emailVerificationStatus){
        this.emailVerificationStatus = emailVerificationStatus;
    }
    public boolean getEmailVerificationStatus(){
        return emailVerificationStatus;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

}

