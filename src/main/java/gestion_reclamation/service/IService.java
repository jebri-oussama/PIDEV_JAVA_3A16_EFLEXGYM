package gestion_reclamation.service;

import java.util.List;

public interface IService<R> {

    void add(R t);
//
    void delete(int id);

    void update(R t);

    List<R> readAll();

    R readById(int id);
}