import java.util.ArrayList;
import java.util.List;

class Vertex {
    private String name;
    private int id;
    private List<Edge> neighbours;
    private boolean visited;

    public Vertex(String name, int id) {
        this.name = name;
        this.id = id;
        this.neighbours = new ArrayList<>();
    }

    public Vertex(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Vertex neighbour, double edgeCapacity) {
        this.neighbours.add(new Edge(this, neighbour, edgeCapacity));
    }

    public void addNeighbour(Edge edge) {
        edge.setStartingVertex(this);
        this.neighbours.add(edge);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Edge> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Edge> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}