import java.util.HashMap;

public class GraphAdjMatrix<T> {
    private int[][] adjMatrix;
    private HashMap<T, Integer> verticesMap;
    private int indexCounter;

    // constructor
    public GraphAdjMatrix(int numOfVertices) {
        indexCounter = 0;
        verticesMap = new HashMap<>();
        adjMatrix = new int[numOfVertices][numOfVertices];
    }

    // undirected
    public void addEdge(T start, T end) {
        int startIndex = verticesMap.get(start);
        int endIndex = verticesMap.get(end);
        adjMatrix[startIndex][endIndex] = 1;
        adjMatrix[endIndex][startIndex] = 1;
    }

    // adds to hashmap counting which index
    public void addVertex(T vertex) {
        verticesMap.put(vertex, indexCounter);
        indexCounter++;
    }
}
