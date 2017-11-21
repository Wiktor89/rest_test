package net.dao;

import net.models.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by VAfonin on 14.11.2017.
 */
@Repository("dao")
public class DaoImp implements Dao {

    private static final Logger LOGGER = Logger.getLogger(DaoImp.class);

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier(value = "hibernate")
    public void setSessionFactory(SessionFactory sessionFactory) {
        LOGGER.info("City" + sessionFactory);
        LOGGER.debug("City" + sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCity(Query city) {
        LOGGER.info("City" + city);
        LOGGER.debug("City" + city);
        Session ses = sessionFactory.getCurrentSession();
        ses.saveOrUpdate(city);
    }

    @Override
    public void removeCity(Query city) {
        LOGGER.info("Remove city " + city);
        LOGGER.debug("Remove city " + city);
    }
}
