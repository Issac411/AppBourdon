package DAO;

public abstract class DAO<T> {

    public abstract T create(T obj);
    public abstract T update(T obj);
    public abstract void drop(T obj);
}
