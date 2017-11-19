package io.khasang.hotel.dao.impl;

import io.khasang.hotel.dao.BasicDao;
import io.khasang.hotel.dao.CatDao;
import io.khasang.hotel.entity.Cat;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository()
public class CatDaoImpl extends BasicDaoImpl<Cat> implements CatDao {

    public CatDaoImpl(Class<Cat> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Cat> getCatsByName(String name) {
        return (List<Cat>) sessionFactory.getCurrentSession().
                createQuery("from Cat as c where c.name = ?").setParameter(0, name).list();
    }
}
