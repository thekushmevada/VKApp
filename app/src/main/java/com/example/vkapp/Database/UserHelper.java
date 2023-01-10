package com.example.vkapp.Database;

import com.example.vkapp.LoadingDialog;

public class UserHelper {
    public String fname,lname,username,password;
    public String phoneNo;
    public String department,address;

    public UserHelper() {
        //void
    }

    public UserHelper(String fname, String lname, String username, String password, String department, String address, String phoneNo) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.department = department;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    

    /*public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/
}
