package jmsexample.controller;

import jmsexample.command.TopicMessageProducer;
import jmsexample.model.EmailMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.message.GenericMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageSenderController {
@Autowired
private TopicMessageProducer topicMessageProducer;
@Autowired
private ApplicationContext ac;
@RequestMapping(value = "/test")
	public ResponseEntity<?> messageSend(){
		String message="Message Sended to destination";
		topicMessageProducer.sendMsg();
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}
	@RequestMapping(value = "/")
	public ResponseEntity<?> redirect(){
		String message="Its Working...";
		return new ResponseEntity<>(message,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/receive")
	public ResponseEntity<?> receive(@RequestParam(value="inputparam" , required=false) Boolean inputparam){

		MessageChannel controlChannel = ac.getBean("controlChannel", MessageChannel.class);
		if(inputparam){
			
		controlChannel.send(new GenericMessage<String>("@inboundAdapter.stop()"));
		}
		else{
			controlChannel.send(new GenericMessage<String>("@inboundAdapter.start()"));			
		}

		return new ResponseEntity<>("Received",HttpStatus.CREATED);
	}

}
