package ra.service;

import ra.modal.Product;

import java.util.ArrayList;

public interface IBaseService<T, E> {
    void save(T t);

    void delete(E id, ArrayList<Product> list);

    T findById(E id);

    int getNewId();

}
