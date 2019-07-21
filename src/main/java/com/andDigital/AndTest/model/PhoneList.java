package com.andDigital.AndTest.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneList {
    private List<Phone> phoneList;

    public PhoneList() {
        phoneList = new ArrayList<>();
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
}
