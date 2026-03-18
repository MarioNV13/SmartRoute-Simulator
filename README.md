# Smart Route Simulator - Romania 🇷🇴

A high-performance Java application designed to find the fastest travel routes between Romanian cities using **Dijkstra's Algorithm**. Unlike simple distance calculators, this simulator accounts for different road types and their average speeds to provide realistic travel time estimates.

## 🚀 Features

* **Smart Routing Engine**: Implements Dijkstra's Algorithm with a `PriorityQueue` for $O(E \log V)$ efficiency.
* **Time-Based Optimization**: Calculates the weight of graph edges based on:
    * **Highways**: 130 km/h average speed.
    * **Main Roads**: 90 km/h average speed.
* **Dynamic Data Loading**: Reads city connections and distances from an external `RomaniaMap.txt` resource file.
* **Interactive CLI**: Professional console interface with a search loop for multiple queries. ( Main class )
* **Path Reconstruction**: Displays the full sequence of cities in the optimal route, not just the final time.

## 🛠️ Tech Stack

* **Language**: Java 25
* **Architecture**: Object-Oriented Programming (OOP) - Model, Service, and Main layers.
* **Data Structures**: Adjacency Lists (Graphs), HashMaps, PriorityQueues.
* **Build Tool**: Intellij IDEA 2025.2.4, Maven

## 📂 Project Structure

```text
src/main/java/com/transport/
├── main/
│   └── Main.java             # Entry point & User Interface
├── model/
│   ├── Node.java             # Represents a City
│   ├── Edge.java             # Represents a Road (Destination, Time, Type)
│   └── Graph.java            # Graph structure & Data loader
└── service/
    └── Dijkstra.java         # Core routing logic

Roadmap
[x] Functional CLI Version.

[ ] Spring Boot Integration: Transitioning to a REST API.

[ ] Web Interface: HTML5/JavaScript frontend with interactive maps.

[ ] Real-time Traffic: Adding dynamic weights to edges.
