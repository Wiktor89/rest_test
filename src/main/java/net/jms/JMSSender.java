package net.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
/**
 * Created by VAfonin on 20.11.2017.
 */
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

    public void sendMessage() {
        getJmsTemplate().send(new MessageCreator(){
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage();
                message.setText("TEst : JBOSS");
                return message;
            }
        });
    }
}
