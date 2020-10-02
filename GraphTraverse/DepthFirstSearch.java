import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    public void traverse(List<Vertex> vertexes) {
        for(Vertex v: vertexes) {
            if(!v.isVisited()) {
                this.dfsWithStack(v);
            }
        }
    }

    public void recursiveTraverse(List<Vertex> vertexes) {
        for(Vertex v: vertexes) {
            if(!v.isVisited()) {
                recursiveDFS(v);
            }
        }
    }

    private void recursiveDFS(Vertex v) {
        v.setVisited(true);
        System.out.println("Current Vertex: " + v);

        for(Vertex neighbour: v.getNeighbourList()) {
            if(!neighbour.isVisited()) {
                recursiveDFS(neighbour);
            }
        }
    }

    private void dfsWithStack(Vertex rootVertex) {
        Stack<Vertex> stack = new Stack<>();

        rootVertex.setVisited(true);
        stack.add(rootVertex);

        while(!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();
            System.out.println("Actual Vertex: " + actualVertex);
        
            for(Vertex v: actualVertex.getNeighbourList()) {
                if(!v.isVisited()) {
                    v.setVisited(true);
                    stack.add(v);
                }
            }
        }
    }
}