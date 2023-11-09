package service;

import javax.xml.ws.Endpoint;

public class ServicePublisher {

    private static final String URL = "http://localhost:888/songs";

    public static void main(String[] args) {

        System.out.println("Service is published at: " + URL);
        Endpoint.publish(URL, new Service());
    }

}
