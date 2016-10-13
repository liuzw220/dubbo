package com.liuzw.service.redis;

public interface IRedisFunction<E, T> {

    public T callBack(E e);

}
