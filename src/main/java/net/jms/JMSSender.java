package net.jms;

import net.models.Channel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service("sender")
public class JMSSender {

    private static final Logger LOGGER = Logger.getLogger(JMSSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(final Channel channel) {
        LOGGER.info("Start {} ");
        LOGGER.debug("Channel {} " + channel);
        jmsTemplate.convertAndSend(channel);
    }
}
