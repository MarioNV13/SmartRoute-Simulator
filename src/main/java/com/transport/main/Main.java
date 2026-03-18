package com.transport.main;

import com.transport.model.Graph;
import com.transport.service.Dijkstra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. We initialize the graph
        Graph romaniaMap = new Graph();

        // 2. We introduce data from resources folder (RomaniaMap.txt)
        romaniaMap.loadFromResources("RomaniaMap.txt");
        boolean continueSearching = true; //control variable for loop

        System.out.println("========================================");
        System.out.println("   WELCOME TO SMART ROUTE SIMULATOR");
        System.out.println("========================================");

        Scanner scanner = new Scanner(System.in);

        while (continueSearching) {
            System.out.print("Enter Start City (e.g. Bucuresti): ");
            String start = scanner.nextLine().trim();

            System.out.print("Enter Destination City (e.g. Timisoara): ");
            String destination = scanner.nextLine().trim();

            // 4. We execute Dijkstra algorithm
            Dijkstra.findFastestPath(romaniaMap, start, destination);

            // We ask the user if he want to find another route
            System.out.print("\nDo you want to find another route? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("no") || response.equals("nu")) {
                continueSearching = false;
            }
        }

            System.out.println("Thank you for using our simulator!");
            scanner.close();

    }
}