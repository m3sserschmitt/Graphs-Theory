import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class DijkstraAlgorithm {
    public void computeDistances(Vertex rootVertex) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();

        rootVertex.setDistance(0);
        queue.add(rootVertex);

        while(!queue.isEmpty()) {
            Vertex actualVertex = queue.poll();

            for(Edge edge: actualVertex.getEdges()) {
                Vertex neighbour = edge.getTargetVertex();
                double newDistance = actualVertex.getDistance() + edge.getWeight();

                if(newDistance < neighbour.getDistance()) {
                    queue.remove(neighbour);
                    neighbour.setDistance(newDistance);
                    neighbour.setPredecessor(actualVertex);
                    queue.add(neighbour);
                }
            }
        }
    }

    public List<Vertex> getRoute(Vertex targetVertex) {
        List<Vertex> route = new ArrayList<>();

        for(Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
            route.add(vertex);
        }

        Collections.reverse(route);

        return route;
    }
}