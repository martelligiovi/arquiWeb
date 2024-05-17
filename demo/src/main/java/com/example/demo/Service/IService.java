package com.example.demo.Service;


import com.example.demo.model.User;

import java.util.List;

public interface IService<T> {

    public T save(T t);
    public List<T> get();
    public void delete(Long id);
    public T find(Long id);
    public T update(T t);
}
