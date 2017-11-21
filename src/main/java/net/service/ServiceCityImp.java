package net.service;

import net.dao.Dao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by VAfonin on 14.11.2017.
 */
@Service("serviceCity")
@Transactional
public class ServiceCityImp implements ServiceCity {

    private static final Logger LOGGER = Logger.getLogger(ServiceCityImp.class);

    private Dao dao;

    @Autowired
    @Qualifier(value = "dao")
    public void setDao(Dao dao) {
        LOGGER.info("Dao " + dao);
        LOGGER.debug("Dao " + dao);
        this.dao = dao;
    }

    @Override
    public void addCity(City city) {
        LOGGER.info("City " + city);
        LOGGER.debug("City " + city);
        dao.addCity(city);
    }

    @Override
    public void removeCity(City city) {
        LOGGER.info("City" + city);
        LOGGER.debug("City" + city);
        dao.removeCity(city);
    }
}
