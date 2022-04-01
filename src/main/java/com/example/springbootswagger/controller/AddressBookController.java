package com.example.springbootswagger.controller;

import com.example.springbootswagger.entity.Contact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {

    private ConcurrentMap<String, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    @ApiOperation(value = "Finds Contacts by id",
                  notes = "Provide an id to look up specific contact",
                  response = Contact.class)
    public Contact getContactById(@ApiParam(value = "Id value for the contact you need to retrieve", required = true)
                                  @PathVariable String id) {
        return contacts.get(id);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return new ArrayList<Contact>(contacts.values());
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        contacts.put(contact.getId(), contact);
        return contact;
    }

}
