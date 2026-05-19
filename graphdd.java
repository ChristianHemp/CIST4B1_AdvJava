import java.util.*;

// weighted graph arrayList<[T, Integer]>
public class GraphAdjList<T> {
    // test case asked for
    public static void main(String[] args) {
        GraphAdjList<String> graph = new GraphAdjList<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "A");
        graph.addEdge("A", "A");
        graph.addEdge("B", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("D", "D");

        ArrayList<Edge<String>> edges = graph.getNonSimpleEdges();

        System.out.println(edges);
    }

    private HashMap<T, ArrayList<Edge<T>>> adjacencyList;

    public GraphAdjList() {
        this.adjacencyList = new HashMap<>();
    }

    public static class Edge<T> {
        T source;
        T destination;

        public Edge(T source, T destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    // directed graph for easier calculations later on
    public void addEdge(T source, T destination) {
        Edge<T> newEdge = new Edge<>(source, destination);
        adjacencyList.get(source).add(newEdge);
    }

    public void addVertex(T vertex) {
        if(!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    // Returns ArrayList of all non-simple edges
    public ArrayList<Edge<T>> getNonSimpleEdges() {
        ArrayList<Edge<T>> nonSimpleEdges = new ArrayList<>();
        HashSet<Edge<T>> seenEdges = new HashSet<>();

        for(T vertex : adjacencyList.keySet()) {
            for(Edge<T> edge : adjacencyList.get(vertex)) {
                // Adds edges from a vertex to itself to the non-simple list
                if(vertex.equals(edge.source.equals(edge.destination))) {
                    nonSimpleEdges.add(edge);
                } else if(seenEdges.contains(edge)){
                    nonSimpleEdges.add(edge);
                } else {
                    seenEdges.add(edge);
                }
            }
        }
        return nonSimpleEdges;
    }
}
