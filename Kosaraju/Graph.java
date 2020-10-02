import java.util.ArrayList;
import java.util.List;

class Graph {
    private List<Edge> edges;
    private List<Vertex> vertexes;

    public Graph(List<Edge> edges, List<Vertex> vertexes) {
        this.edges = edges;
        this.vertexes = vertexes;
    }

    public Graph() {
        this.edges = new ArrayList<>();
        this.vertexes = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        Vertex u = edge.getStartingVertex();
        Vertex v = edge.getTargetVertex();

        if(!u.getNeighbours().contains(v)) {
            u.addNeighbour(v);
        }

        if (!this.vertexes.contains(u)) {
            this.vertexes.add(u);
        }

        if (!this.vertexes.contains(v)) {
            this.vertexes.add(v);
        }

        this.edges.add(edge);
    }

    public void transpose() {
        List<Edge> reversedEdges = new ArrayList<>();
        for(Edge edge : this.edges) {
            Vertex u = edge.getStartingVertex();
            Vertex v = edge.getTargetVertex();

            u.setVisited(false);
            v.setVisited(false);

            u.getNeighbours().clear();
            v.getNeighbours().clear();

            reversedEdges.add(edge.reversed());
        }

        this.edges.clear();
        for (Edge edge : reversedEdges) {
            this.addEdge(edge);
        }
    }

    @Override
    public String toString() {
        String stringRepresentation = new String();
        stringRepresentation += "Graph [\n";

        for (Edge edge : this.edges) {
            stringRepresentation += "   " + edge + "\n";
        }

        stringRepresentation += "]";

        return stringRepresentation;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public void setVertexes(List<Vertex> vertexes) {
        this.vertexes = vertexes;
    }
}