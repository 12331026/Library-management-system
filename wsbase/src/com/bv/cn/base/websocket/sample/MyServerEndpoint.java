package com.bv.cn.base.websocket.sample;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ServerEndpoint(value = "/websocket/{user}")
public class MyServerEndpoint {

	private Session session;
	private static final Log logger = LogFactory.getLog(MyServerEndpoint.class);

	@OnOpen
	public void open(Session session, @PathParam(value = "user") String user) {
		this.session = session;
		logger.info("*** WebSocket opened from sessionId " + session.getId());
	}

	@OnMessage
	public void inMessage(String message) {
		logger.info("*** WebSocket Received from sessionId "
				+ this.session.getId() + ": " + message);
	}

	@OnClose
	public void end() {
		logger.info("*** WebSocket closed from sessionId "
				+ this.session.getId());
	}
}
