package net.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by VAfonin on 20.11.2017.
 */
@Service("receiver")
public class JMSReceiver implements MessageListener {

    private JmsTemplate jmsTemplate;

    public JMSReceiver() {

    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            textMessage.acknowledge();
            System.out.println("received the following message: " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
