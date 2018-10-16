package app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import app.service.SocketService;

@Controller
public class ChatSocketController extends TextWebSocketHandler {

	@Autowired
	Gson gson;
	
	@Autowired
	SocketService service;
	
	List<WebSocketSession> sockets;
	public ChatSocketController() {
		sockets = new ArrayList<>();
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sockets.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		String got = message.getPayload();
		System.out.println("got :" + got);
		Map gmap = gson.fromJson(got, Map.class);
		gmap.put("user", session.getAttributes().get("user"));
		TextMessage tmt = new TextMessage(gson.toJson(gmap));
		for (int i = 0; i < sockets.size(); i++) {
			try {
				
				sockets.get(i).sendMessage(tmt);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<String> current = new ArrayList<>();
		for (int i = 0; i < sockets.size(); i++) {
			WebSocketSession ws = sockets.get(i);
			String userId = (String) ws.getAttributes().get("userId");
			current.add(userId);
		}
		
		String txt = "{\"mode\":\"newtalk\"}";
		service.sendExcludeGroup(txt, current);
	}
	
	
	
	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sockets.remove(session);
	}

	
}
