package br.com.mobguide.service.impl;

import br.com.mobguide.service.RestService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RestServiceImpl <T> implements RestService<T> {


    @Override
    public List<T> get(final String resource) {

        final RestTemplate restTemplate = new RestTemplate();

        List<T> response = null;


        try {
            final HttpEntity<String> httpEntity = new HttpEntity<>("");

            ResponseEntity<List<T>> responseEntity = restTemplate.exchange(resource,
                    HttpMethod.GET,
                    httpEntity,
                    new ParameterizedTypeReference<List<T>>() {
                    });

            response = responseEntity.getBody();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;

    }
}
