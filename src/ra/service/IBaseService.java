package ra.service;

public interface IBaseService<T, E> {
    void save(T t);

    void delete(E id);

    T findById(E id);

    int getNewId();

}
