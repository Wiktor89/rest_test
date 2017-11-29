package net.service;

import net.dao.Dao;
import net.models.Channel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("serviceCity")
@Transactional
public class ServiceCityImp implements ServiceCity {

    private static final Logger LOGGER = Logger.getLogger(ServiceCityImp.class);

    private Dao dao;

    @Autowired
    @Qualifier(value = "dao")
    public void setDao(Dao dao) {
        LOGGER.info("Dao {}" + dao);
        LOGGER.debug("Dao {}" + dao);
        this.dao = dao;
    }

    @Override
    public void addCity(Channel city) {
        LOGGER.info("City {}" + city);
        LOGGER.debug("City {}" + city);
        dao.addCity(city);
    }

    @Override
    public Channel getCity() {
        return dao.getCity();
    }

}
