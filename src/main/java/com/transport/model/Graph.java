package com.transport.model;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, Node> nodes=new HashMap<>();

    public void addRoad(String from, String to, double distance, String roadType){
        // if the city doesn't exist, we create it
        nodes.putIfAbsent(from, new Node(from));
        nodes.putIfAbsent(to, new Node(to));

        // we add the road (Edge) de la sursa la destiantie
        nodes.get(from).addEdge(new Edge(nodes.get(to), distance, roadType));
    }
    public Map<String, Node> getNodes() {
        return nodes;
    }
}
