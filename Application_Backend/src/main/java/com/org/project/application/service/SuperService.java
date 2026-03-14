package com.org.project.application.service;

import com.org.project.application.dto.DtoAdmin;

import java.util.List;

public interface SuperService<T> {
    void  save(T dto);

    void update(T dto);

    List<T> getAll();

    String getLastID();

    void  delete(String id);

    T find(String id);

    boolean ifExit(String id);

}
