import java.util.List;

class CycleDetection {
    public void detectCycle(List<Vertex> graph) {
        for(Vertex vertex : graph) {
            if(!vertex.isVisited()) {
                dfs(vertex);
            }
        }
    }

    public void dfs(Vertex vertex) {
        vertex.setBeingVisited(true);

        for(Vertex neighbour : vertex.getNeighboursList()) {
            if(neighbour.isBeingVisited()) {
                System.out.println("Cycle detected!");
                return;
            }

            if(!neighbour.isVisited()) {
                neighbour.setVisited(true);
                dfs(neighbour);
            }
        }

        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }
}