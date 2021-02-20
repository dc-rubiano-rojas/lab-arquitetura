package com.danielrubiano.Lab1.interfaces;

import java.util.Optional;

public interface BusinessService {
    public Object add(String o);
    public void delete(Object o);
    public Iterable findAll();
    public Optional findById(Long id);
}
