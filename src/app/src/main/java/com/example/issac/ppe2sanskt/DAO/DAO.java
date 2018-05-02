package com.example.issac.ppe2sanskt.DAO;

public abstract class DAO<T> {

    public abstract T create(T obj);
    public abstract T update(T obj);
    public abstract void drop(T obj);
}
