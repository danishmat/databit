package com.org.customer.dao;

import java.util.Optional;

public interface BaseDao<T> {

    public Optional<T> send(T payload);
}
