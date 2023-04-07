package com.chat.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// Establecer ruta para comunicar el cliente con el servidor
		registry.addEndpoint("/chat").withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// "app" es un prefijo del destiono donde se va a publicar el mensaje
		// "topic" es un prefijo de evento, donde el servidor envia mensaje a los clientes registrados
		registry.setApplicationDestinationPrefixes("/app").enableSimpleBroker("/topic");
	}
	
}
