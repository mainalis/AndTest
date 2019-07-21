package com.andDigital.AndTest.model;

import java.time.LocalDateTime;

public class Phone {

    private int phoneId;
    private boolean activeStatus;
    private long phoneNumber;
    private LocalDateTime contractStart;
    private LocalDateTime contractEnd;

    public Phone(int phoneId, long phoneNumber) {
        this.phoneId = phoneId;
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getContractStart() {
        return contractStart;
    }

    public void setContractStart(LocalDateTime contractStart) {
        this.contractStart = contractStart;
    }

    public LocalDateTime getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(LocalDateTime contractEnd) {
        this.contractEnd = contractEnd;
    }
}
