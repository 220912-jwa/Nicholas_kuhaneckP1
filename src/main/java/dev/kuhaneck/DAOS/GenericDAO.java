package dev.kuhaneck.DAOS;

import java.util.List;

public interface GenericDAO<T> {

    T getById(int id);

    List<T> getAll();

    T create(T t);

    void update(T tUpdate);

    void delete(int id);


}
