package com.diana.tema6.facade;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Optional;

public class HttpConnectionHandlerFacade {
	HttpConnectionHandler conn;
	String inputString = "";

	// establish a connection, send a request and receive a response.
	public Optional<String> testConnection() throws IOException {
		HttpURLConnection connection = conn.createConnection();
		return conn.sendBody(connection, "POST", inputString);
	}
}
