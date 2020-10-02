import java.util.ArrayList;
import java.util.List;

class Vertex {
    private String name;
    private List<Edge> neighbours;


    public Vertex(String name) {
        this.name = name;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Vertex neighbour, double edgeWeight) {
        this.neighbours.add(new Edge(this, neighbour, edgeWeight));

        if(!neighbour.hasNeighbour(this)) {
            neighbour.addNeighbour(this, edgeWeight);
        }
    }

    public boolean hasNeighbour(Vertex neighbour) {
        for(Edge edge : this.neighbours) {
            if(edge.getTargetVertex() == neighbour) {
                return true;
            }
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}