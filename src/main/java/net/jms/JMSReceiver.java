package net.jms;

import net.models.Channel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


@Service("receiver")
public class JMSReceiver {

    private static final Logger LOGGER = Logger.getLogger(JMSReceiver.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public JMSReceiver() {

    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Channel getChannel() {
        LOGGER.info("Start {} ");
        Channel channel = (Channel) jmsTemplate.receiveAndConvert();
        LOGGER.debug("Channel {} " + channel);
        return channel;
    }
}
