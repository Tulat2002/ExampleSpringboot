package com.devanktu.enterpriseapplicationdevelopmentjavaee.service;

import java.util.List;

public interface Ibase<S> {
    List<S> getAll();
    S create(S s);
    S update(S s);
    S update(S s,Long e);
    boolean delete(Long e);
    <K> S find(K id);
    List<S> search(String e);
}
