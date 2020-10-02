import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KruskalAlgorithm {
    public void minSpanningTree(List<Vertex> vertexList, List<Edge> edges) {
        DisjointSet disjointSet = new DisjointSet(vertexList);
        List<Edge> mst = new ArrayList<>();

        Collections.sort(edges);

        for(Edge edge : edges) {
            Vertex startingVertex = edge.getStartVertex();
            Vertex targetVertex = edge.getTargetVertex();

            if(disjointSet.find(startingVertex.getNode()) != disjointSet.find(targetVertex.getNode())) {
                mst.add(edge);
                disjointSet.union(startingVertex.getNode(), targetVertex.getNode());
            }
        }

        for(Edge edge : mst) {
            System.out.print(edge.getStartVertex().toString() + edge.getTargetVertex().toString() + ", ");
        }
    }
}