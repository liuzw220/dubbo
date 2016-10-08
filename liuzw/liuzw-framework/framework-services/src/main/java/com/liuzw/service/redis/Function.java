package com.liuzw.service.redis;

public interface Function<E, T> {

    public T callBack(E e);

}
