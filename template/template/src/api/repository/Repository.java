package api.repository;

import api.model.BaseEntity;

import java.util.List;

public interface Repository<T extends BaseEntity> {
    T save(T entity);

    T findById(int id);

    List<T> findAll();

    void delete(int id);
}
