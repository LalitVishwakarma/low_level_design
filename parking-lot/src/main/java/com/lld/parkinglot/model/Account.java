package com.lld.parkinglot.model;

// For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter methods and modified only through their public methods function.

import com.lld.parkinglot.config.AccountStatus;

public interface Account {
    String userName;
    String password;
    AccountStatus status;
    Person person;

    public boolean resetPassword();
}