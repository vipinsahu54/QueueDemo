package jmsexample.synchronizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jmsexample.command.QueueMessageProducer;
import jmsexample.model.EmailMessage;

@Component
public class IncidentSynchronizerService {
	@Autowired
	private QueueMessageProducer queueMessageProducer;
	
	public void processMessage(EmailMessage message) throws Exception {
		
		queueMessageProducer.sendMessage(message);
		
		
	}
}
