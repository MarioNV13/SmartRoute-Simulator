package com.transport.controller;

import com.transport.model.Graph;
import com.transport.model.RouteResponse;
import com.transport.service.DijkstraWeb;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;

@RestController // Spring will know that we will return JSON data, not whole pages
@RequestMapping("/api") // All requests will begin with http://localhost:8080/api/...
public class RouteController {

    private Graph romaniaMap;
    private Object destCity;

    @PostConstruct // It will execute once, after the server will be powered on
    public void init() {
        romaniaMap = new Graph();
        // It loads the map into memory so it will be ready for use
        romaniaMap.loadFromResources("RomaniaMap.txt");
    }

    @GetMapping("/route") // It analyses GET requests (eg: /api/route?start=Iasi&dest=Arad)
    public RouteResponse getRoute(@RequestParam("start") String startCity,
                                  @RequestParam("dest") String destCity) {

        return DijkstraWeb.findFastestPath(romaniaMap, startCity, destCity);
    }
}