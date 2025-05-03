package com.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SignalingController {

	
	    @MessageMapping("/call")
	    @SendTo("/topic/receive")
	    public String handleCall(String message) {
	        System.out.println("Received signaling data: " + message);
	        return message;
	    }
	
}
