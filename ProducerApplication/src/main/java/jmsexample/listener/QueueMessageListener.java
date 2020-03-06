package jmsexample.listener;

import jmsexample.model.EmailMessage;
import jmsexample.synchronizer.MessageProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueMessageListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
     
    
    @Autowired
    private MessageProcessor messageProcessor;    
    public void handleEvent(EmailMessage message) {
        logger.info("Message is going to send to " + message.getTo() + " Thread Id: " + Thread.currentThread().getId());
        messageProcessor.processMessage(message);
    }
}
