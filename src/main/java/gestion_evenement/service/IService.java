package gestion_evenement.service;

import java.util.List;

public interface IService<E> {

    void add(E t);

    void delete(int id);

    void update(E t);

    List<E> readAll();

    E readById(int id);
}