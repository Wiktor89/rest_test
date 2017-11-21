package net.dao;

import net.models.Query;

/**
 * Created by VAfonin on 14.11.2017.
 */
public interface Dao {

    void addCity(Query city);

    void removeCity(Query city);
}
