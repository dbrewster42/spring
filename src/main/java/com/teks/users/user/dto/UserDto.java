package com.teks.users.user.dto;

public class UserDto {
//    private int id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
//    private String emailVerificationToken;
    private String getEmailVerificationStatus;

    public UserDto(String userId, String firstName, String lastName, String email, String password, String encryptedPassword, String getEmailVerificationStatus) {
//        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.encryptedPassword = encryptedPassword;
        this.getEmailVerificationStatus = getEmailVerificationStatus;
    }
    public UserDto(){
    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getGetEmailVerificationStatus() {
        return getEmailVerificationStatus;
    }

    public void setGetEmailVerificationStatus(String getEmailVerificationStatus) {
        this.getEmailVerificationStatus = getEmailVerificationStatus;
    }
}
