package ra.controller;

import ra.modal.Product;

import java.util.ArrayList;

public interface IController<T, E> {
    ArrayList<T> getAll();

    void save(T t);

    void delete(E id, ArrayList<Product> list);

    T findById(E id);

    int getNewId();
}
