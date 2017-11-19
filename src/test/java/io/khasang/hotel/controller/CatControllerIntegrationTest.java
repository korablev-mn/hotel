package io.khasang.hotel.controller;

import io.khasang.hotel.entity.Cat;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;

public class CatControllerIntegrationTest {

    private final String ROOT = "http://localhost:8080/";
    private final String ADD = "/add";
    private final String GET_BY_ID = "/get";

    @Test
    public void addCat() {
        Cat cat = createCat();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );

        Assert.assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat.getDescription());
    }

    private Cat createCat() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCall("Barsik");

        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Cat createCat = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Cat.class
                ).getBody();
        assertNotNull(createCat);
        Assert.assertEquals(cat.getName(), createCat.getName());
                return createCat;
    }

    private Cat prefillCall(String name) {
        Cat barsik = new Cat();
        barsik.setName(name);
        barsik.setDescription("Bad cat");
        return barsik;
    }
}
