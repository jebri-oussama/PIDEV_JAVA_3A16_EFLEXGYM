package gestion_user.service;

import java.util.List;

public interface IService<C> {

    void add(C c);

    void delete(int id);

    void update(int id, C c);

    List<C> readAll();

    C readById(int id);
}