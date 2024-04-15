package websocket.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // websocket 서버 활성화 
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) { // 클라이언트가 웹 소켓 서버에 연결하는 데 사용할 웹 소켓 엔드 포인트를 등록
		registry.addEndpoint("/ws").withSockJS();
	    // withSockJS()는 웹소켓을 지원하지 않는 브라우저에 폴백 옵션을 활성화 하는데 사용됨. 
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) { // 한 클라이언트에서 다른 클라이언트로 메시지를 라우팅 하는 데 사용될 메시지 브로커를 구성
		registry.setApplicationDestinationPrefixes("/app"); // "/app" 시작되는 메시지가 message-handling methods으로 라우팅 되어야 한다는 것을 명시
		registry.enableSimpleBroker("/topic"); //"/topic" 시작되는 메시지가 메시지 브로커로 라우팅 되도록 정의
	}
}
