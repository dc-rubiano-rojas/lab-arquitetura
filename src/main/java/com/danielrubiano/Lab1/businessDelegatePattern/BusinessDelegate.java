package com.danielrubiano.Lab1.businessDelegatePattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BusinessDelegate {
    @Autowired
    private BusinessLookUp lookupService;
    private String serviceType;

    public void setServiceType(String serviceType)
    {
        this.serviceType = serviceType;
    }

    public Object add(String o)
    {
        return lookupService.getBusinessService(serviceType).add(o);
    }

    public void delete(Object o)
    {
        lookupService.getBusinessService(serviceType).delete(o);
    }

    public Iterable findAll() {
        return lookupService.getBusinessService(serviceType).findAll();
    }

    public Optional findById(Long id) {
        return lookupService.getBusinessService(serviceType).findById(id);
    }
}
