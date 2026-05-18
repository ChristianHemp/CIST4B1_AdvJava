import java.util.*;

public class WeightedGraphAdjacencyList<T> {
    private HashMap<T, ArrayList<Edge<T>>> adjacencyList;
    int size;

    public WeightedGraphAdjacencyList() {
        this.size = 0;
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(T start, T destination, int weight) {
        if(!adjacencyList.containsKey(start)) {
            addVertex(start);
        }
        if(!adjacencyList.containsKey(destination)) {
            addVertex(start);
        }
        adjacencyList.get(start).add(new Edge<>(destination, start, weight));
    }

    public void addVertex(T vertex) {
        if(!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    public void dijkstra(T source) {
        HashMap<T, Integer> distanceMap = new HashMap<>();
        HashSet<T> visited = new HashSet<>();

        for(T vertex : adjacencyList.keySet()) {
            distanceMap.put(vertex, 2147483647);
        }

        distanceMap.put(source, 0);

        while(visited.size() < adjacencyList.size()) {
            T curr = getMinVertex(distanceMap, visited);

            if(curr == null) {
                break;
            }

            visited.add(curr);

            ArrayList<Edge<T>> neighbors = adjacencyList.get(curr);

            for(Edge<T> edge : neighbors) {
                T destination = edge.destination;
                int weight = edge.weight;

                if(!visited.contains(destination) && distanceMap.get(curr) + weight < distanceMap.get(destination)) {
                    distanceMap.put(destination, distanceMap.get(curr) + weight);
                }
            }
        }
    }

    private T getMinVertex(HashMap<T, Integer> distanceMap, HashSet<T> visited) {
        T minVertex = null;
        int minValue = 2147483647;

        for(T vertex : distanceMap.keySet()) {
            if(!visited.contains(vertex) && distanceMap.get(vertex) < minValue) {
                minValue = distanceMap.get(vertex);
                minVertex = vertex;
            }
        }

        return minVertex;
    }

    // Kruskal's Algorithm Pseudocode
    //
    // Part 1:
    // Initialization: Start with an empty list that will eventually contain all the edges of the minimum spanning tree
    // Edge contains a source, destination, and weight
    // Sorting Edges: Sort all edges of the graph in non-decreasing order by their weights
    // ** Use adjacency list to search all possible edges
    // Make Set: For each vertex in the graph, make a disjoint set containing only that vertex. -> array of sets
    // This step helps for detecting cycles as the algorithm progresses.
    //
    //
    // Part 2:
    // Iterate Through Edges: Go through the sorted edges and determine if the edge's vertices belong to different sets:
    // - If they are in different sets, adding this edge to A won't form a cycle, so you can add it to the MST
    // - Union the sets of the two vertices to signify that they are now connected through the MST
    // Cycle Detection: The findSet operation provides a way to check if two vertices are in the same set. If they are,
    // adding the edge would create a cycle, which is not allowed in the MST
    // Union: When an edge is added to the MST, the union operation merges the sets of the two vertices,
    // showing that they are now connected

    public ArrayList<Edge<T>> kruskal() {
        // Part 1:
        // Initialization: Start with an empty list that will eventually contain all the edges of the mst
        ArrayList<Edge<T>> mst = new ArrayList<>();
        ArrayList<Edge<T>> edges = new ArrayList<>();
        ArrayList<HashSet<T>> disjointSets = new ArrayList<>();

        // Sorting Edges: Sort all edges of the graph in non-decreasing order by their weights
        for(T vertex : adjacencyList.keySet()) {
            for(Edge<T> edge : adjacencyList.get(vertex)) {
                edges.add(edge);
            }
        }

        Collections.sort(edges);

        // Make Set: For each vertex in the graph, make a disjoint set containing only that vertex. -> array of sets
        for(T vertex : adjacencyList.keySet()) {
            HashSet<T> tempSet = new HashSet<>();
            tempSet.add(vertex);
            disjointSets.add(tempSet);
        }

        // Part 2:
        // Iterate Through Edges: Go through the sorted edges and determine if the edge's vertices belong to different sets:
        // - If they are in different sets, adding this edge to A won't form a cycle, so you can add it to the MST
        // - Union the sets of the two vertices to signify that they are now connected through the MST
        for(Edge<T> edge : edges) {
            // Cycle Detection: The findSet operation provides a way to check if two vertices are in the same set. If they are,
            // adding the edge would create a cycle, which is not allowed in the MST
            HashSet<T> sourceSet = findSet(disjointSets, edge.source);
            HashSet<T> destinationSet = findSet(disjointSets, edge.destination);

            if(sourceSet != destinationSet) {
                // Union: When an edge is added to the MST, the union operation merges the sets of the two vertices,
                // showing that they are now connected
                mst.add(edge);

                sourceSet.addAll(destinationSet);
                disjointSets.remove(destinationSet);
            }
        }
        return mst;
    }

    private HashSet<T> findSet(ArrayList<HashSet<T>> disjointSets, T vertex) {
        for(HashSet<T> set : disjointSets) {
            if(set.contains(vertex)) {
                return set;
            }
        }
        return null;
    }

    public ArrayList<Edge<T>> inClassKruskal() {
        ArrayList<Edge<T>> mst = new ArrayList<>();
        ArrayList<Edge<T>> edges = new ArrayList<>();
        ArrayList<HashSet<T>> disjointSets = new ArrayList<>();

        for(T vertex : adjacencyList.keySet()) {
            for(Edge<T> edge : adjacencyList.get(vertex)) {
                edges.add(edge);
            }
        }

        Collections.sort(edges);

        HashMap<T, T> roots = new HashMap<>();

        for(T vertex : adjacencyList.keySet()) {
            roots.put(vertex, vertex);
        }

        for(Edge<T> e : edges) {
            T sourceRoot = find(roots, e.source);
            T destRoot = find(roots, e.destination);

            if(!sourceRoot.equals(destRoot)) {
                mst.add(e);
                roots.put(destRoot, sourceRoot);
            }
        }

        return mst;
    }

    private T find(HashMap<T, T> parent, T vertex) {
        if(!parent.get(vertex).equals(vertex)) {
            parent.put(vertex, find(parent, parent.get(vertex)));
        }

        return parent.get(vertex);
    }
























    // bad example
    public HashMap<Edge<T>, Integer> dijkstraAlg(Edge<T> startEdge) {
        HashMap<Edge<T>, Integer> distances = new HashMap<>();
        HashSet<Edge<T>> visited = new HashSet<>();

        for(Edge<T> e : distances.keySet()) {
            distances.put(e, Integer.MAX_VALUE);
        }

        distances.put(startEdge, 0);

        PriorityQueue<Edge<T>> pq = new PriorityQueue<>(adjacencyList.size(), Comparator.comparingInt(e -> e.weight));
        pq.add(startEdge);

        while(!pq.isEmpty()) {
            Edge<T> curr = pq.poll();

            if(visited.contains(curr)) {
                continue;
            }

            visited.add(curr);

            ArrayList<Edge<T>> neighbors = adjacencyList.get(curr);

            for(Edge<T> n : neighbors) {
                T destination = n.destination;
                int weight = n.weight;
                int tentDist = distances.get(curr) + weight;

                if(tentDist < distances.get(destination)) {
                    distances.put(n, tentDist);
                    pq.add(n);
                }
            }
        }
        return distances;
    }
}
