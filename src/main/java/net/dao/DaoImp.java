package net.dao;

import net.models.Channel;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
    public void addCity(Channel city) {
        LOGGER.info("City" + city);
        LOGGER.debug("City" + city);
        Session ses = sessionFactory.getCurrentSession();
        ses.saveOrUpdate(city);
    }

    @Override
    public Channel getCity() {
        LOGGER.info("Start getCity {}");
        Session ses = sessionFactory.getCurrentSession();
        Criteria c = ses.createCriteria(Channel.class);
        c.setProjection(Projections.max("id"));
        Integer id = (Integer) c.uniqueResult();
        Channel o = (Channel) ses.get(Channel.class, id);
        LOGGER.debug("Channel {} " + o);
        return o;
    }
}
