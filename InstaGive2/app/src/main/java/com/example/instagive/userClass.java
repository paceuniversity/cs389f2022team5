package com.example.instagive;

public class userClass {
    private String name;
    private String phone;
    private String email;
    private String userName;
    private String password;
    private int donations;
    public userClass() {
        donations = 0;
    }

    public userClass(String mName, String mEmail, String mPhone, String mUser, String mPassword) {
        name = mName;
        email = mEmail;
        phone = mPhone;
        userName = mUser;
        password = mPassword;
        donations = 0;
    }

    @Override
    public String toString() {
        return "name='" + name + ", phone='" + phone  + ", email='" + email ;
    }

    public int getDonations() {
        return donations;
    }

    public void setDonations(int donations) {
        this.donations = donations;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
