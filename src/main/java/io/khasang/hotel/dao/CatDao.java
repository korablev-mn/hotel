package io.khasang.hotel.dao;

import io.khasang.hotel.entity.Cat;

import java.util.List;

public interface CatDao extends BasicDao<Cat> {

    List<Cat> getCatsByName(String name);

}
