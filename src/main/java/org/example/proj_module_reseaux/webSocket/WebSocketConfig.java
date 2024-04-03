package org.example.proj_module_reseaux.webSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); //this is where the client will subscribe
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) { //this is where the client will stomp
        registry.addEndpoint("/payroll").setAllowedOriginPatterns("*").withSockJS();

        registry.addEndpoint("/clientLocation");
        registry.addEndpoint("/clientLocation").withSockJS();
        registry.addEndpoint("/driverLocation");
        registry.addEndpoint("/driverLocation").withSockJS();

    }
}