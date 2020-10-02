import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {
    private Stack<Vertex> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }

    private void dfs(Vertex v) {
        v.setVisited(true);
        
        for(Vertex neighbour: v.getNeighbourList()) {
            if(!neighbour.isVisited()) {
                neighbour.setVisited(true);
                dfs(neighbour);
            }
        }

        stack.push(v);
        // System.out.println(stack);
    }

    public void order(List<Vertex> vertexesList) {
        for(Vertex v: vertexesList) {
            if(!v.isVisited()) {
                dfs(v);
            }
        }
    }

    public Stack<Vertex> getStack() {
        return this.stack;
    }
}