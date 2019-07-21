package com.andDigital.AndTest.model;

public class Customer extends Person {

    private int customerId;
    private boolean activeStatus;

    public Customer(int personId, String firstName, String lastName, int customerId) {
        super(personId, firstName, lastName);
        this.customerId = customerId;
    }

    @Override
    public String toString() {

         return "{ " + "personId=" + getPersonId() +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                " customerId=" + customerId  + " }";
    }
}

