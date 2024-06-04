package com.framallo90.Interface;

public interface RepositoryInterface <T>{
    void add(T object);
    void remove(T object);
    void update(T object);
    T find(int id);
}
