import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class KosarajuAlgorithm {
    private Graph graph;
    private List<Vertex> component;
    private List<List<Vertex>> components;

    public KosarajuAlgorithm(Graph graph) {
        this.graph = graph;
        this.component = new ArrayList<>();
        this.components = new ArrayList<>();
    }

    public void computeStronglyConnectedComponents() {
        TopologicalOrder topologicalOrder = new TopologicalOrder(this.graph);
        topologicalOrder.computeOrder();

        Stack<Vertex> order = topologicalOrder.getOrder();
        this.graph.transpose();

        while(!order.isEmpty()) {
            Vertex actualVertex  = order.pop();

            if(actualVertex.isVisited()) {
                continue;
            }

            this.dfs(actualVertex);

            this.components.add(this.component);
            this.component = new ArrayList<Vertex>();
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for(Vertex neighbour: vertex.getNeighbours()) {
            if(!neighbour.isVisited()) {
                dfs(neighbour);
            }
        }

        this.component.add(vertex);
    }

    public List<List<Vertex>> getComponents() {
        for(List<Vertex> component : this.components) {
            Collections.reverse(component);
        }

        return this.components;
    }
}