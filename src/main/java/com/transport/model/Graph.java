package com.transport.model;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, Node> nodes=new HashMap<>();

    public void addRoad(String from, String to, double distance, String roadType){
        // if the city doesn't exist, we create it
        nodes.putIfAbsent(from, new Node(from));
        nodes.putIfAbsent(to, new Node(to));

        // we add the road (Edge) from source to destination and vice versa
        nodes.get(from).addEdge(new Edge(nodes.get(to), distance, roadType));
        nodes.get(to).addEdge(new Edge(nodes.get(from), distance, roadType));
    }
    public Map<String, Node> getNodes() {
        return nodes;
    }
}
