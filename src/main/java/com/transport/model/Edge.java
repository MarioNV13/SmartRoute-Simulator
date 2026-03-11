package com.transport.model;

public class Edge {
    private Node destination;
    private double distance;
    private String roadType;

    public Edge(Node destination, double distance,  String roadType) {
        this.destination = destination;
        this.distance = distance;
        this.roadType = roadType;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }
}
