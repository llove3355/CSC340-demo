/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.API.practice;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author llove
 */
@RestController
public class APIController {
    @GetMapping("/joke")
    public Object getJoke(){
        String url = "https://v2.jokeapi.dev/joke/Any?safe-mode";
        RestTemplate restTemplate = new RestTemplate();
        Object jSonJoke = restTemplate.getForObject(url, Object.class);
        String jokeOb = restTemplate.getForObject(url, String.class);
        
        JSONObject jo = new JSONObject(jokeOb);
        System.out.println(jo.toString());
        String setup = jo.getString("setup");
        System.out.println(setup);
        String delivery = jo.getString("delivery");
        System.out.println(delivery);
        return jSonJoke;
    }
}