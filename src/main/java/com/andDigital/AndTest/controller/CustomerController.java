package com.andDigital.AndTest.controller;

import andDigital.model.Customer;
import andDigital.model.CustomerPhone;
import andDigital.model.Person;
import andDigital.model.Phone;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomerController {

    public static void main(String... args) {
        init();
    }

    public static void init() {
        List<Person> customerRepo = new ArrayList();
        List<Phone> phoneRepo= new ArrayList();
        List<CustomerPhone> customerPhoneRep = new ArrayList();

        for(int i=0; i < 10; i++) {
            Person tempPerson = new Customer( i +1, getRandomName(10), getRandomName(10), i+1);
            Phone tempPhone = new Phone( i +1, getPhoneNumber());
            CustomerPhone tempCustomerPhone = new CustomerPhone(tempPerson.getPersonId(), tempPhone.getPhoneId());
            customerRepo.add(tempPerson);
            phoneRepo.add(tempPhone);
            customerPhoneRep.add(tempCustomerPhone);
        }

        customerRepo.stream().forEach(item-> {
            System.out.println("item " + item);
        });
    }

    public static String getRandomName(int lengthOfStr) {

        return new Random().ints(48,123)
                .filter(i -> (i < 58) || (i > 64 && i < 91) || (i > 96))
                .limit(lengthOfStr)
                .collect(StringBuilder::new, (sb, i) -> sb.append((char) i), StringBuilder::append).toString();
    }

    public static long getPhoneNumber() {
        long[] phoneArray = new long []{ 7700_900007L,7700_900170L,7700_900549L, 7700_900680L, 7700_900491L, 7700_900849L, 7700_900170L, 7700_900680L, 7700_900491L, 7700_900941L, 7700_800491L};
        int index = new Random().nextInt(11);
        return phoneArray[index];
    }
}