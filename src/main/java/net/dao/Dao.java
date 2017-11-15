package net.dao;

import net.models.City;

/**
 * Created by VAfonin on 14.11.2017.
 */
public interface Dao {

    void addCity(City city);

    void removeCity(City city);
}
