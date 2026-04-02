package com.transport.service;

import com.transport.model.Edge;
import com.transport.model.Graph;
import com.transport.model.Node;
import com.transport.model.RouteResponse; // Importăm noul model

import java.util.*;

public class DijkstraWeb {

    // Metoda returnează acum un RouteResponse în loc de void
    public static RouteResponse findFastestPath(Graph graph, String startCity, String endCity) {
        // We verify if the cities are in the our map
        Map<String, Node> nodes = graph.getNodes();
        if(!nodes.containsKey(startCity) || !nodes.containsKey(endCity)){
            // În web, returnăm null sau un obiect gol dacă orașele nu există
            return null;
        }
        Node startNode = nodes.get(startCity);
        Node endNode = nodes.get(endCity);

        // Map to store minimum time from start to each node
        Map<Node, Double> minTimes = new HashMap<>();
        // Map to rebuild the path (we store "the father" of each node)
        Map<Node, Node> parents = new HashMap<>();

        // PriorityQueue ensure us that we always explore the node
        // with the shortest acumulated time -> O(logN)
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(minTimes::get));

        // Init: we set the time to all node to infinite
        for (Node node : nodes.values()) {
            minTimes.put(node, Double.MAX_VALUE);
        }

        // The time to the start node is 0
        minTimes.put(startNode, 0.0);
        pq.add(startNode);

        // Main loop of the program
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            // If we arrive to the destination, we can stop
            if(current.equals(endNode)) break;

            // We analize all the neighbours of the current city
            for(Edge edge : current.getNeighbours()){
                Node neighbour = edge.getDestination();

                // We calculate the new time: the time to the current city +
                // + the time on the current road (edge)
                double timeToNeighbour = minTimes.get(current) + edge.getTime();

                // If we found a shortest path to the neighbour, we update the data
                if(timeToNeighbour < minTimes.get(neighbour)){
                    minTimes.put(neighbour, timeToNeighbour);
                    parents.put(neighbour, current);
                    // We add the neighbour in the pq
                    pq.add(neighbour);
                }
            }
        }

        // În loc de print, apelăm o metodă care pregătește obiectul de răspuns
        return prepareWebResponse(minTimes.get(endNode), parents, endNode);
    }

    private static RouteResponse prepareWebResponse(double totalTime, Map<Node, Node> parents, Node endNode) {
        if (totalTime == Double.MAX_VALUE) {
            return new RouteResponse(Collections.emptyList(), "No path found");
        }

        // We rebuild the road, going back from destination by its parents
        List<String> path = new ArrayList<>();
        for (Node at = endNode; at != null; at = parents.get(at)) {
            path.add(at.getName());
        }
        Collections.reverse(path); // Reverse the list to have Start -> Destination

        // We convert the time (eg: 4.5 hours) in h și min (ex: 4h 30min)
        int hours = (int) totalTime;
        int minutes = (int) Math.round((totalTime - hours) * 60);
        if (minutes == 60) {
            hours++;
            minutes = 0;
        }

        String formattedTime = hours + "h " + minutes + "min";

        // Returnăm obiectul pe care JavaScript îl va primi ca JSON
        return new RouteResponse(path, formattedTime);
    }
}