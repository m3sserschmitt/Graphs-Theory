import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class PrimAlgorithm {
    private List<Vertex> unvisited;
    private List<Edge> mst;
    private PriorityQueue<Edge> heap;

    public PrimAlgorithm(List<Vertex> vertexList) {
        this.unvisited = vertexList;
        this.mst = new ArrayList<>();
        this.heap = new PriorityQueue<>();
    }

    public void computeMST(Vertex vertex) {
        this.unvisited.remove(vertex);

        while(!this.unvisited.isEmpty()) {
            for(Edge edge : vertex.getNeighbours()) {
                if(this.unvisited.contains(edge.getTargetVertex())) {
                    heap.add(edge);
                }
            }

            Edge minEdge = heap.remove();
            vertex = minEdge.getTargetVertex();
            this.unvisited.remove(vertex);

            mst.add(minEdge);
        }
    }

    public List<Edge> getMST() {
        return this.mst;
    }
}