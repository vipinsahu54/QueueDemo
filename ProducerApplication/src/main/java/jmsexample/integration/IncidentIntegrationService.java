package jmsexample.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jmsexample.model.EmailMessage;
@Component
public class IncidentIntegrationService {
	
	@Autowired
	private IncidentIntegrationProcessor incidentIntegrationProcessor;
	public String integrateWithExternalSystem(EmailMessage message) {
		
		System.out.println("message in INTEGRATION:"+ message.getContent());
		incidentIntegrationProcessor.processIntegration(message, true);
		return "SUCCESS";
	}

}
