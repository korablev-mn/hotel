package io.khasang.hotel.dao;

import io.khasang.hotel.entity.Cat;
import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {
    /**
     *
     * @return currenthibernate session
     */
    Session getCurrentSession();

    /**
     * method for receiving all entity
     * @return
     */
    List<T> getList();

    /**
     * receiv entity by id
     * @param id - entity id
     * @return specify entity
     */
    T getById(long id);

    /**
     * receiv entity by id
     * @param entity - entity id
     * @return specify entity
     */
    T add(T entity);

    /**
     * receiv entity by id
     * @param entity - entity id
     * @return specify entity
     */
    T update(T entity);
}
