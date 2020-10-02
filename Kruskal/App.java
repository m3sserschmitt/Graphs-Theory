import java.util.ArrayList;
import java.util.List;

class App {
    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");
        
        vertexList.add(A);
        vertexList.add(B);
        vertexList.add(C);
        vertexList.add(D);
        vertexList.add(E);
        vertexList.add(F);
        vertexList.add(G);
        vertexList.add(H);
        vertexList.add(I);

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(A, B, 1));
        edges.add(new Edge(A, E, 7));
        
        edges.add(new Edge(B, D, 1));
        edges.add(new Edge(B, C, 50));

        edges.add(new Edge(C, F, 4));

        edges.add(new Edge(D, G, 2));

        edges.add(new Edge(E, C, 6));
        edges.add(new Edge(E, I, 1));

        edges.add(new Edge(F, H, 1));

        edges.add(new Edge(G, F, 15));
        edges.add(new Edge(G, H, 25));
        
        edges.add(new Edge(I, F, 1));

        KruskalAlgorithm algorithm = new KruskalAlgorithm();
        algorithm.minSpanningTree(vertexList, edges);
    }
}