package com.danielrubiano.Lab1.service;

import java.util.Optional;

import com.danielrubiano.Lab1.interfaces.BusinessService;
import com.danielrubiano.Lab1.model.Employee;
import com.danielrubiano.Lab1.repo.IEmployeeRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeService implements BusinessService {
    @Autowired
    IEmployeeRepo repo;

    @Override
    public Object add(String o) {
        Employee e = null;
        try {
            e = repo.save(new ObjectMapper().readValue(o, Employee.class));
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
        System.out.println("Employee saved::" + e);
        return o;
    }

    @Override
    public void delete(Object o) {
        repo.delete((Employee) o);
        System.out.println("Employee deleted::" + o);
    }

    @Override
    public Iterable findAll() {
        return repo.findAll();
    }

    @Override
    public Optional findById(Long id) {
        Optional < Employee > o = repo.findById(id);
        System.out.println("Employee found::" + o);
        return o;
    }
}