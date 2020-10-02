class Edge {
    private Vertex startingVertex;
    private Vertex targetVertex;

    public Edge(Vertex startingVertex, Vertex targetVertex) {
        this.startingVertex = startingVertex;
        this.targetVertex = targetVertex;
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

    public Edge reversed() {
        return new Edge(this.targetVertex, this.startingVertex);
    }

    @Override
    public String toString() {
        return "Edge [start=" + startingVertex + ", target=" + targetVertex + "]";
    }
}