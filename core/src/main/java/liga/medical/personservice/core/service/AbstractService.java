package liga.medical.personservice.core.service;

import java.util.List;

public interface AbstractService<T> {

    List<T> findAll();

    T findById(Long id);

    List<T> findByListId(List<Long> listId);

    void insert(T t);

    void insertAll(List<T> tList);

    void updateById(T dto);

    void deleteById(Long id);
}