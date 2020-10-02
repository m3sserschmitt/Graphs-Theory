import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BellmanFord {
    private List<Vertex> vertecesList;
    private List<Edge> edgesList;

    public BellmanFord(List<Vertex> verteces, List<Edge> edges) {
        this.vertecesList = verteces;
        this.edgesList = edges;
    }

    public void computeDistances(Vertex rootVertex) {
        rootVertex.setDistance(0);

        for(int i = 0; i < this.vertecesList.size() - 1; i ++) {
            for(Edge edge : this.edgesList) {
                Vertex startingVertex = edge.getStartingVertex();
                Vertex targetVertex = edge.getTargetVertex();

                if(startingVertex.getDistance() == Double.MAX_VALUE) {
                    continue;
                }

                double newDistance = startingVertex.getDistance() + edge.getWeight();

                if(newDistance < targetVertex.getDistance()) {
                    targetVertex.setDistance(newDistance);
                    targetVertex.setPredecessor(startingVertex);
                }
            }
        }

        for (Edge edge : this.edgesList) {
            if(edge.getStartingVertex().getDistance() != Double.MAX_VALUE) {
                if(this.hasCycle(edge)) {
                    System.out.println("Negative cycle has been detected!");
                    return;
                }
            }
        }
    }
    
    private boolean hasCycle(Edge edge) {
        return edge.getStartingVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
    }

    public List<Vertex> getShortestRoute(Vertex targetVertex) {
        List<Vertex> shortestRoute = new ArrayList<>();

        for(Vertex v = targetVertex; v != null; v = v.getPredecessor()) {
            shortestRoute.add(v);
        }

        Collections.reverse(shortestRoute);

        return shortestRoute;
    }
}