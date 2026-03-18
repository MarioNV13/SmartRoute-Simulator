package com.transport.model;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Graph {
    private Map<String, Node> nodes=new HashMap<>();

    public void loadFromResources(String fileName) {
        // We take the folder from resources
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);

        if (is == null) {
            System.out.println("Error: File " + fileName + " not found in resources!");
            return;
        }

        // I use try-with-resources to shut down automaticaly the reader in the end
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // We ignore the empty lines ( if they are )
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String from = parts[0].trim();
                    String to = parts[1].trim();
                    double distance = Double.parseDouble(parts[2].trim());
                    String type = parts[3].trim();

                    this.addRoad(from, to, distance, type);
                }
            }
            System.out.println("Success: Road network loaded using BufferedReader.");
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Distance in file must be a number.");
        }
    }

    public void addRoad(String from, String to, double distance, String roadType){
        //we adjust the speed for the type of the road
        //130 for highways and 90 for mainroads (including other factors which can change the speed)
        double speed=roadType.equalsIgnoreCase("Highway") ? 130.0 : 90;
        double time=distance/speed; // the time to travel the distance between 2 cities

        // if the city doesn't exist, we create it
        nodes.putIfAbsent(from, new Node(from));
        nodes.putIfAbsent(to, new Node(to));

        // we add the road (Edge) from source to destination and vice versa
        nodes.get(from).addEdge(new Edge(nodes.get(to), time, roadType));
        nodes.get(to).addEdge(new Edge(nodes.get(from), time, roadType));
    }
    public Map<String, Node> getNodes() {
        return nodes;
    }
}
