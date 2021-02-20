package com.danielrubiano.Lab1.businessDelegatePattern;

import com.danielrubiano.Lab1.interfaces.BusinessService;
import com.danielrubiano.Lab1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessLookUp {

    @Autowired
    EmployeeService employeeService;

    public BusinessService getBusinessService(String serviceType)
    {
        if(serviceType.equalsIgnoreCase("employee"))
        {
            return employeeService;
        }
        else
        {
            return null;
        }
    }
}
