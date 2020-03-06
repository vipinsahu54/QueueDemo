package jmsexample.synchronizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jmsexample.integration.IncidentIntegrationService;
import jmsexample.model.EmailMessage;

@Component
public class MessageProcessor {
	
	@Autowired	
	private IncidentIntegrationService incidentIntegrationService;
	
	public void processMessage(EmailMessage message) {
		System.out.println("IN PROCESS MESSAGE :"+message.getContent());
		
		String result = incidentIntegrationService.integrateWithExternalSystem(message);
		System.out.println("RESULT :"+result);
	}

}
