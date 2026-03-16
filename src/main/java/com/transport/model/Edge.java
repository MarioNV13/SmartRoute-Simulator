package com.transport.model;

public class Edge {
    private Node destination;
    private double time;
    private String roadType;

    public Edge(Node destination, double time,  String roadType) {
        this.destination = destination;
        this.time = time;
        this.roadType = roadType;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double Time) {
        this.time = time;
    }

    public String getRoadType() {
        return roadType;
    }

    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }
}
