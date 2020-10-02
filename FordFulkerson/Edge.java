class Edge implements Comparable<Edge> {
    private Vertex startingVertex;
    private Vertex targetVertex;
    private final double capacity;
    private double flow;

    public Edge(Vertex startingVertex, Vertex targetVertex, double capacity) {
        this.startingVertex = startingVertex;
        this.targetVertex = targetVertex;
        this.capacity = capacity;
        this.flow = 0;
    }

    public Edge(Vertex targetVertex, double capacity) {
        this.targetVertex = targetVertex;
        this.capacity = capacity;
        this.flow = 0;
    }

    public Vertex getOther(Vertex v) {
        if(this.startingVertex == v) {
            return this.targetVertex;
        } else {
            return this.startingVertex;
        }
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

    public double getFlow() {
        return flow;
    }

    public void setFlow(double flow) {
        this.flow = flow;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getResidualCapacity(Vertex vertex) {
        if(vertex == this.startingVertex) {
            return this.flow;
        } else {
            return this.capacity - this.flow;
        }
    }

    public void addResidualFlow(Vertex vertex, double flow) {
        if(vertex == this.startingVertex) {
            this.flow -= flow;
        } else {
            this.flow += flow;
        }
    }

    @Override
    public String toString() {
        return this.startingVertex + "->" + this.targetVertex + " " + this.flow + "/" + this.capacity; 
    }

    @Override
    public int compareTo(Edge otherEdge) {
        return 0;
    }
}