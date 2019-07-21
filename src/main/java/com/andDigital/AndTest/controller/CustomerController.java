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

//  http://localhost:8080/api/v1/getAllPhoneNumbers

//

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    /**
     * Function for returning all phone number from database
     * @return
     */
   @GetMapping("/getAllPhoneNumbers")
    public List<Phone> getAllPhoneNumbers() {
       return Util.phoneRepo;
   }

    /**
     * Function for getting phone number of selected user
     * @param userId
     * @return
     */
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

    /**
     * Function for activating phone nimber
     * @param phoneId desired phone number
     * @return success or failure status
     * @throws ResourceNotFoundException
     */

   @PutMapping("/activatePhoneNumber/{id}")
    public ResponseEntity<Phone> activatePhoneNumber(@PathVariable(value = "id") int phoneId) throws ResourceNotFoundException {
       Optional<Phone> phoneOptional = Util.phoneRepo.stream().filter(phone -> phone.getPhoneId() == phoneId).findAny();
       if(phoneOptional.isPresent()) {
           phoneOptional.get().setActiveStatus(true);
           return ResponseEntity.ok(phoneOptional.get());
       } else {
           throw new ResourceNotFoundException("Phone number not found");
       }

   }

}
