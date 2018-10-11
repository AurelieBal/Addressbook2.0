package com.telran.repeat.model;

public class Contact {
    private  String fName;
    private  String lName;
    private  String address;
    private  String email;
    private  String phone;

    public Contact setfName(String fName) {
        this.fName = fName;
        return this;
    }

    public Contact setlName(String lName) {
        this.lName = lName;
        return this;
    }

    public Contact setAddress(String address) {
        this.address = address;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
