// AI GENERATED DO NOT USE/SUBMIT JUST TO ANALYZE ALGORITHM EXAMPLE


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class exampleDijkstraAlgorithm<T> {

    private HashMap<T, ArrayList<Edge<T>>> adjacencyList;

    public exampleDijkstraAlgorithm() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(T from, T to, int weight) {
        addVertex(from);
        addVertex(to);
        adjacencyList.get(from).add(new Edge<>(to, weight));
    }

    public void dijkstra(T source) {
        HashMap<T, Integer> dist = new HashMap<>();
        HashSet<T> visited = new HashSet<>();

        for (T vertex : adjacencyList.keySet()) {
            dist.put(vertex, Integer.MAX_VALUE);
        }

        dist.put(source, 0);

        while (visited.size() < adjacencyList.size()) {
            T current = getMinVertex(dist, visited);

            if (current == null) {
                break;
            }

            visited.add(current);

            ArrayList<Edge<T>> neighbors = adjacencyList.get(current);

            for (Edge<T> edge : neighbors) {
                T neighbor = edge.destination;
                int weight = edge.weight;

                if (!visited.contains(neighbor) &&
                        dist.get(current) != Integer.MAX_VALUE &&
                        dist.get(current) + weight < dist.get(neighbor)) {

                    dist.put(neighbor, dist.get(current) + weight);
                }
            }
        }

        printDistances(source, dist);
    }

    private T getMinVertex(HashMap<T, Integer> dist, HashSet<T> visited) {
        T minVertex = null;
        int minDistance = Integer.MAX_VALUE;

        for (T vertex : dist.keySet()) {
            if (!visited.contains(vertex) && dist.get(vertex) < minDistance) {
                minDistance = dist.get(vertex);
                minVertex = vertex;
            }
        }

        return minVertex;
    }

    private void printDistances(T source, HashMap<T, Integer> dist) {
        System.out.println("Shortest distances from " + source + ":");
        for (T vertex : dist.keySet()) {
            System.out.println(source + " -> " + vertex + " = " + dist.get(vertex));
        }
    }

    private static class Edge<T> {
        T destination;
        int weight;

        public Edge(T destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        exampleDijkstraAlgorithm<String> graph = new exampleDijkstraAlgorithm<>();

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "B", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("D", "E", 2);
        graph.addEdge("C", "E", 10);

        graph.dijkstra("A");
    }
}
