package com.danielrubiano.Lab1.controller;

import java.util.Optional;

import com.danielrubiano.Lab1.businessDelegatePattern.BusinessDelegate;
import com.danielrubiano.Lab1.businessDelegatePattern.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BusinessController {
    @Autowired
    BusinessDelegate delegate;
    @Autowired
    Client client;

    private Client getClient(String serviceType) {
        delegate.setServiceType(serviceType);
        client.setClient(delegate);
        return client;
    }

    @GetMapping("/TCS/{type}")
    public Iterable findAll(@PathVariable String type) {
        return getClient(type).findAll();
    }

    @GetMapping("/TCS/{type}/{id}")
    public Object findById(@PathVariable String type, @PathVariable Long id) {
        Optional emplyoeeContainer = getClient(type).findById(id);
        return emplyoeeContainer.isPresent() ? emplyoeeContainer.get() : null;
    }

    @PostMapping("/TCS/{type}/add")
    public Object add(@PathVariable String type, @RequestBody String o) {
        return getClient(type).add(o);
    }

    @GetMapping("/TCS/{type}/delete/{id}")
    public String delete(@PathVariable String type, @PathVariable Long id) {
        Optional o = getClient(type).findById(id);
        if (o.isPresent()) {
            getClient(type).delete(o.get());
            return "deleted Successfully";
        }
        return "Employee Not Exists, Not able to delete";
    }
}