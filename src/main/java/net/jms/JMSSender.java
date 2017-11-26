package net.jms;

import net.models.Channel;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
/**
 * Created by VAfonin on 20.11.2017.
 */
@Service("sender")
public class JMSSender {

    private JmsTemplate jmsTemplate;

    public JMSSender() {
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Channel channel) {
        getJmsTemplate().send(new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage();
                message.setText("TEst : JBOSS");
                return message;
            }
        });
    }
}
