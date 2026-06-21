package com.marcsbank.account_service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Component
public class UserClient {

    @Value("${user.service.url}")
    private String userServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean userExists(String token) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", token);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> response = restTemplate.exchange(
                    userServiceUrl + "/api/users/profile",
                    HttpMethod.GET,
                    entity,
                    Map.class
            );

            return response.getStatusCode().is2xxSuccessful();
        } catch (HttpClientErrorException.Unauthorized e) {
            return false;
        } catch (RestClientException e) {
            return false;
        }
    }
}