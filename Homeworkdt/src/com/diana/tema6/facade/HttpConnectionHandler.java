package com.diana.tema6.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class HttpConnectionHandler {

        private URL url;

        public HttpConnectionHandler(URL url) {
            this.url = url;
        }

        public HttpURLConnection createConnection() throws IOException {
            return (HttpURLConnection) this.url.openConnection();
        }

        public Optional<String> sendBody(HttpURLConnection httpURLConnection, String requestMethod, String body) throws IOException {
            if (requestMethod.equals("POST")) {
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(body.getBytes());
                os.flush();
                os.close();
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return Optional.of(response.toString());
            }
            return Optional.empty();
        }
    }

