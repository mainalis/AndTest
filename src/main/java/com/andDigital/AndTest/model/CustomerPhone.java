package com.andDigital.AndTest.model;

public class CustomerPhone {

    private int customerId;
    private int phoneId;

    public CustomerPhone(int customerId, int phoneId) {
        this.customerId = customerId;
        this.phoneId = phoneId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }
}
