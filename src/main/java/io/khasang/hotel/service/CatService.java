package io.khasang.hotel.service;

import io.khasang.hotel.entity.Cat;

import java.util.List;

public interface CatService {
    /**
     * method for receiving all cats
     * @return
     */
    List<Cat> getAllCats();

    /**
     * @param id = cat id
     * @return Cat by id
     */
    Cat getCatById(long id);

    /**
     * @param cat  - cat that should be added to DB
     * @return cat
     */
    Cat addCat(Cat cat);

    /**
     * @param cat  - cat that should be update to DB
     * @return cat
     */
    Cat updateCat(Cat cat);

    /**
     * @param name - name of cats
     * @return list od cats with specify name = name
     */
    List<Cat> getCatsByName(String name);
    /**
     * @param id - cat id for remove
     * @return deleted cat
     */
    Cat deleteCat(long id);
}
