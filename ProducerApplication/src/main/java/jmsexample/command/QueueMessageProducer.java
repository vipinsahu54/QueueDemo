package jmsexample.command;

import jmsexample.model.EmailMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueMessageProducer  {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(EmailMessage message) throws Exception {
        for(int i = 0; i <= 100; i++) {
            jmsTemplate.convertAndSend(
                    "queue_messages",
                    message
            );
        }
    }
}
