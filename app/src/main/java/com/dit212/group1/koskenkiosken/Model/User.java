package com.dit212.group1.koskenkiosken.Model;

public class User {

    private String userName;
    private String password;
    private String mail;
    private int userID;
    private int credits;

    public User(String userName, String password, String mail, int userID, int credits) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
        this.userID = userID;
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Constructor for mock-user.
     */
    public User(){
        this.userName = "FirstUser";
        this.password = "hemligt";
        this.mail     = "Ackaman11@gmail.com";
        this.userID   = 0;
        this.credits  = 100;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
