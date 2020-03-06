package jmsexample.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jmsexample.model.EmailMessage;
import jmsexample.synchronizer.IncidentSynchronizerService;

@Component
public class TopicMessageListener {
	@Autowired
	private IncidentSynchronizerService incidentSynchronizerService;
	
    private Logger logger = LoggerFactory.getLogger(this.getClass());
   
    
/*	@JmsListener(destination = "topic_messages", containerFactory = "jmsListenerContainerFactory")
	public void handleEvent(EmailMessage message) throws Exception {
		logger.info("Message is going to send to " + message.getTo() + " Thread Id: " + Thread.currentThread().getId());
	
		incidentSynchronizerService.processMessage(message);
	}
*/
}
