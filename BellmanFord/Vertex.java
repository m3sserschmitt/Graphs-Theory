import java.util.ArrayList;
import java.util.List;

class Vertex implements Comparable<Vertex> {
    private String name;
    private Vertex predecessor;
    private List<Edge> edges;
    private double distance;

    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    public void addNeighbour(Edge edge) {
        edge.setStartingVertex(this);
        this.edges.add(edge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getDistance());
    }

    @Override
    public String toString() {
        return this.name;
    }
}