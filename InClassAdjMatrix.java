import java.util.ArrayList;
import java.util.HashMap;

public class InClassAdjMatrix<T> {
    private ArrayList<ArrayList<Integer>> matrix;
    private HashMap<T, Integer> vertices;

    public InClassAdjMatrix() {
        matrix = new ArrayList<>();
        vertices = new HashMap<>();
    }

    public void addVertex(T vertex) {
        vertices.put(vertex, vertices.size());

        for(ArrayList<Integer> row : matrix) {
            row.add(0);
        }
        ArrayList<Integer> newRow = new ArrayList<>();
        for(int i = 0; i < vertices.size(); i++) {
            newRow.add(0);
        }
        matrix.add(newRow);
    }

    // undirected
    public void addEdge(T source, T destination, int weight) {
        int sourceIndex = vertices.get(source);
        int destinationIndex = vertices.get(destination);

        if(sourceIndex == -1 || destinationIndex == -1) {
            System.err.println("Source or destination does not exist");
            return;
        }

        matrix.get(sourceIndex).set(destinationIndex, weight);
        matrix.get(destinationIndex).set(sourceIndex, weight);
    }
}
