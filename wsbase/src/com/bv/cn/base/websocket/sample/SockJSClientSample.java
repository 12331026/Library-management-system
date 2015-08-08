package com.bv.cn.base.websocket.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

public class SockJSClientSample {
	public static void main(String[] args) {
	}

	public void test1() {

		List<Transport> transports = new ArrayList<Transport>(2);
		transports.add(new WebSocketTransport(new StandardWebSocketClient()));
		transports.add(new RestTemplateXhrTransport());
		SockJsClient sockJsClient = new SockJsClient(transports);
		sockJsClient.doHandshake(new MyHandler(),
				"ws://example.com:8080/sockjs");
	}

}
