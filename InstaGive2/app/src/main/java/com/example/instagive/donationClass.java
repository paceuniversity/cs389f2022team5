package com.example.instagive;

public class donationClass {
    private String name;
    private String phone;
    private String address;
    private String userName;
    private String date;
    private String item_name;
    private String time;
    private String title;
    private String notes;
    private String organization;
    private int number;
    private String hisTitle;
    public donationClass() {

    }

    public donationClass(String name, String phone, String address, String userName, String date, String item_name, String notes, String time, String title, String organization,String hisTitle, int number) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.userName = userName;
        this.date = date;
        this.item_name = item_name;
        this.notes = notes;
        this.time = time;
        this.title = title;
        this.organization = organization;
        this.number = number;
        this.hisTitle = hisTitle;

    }

    public String getHisTitle() {
        return hisTitle;
    }

    public void setHisTitle(String hisTitle) {
        this.hisTitle = hisTitle;
    }

    @Override
    public String toString() {
       String out  = title + " Date: " + date + " Time: " + time+ "Pick Up: " + address + "Destination: " + organization;
        return out;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
