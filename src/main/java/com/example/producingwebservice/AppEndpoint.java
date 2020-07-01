package com.example.producingwebservice;

import akbars.UserRequest;
import akbars.UserResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AppEndpoint {
    private static final String NAMESPACE_URI = "http://akbars";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserRequest")
    @ResponsePayload
    public UserResponse getMessage(@RequestPayload UserRequest request) {
        UserResponse response = new UserResponse();
        response.setMessage("Чистый доход по клиенту " +
                request.getFirstName() + " " +
                request.getLastName() + " " +
                request.getSecondName() + " составляет " +
                (request.getIncome() - request.getExpenses()) + "р");

        return response;
    }
}