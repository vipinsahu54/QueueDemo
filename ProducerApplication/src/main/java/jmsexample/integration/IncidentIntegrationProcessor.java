package jmsexample.integration;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import jmsexample.model.EmailMessage;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;

@Component
public class IncidentIntegrationProcessor {
	   private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final AtomicInteger counter = new AtomicInteger(0);
	
	@Retryable(value = {RuntimeException.class}, maxAttempts = 5, backoff = @Backoff(value = 5))
	public String processIntegration(EmailMessage message , boolean failureMessage) {
		  final int callCount = counter.incrementAndGet();
		  logger.info("Call count: {}", callCount);

	        if (failureMessage) {
	        	throw new RuntimeException("I will eventually work.");
	            
	        }
             System.out.println("Call count: %s"+ callCount);
	        return String.format("Call count: %s", callCount);
		
	}

}
