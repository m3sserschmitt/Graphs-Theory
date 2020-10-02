class Edge {
    private Vertex startingVertex;
    private Vertex targetVertex;
    private double weight;

    public Edge(Vertex startingVertex, Vertex targetVertex, double weight) {
        this.startingVertex = startingVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public Edge(Vertex targetVertex, double weight) {
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public Vertex getStartingVertex() {
        return startingVertex;
    }

    public void setStartingVertex(Vertex startingVertex) {
        this.startingVertex = startingVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }    
}