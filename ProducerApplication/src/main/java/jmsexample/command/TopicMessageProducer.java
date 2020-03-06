package jmsexample.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jmsexample.model.EmailMessage;

@Service
public class TopicMessageProducer{
    @Autowired
    private JmsTemplate jmsTemplate;
    
   /* @Autowired
    private ActiveMQTopic detination;
    */
    
  /*  public JmsTemplate setJmsTemplate(){
    	jmsTemplate.setPubSubDomain(true);
    	jmsTemplate.setDefaultDestination(new ActiveMQQueue("topic_messages"));
		return jmsTemplate;
    	
    }
*/
    public void sendMsg(){

    	for(int i = 0; i <= 10; i++) {
        	jmsTemplate.convertAndSend(
                    "queue_messages",
                    new EmailMessage("ibrahimgunduz34@gmail.com", "deneme")

        			);
        }
    }
}
