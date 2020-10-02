import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FordFulkersonAlgorithm {
    private FlowNetwork flowNetwork;
    private Vertex sourceVertex;
    private Vertex sinkVertex;
    private List<Edge> edges;
    private double maxFlow;

    public FordFulkersonAlgorithm(FlowNetwork flowNetwork) {
        this.flowNetwork = flowNetwork;
        this.sourceVertex = flowNetwork.getSourceVertex();
        this.sinkVertex = flowNetwork.getSinkVertex();
        this.edges = new ArrayList<>();
        this.maxFlow = 0;
    }

    public void computeMaxFlow() {
        while(this.hasAugmentingPath()) {
            double minValue = Double.POSITIVE_INFINITY;

            for(Vertex v = this.sinkVertex; v != this.sourceVertex; v = flowNetwork.getEdgeTo(v).getOther(v)) {
                minValue = Double.min(minValue, flowNetwork.getEdgeTo(v).getResidualCapacity(v));
            }

            this.maxFlow += minValue;

            for(Vertex v = this.sinkVertex; v != this.sourceVertex; v = flowNetwork.getEdgeTo(v).getOther(v)) {
                Edge edge = flowNetwork.getEdgeTo(v);
                edge.addResidualFlow(v, minValue);

                if(!this.edges.contains(edge)) {
                    this.edges.add(edge);
                }
            }
        }
    }
    
    private boolean hasAugmentingPath() {
        flowNetwork.initBFS();

        Queue<Vertex> verticesQueue = new LinkedList<>();
        verticesQueue.add(flowNetwork.getSourceVertex());

        while(!verticesQueue.isEmpty() && !flowNetwork.getSinkVertex().isVisited()) {
            Vertex actualVertex = verticesQueue.remove();

            for(Edge edge : actualVertex.getNeighbours()) {
                Vertex v = edge.getTargetVertex();

                if(!v.isVisited() && edge.getResidualCapacity(v) > 0) {
                    v.setVisited(true);
                    flowNetwork.setEdgeTo(v, edge);
                    verticesQueue.add(v);
                }
            }
        }

        return flowNetwork.getSinkVertex().isVisited();
    }

    public List<Edge> getEdges() {
        return this.edges;
    }

    public double getMaxFlow() {
        return this.maxFlow;
    }
}