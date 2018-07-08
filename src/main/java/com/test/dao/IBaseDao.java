package com.test.dao;

public interface IBaseDao<E,I> {
    I save(E e);
    boolean update(E e);
}
