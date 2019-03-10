package partner.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/broadcasting/{id}")
public class Server {
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	/*
	 * 웹 소켓 연결 시 호출
	 */
	@OnOpen
	public void onOpen(Session session) {
		//System.out.println(session);
		clients.add(session);
	}
	
	/*
	 * 웹 소켓으로부터 메세지가 오면 호출
	 */
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		//System.out.println(message);
		synchronized (clients) {
			for (Session client : clients) {
				if (!client.equals(session)) {
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}
	
	/*
	 * 웹 소켓 닫힐 시 호출 
	 */
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
	}
	
	/*
	 * 웹 소켓 에러 발생시 호출
	 */
	@OnError
	public void onError(Throwable t) {
		t.printStackTrace();
	}
}
