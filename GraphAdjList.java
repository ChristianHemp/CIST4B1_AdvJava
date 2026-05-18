import java.util.*;

// weighted graph arrayList<[T, Integer]>
public class GraphAdjList<T> {
    private HashMap<T, ArrayList<T>> adjacencyList;
    int size;

    public GraphAdjList() {
        this.size = 0;
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(T source, T destination) {
        // checks if vertices exist, adds if necessary
        if(!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if(!adjacencyList.containsKey(destination)) {
            addVertex(source);
        }

        if(adjacencyList.get(source) == null) {
            ArrayList<T> tempList = new ArrayList<>();
            tempList.add(destination);

            adjacencyList.put(source, tempList);
            adjacencyList.get(source).add(destination);
        } else {
            adjacencyList.get(source).add(destination);
        }

        // if(adjacencyList.get(source) == null) {
            // undirected
            // ArrayList<T> tempList2 = new ArrayList<>();
            // tempList2.add(source);
            // adjacencyList.put(source, tempList2);

        //    adjacencyList.get(source).add(destination);
        size++;
    }

    public void addVertex(T vertex) {
        if(!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    public void breadthFirstSearch(T startVertex) {
        HashSet<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while(!queue.isEmpty()) {
            T curr = queue.poll();
            ArrayList<T> currAdjList = adjacencyList.get(curr);

            System.out.print(curr + " ");

            for(T adjacentVertex : currAdjList) {
                if(!visited.contains(adjacentVertex)) {
                    queue.add(adjacentVertex);
                    visited.add(curr);
                }
            }
        }
    }

    public void depthFirstSearch(T startVertex) {
        HashSet<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        stack.push(startVertex);

        while(!stack.isEmpty()) {
            T curr = stack.pop();

            if(!visited.contains(curr)) {
                visited.add(curr);
                System.out.print(curr + " ");

                ArrayList<T> currAdjList = adjacencyList.get(curr);

                for(T adjacentVertex : currAdjList) {
                    if(!visited.contains(adjacentVertex)) {
                        stack.push(adjacentVertex);
                    }
                }
            }
        }
    }

    // Create set and stack, add source to stack

    // While stack not empty
    // pop node from stack
    // if node not visited, mark visited, print node
    // all non-visited adjacent, push to stack

    // how to find shortest path in weighted graph 
}
