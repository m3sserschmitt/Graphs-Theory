import java.util.Stack;

class TopologicalOrder {
    private Stack<Vertex> stack;
    private Graph graph;

    public TopologicalOrder(Graph graph) {
        this.graph = graph;
        this.stack = new Stack<>();
    }

    public void computeOrder() {
        for(Vertex vertex : this.graph.getVertexes()) {
            if(!vertex.isVisited()) {
                this.dfs(vertex);
            }
        }
    }

    public Stack<Vertex> getOrder() {
        return this.stack;
    }

    private void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for(Vertex neighbour : vertex.getNeighbours()) {
            if(!neighbour.isVisited()) {
                dfs(neighbour);
            }
        }

        this.stack.push(vertex);
    }
}