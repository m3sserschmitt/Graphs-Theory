import java.util.ArrayList;
import java.util.List;

class FlowNetwork {
    private List<Vertex> vertices;
    private Vertex sourceVertex;
    private Vertex sinkVertex;
    private int numberOfVertices;
    private Edge[] edgeTo;

    public FlowNetwork(List<Vertex> vertices, Vertex sourceVertex, Vertex sinkVertex) {
        this.vertices = new ArrayList<>();
        this.sourceVertex = sourceVertex;
        this.sinkVertex = sinkVertex;
        this.numberOfVertices = vertices.size();
        this.edgeTo = new Edge[this.numberOfVertices];

        for(Vertex vertex : vertices) {
            vertex.setId(this.vertices.size());
            this.vertices.add(vertex);
        }
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
        this.numberOfVertices = vertices.size();
    }

    public int getNumberOfVertices() {
        return this.numberOfVertices;
    }

    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(Vertex sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public Vertex getSinkVertex() {
        return sinkVertex;
    }

    public void setSinkVertex(Vertex sinkVertex) {
        this.sinkVertex = sinkVertex;
    }

    public void initBFS() {
        for(Vertex vertex : this.vertices) {
            vertex.setVisited(false);
        }

        this.edgeTo = new Edge[this.numberOfVertices];
    }

    public void setEdgeTo(Vertex vertex, Edge edge) {
        this.edgeTo[vertex.getId()] = edge;
    }

    public Edge getEdgeTo(Vertex vertex) {
        return this.edgeTo[vertex.getId()];
    }
}