public class Edge<T> implements Comparable<Edge> {
    T source;
    T destination;
    int weight;

    public Edge(T destination, T source, int weight) {
        this.destination = destination;
        this.source = source;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}
