package com.danielrubiano.Lab1.businessDelegatePattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Client {
    @Autowired
    BusinessDelegate businessService;

    public void setClient(BusinessDelegate businessService) {
        this.businessService = businessService;
    }

    public Object add(String o) {
        return businessService.add(o);
    }

    public void delete(Object o) {
        businessService.delete(o);
    }

    public Iterable findAll() {
        return businessService.findAll();
    }

    public Optional findById(Long id) {
        return businessService.findById(id);
    }
}
