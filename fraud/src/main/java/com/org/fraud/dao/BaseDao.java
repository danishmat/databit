package com.org.fraud.dao;

import java.util.Optional;

public interface BaseDao<T> {

    public Optional<T> send(T payload);
}
