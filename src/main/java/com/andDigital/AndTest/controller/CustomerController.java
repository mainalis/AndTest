package com.andDigital.AndTest.controller;


import com.andDigital.AndTest.Exception.ResourceNotFoundException;
import com.andDigital.AndTest.Util;
import com.andDigital.AndTest.model.CustomerPhone;
import com.andDigital.AndTest.model.Phone;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//  http://localhost:8080/api/v1/phoneNumbers

@RestController
@RequestMapping("api/v1")
public class CustomerController {

   @GetMapping("/getAllPhoneNumbers")
    public List<Phone> getAllPhoneNumbers() {
       return Util.phoneRepo;
   }

   @GetMapping("/phoneNumber/{id}")
   public List<Phone> getPhoneNumberByPersonId(@PathVariable(value = "id") int userId) {

       List<Phone> matchedPhone = new ArrayList();
       List<CustomerPhone> customerPhoneList = Util.customerPhoneRep.stream().filter(item -> item.getCustomerId() == userId).collect(Collectors.toList());

       for(CustomerPhone customerPhone : customerPhoneList) {
           Optional<Phone> matchedPhoneOptional = Util.phoneRepo.stream().filter(phone -> phone.getPhoneId() == customerPhone.getPhoneId()).findAny();
           if(matchedPhoneOptional.isPresent()) {
               matchedPhone.add(matchedPhoneOptional.get());
           }

       }

       return matchedPhone;
   }

   @PutMapping("/acivatePhoneNumber/{id}")
    public ResponseEntity<Phone> acitivatePhoneNumber(@PathVariable(value = "id") int phoneId) throws ResourceNotFoundException {
       Optional<Phone> phoneOptional = Util.phoneRepo.stream().filter(phone -> phone.getPhoneId() == phoneId).findAny();
       if(phoneOptional.isPresent()) {
           phoneOptional.get().setActiveStatus(true);
           return ResponseEntity.ok(phoneOptional.get());
       } else {
           throw new ResourceNotFoundException("Phone number not found");
       }

   }

}
