package ra.controller;

import java.util.ArrayList;

public interface IController<T, E> {
    ArrayList<T> getAll();

    void save(T t);

    void delete(E id);

    T findById(E id);

    int getNewId();
}
