import java.util.ArrayList;
import java.util.List;

class Vertex {
    private String name;
    private boolean beingVisited;
    private boolean visited;
    private List<Vertex> neighboursList;

    public Vertex(String name) {
        this.name = name;
        this.neighboursList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public List<Vertex> getNeighboursList() {
        return neighboursList;
    }

    public void setNeighbour(Vertex neighbour) {
        this.neighboursList.add(neighbour);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}