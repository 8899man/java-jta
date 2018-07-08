package com.test.service;

public interface IBaseService<E,S,I> {
    I save(E e,S s);
    boolean update(E e,S s);
}
