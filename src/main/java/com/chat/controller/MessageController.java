package com.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.chat.entidad.Mensaje;

@Controller
public class MessageController {
	
	@Autowired
	private SimpMessagingTemplate messaging;

	@MessageMapping("/chat/{to}")
	public void sendMessage(@DestinationVariable String to, Mensaje m) {
		messaging.convertAndSend("/topic/messages/"+to, m);
	}
	
}
