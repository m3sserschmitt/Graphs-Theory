import java.util.ArrayList;
import java.util.List;

class App {
    public static void main(String[] args) {
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");
        Vertex I = new Vertex("I");

        Edge e1 = new Edge(B, 1);
        Edge e2 = new Edge(E, 7);

        Edge e3 = new Edge(B, 1);
        Edge e4 = new Edge(C, -5);

        Edge e5 = new Edge(F, 4);

        Edge e6 = new Edge(G, 2);

        Edge e7 = new Edge(C, 6);
        Edge e8 = new Edge(I, 1);

        Edge e9 = new Edge(H, 1);

        Edge e10 = new Edge(F, 15);
        Edge e11 = new Edge(H, 25);

        Edge e12 = new Edge(F, 1);

        Edge e13 = new Edge(D, -1);

        A.addNeighbour(e1);
        A.addNeighbour(e2);
        
        B.addNeighbour(e4);

        C.addNeighbour(e5);
        C.addNeighbour(e13);

        D.addNeighbour(e6);
        D.addNeighbour(e3);

        E.addNeighbour(e7);
        E.addNeighbour(e8);

        F.addNeighbour(e9);

        G.addNeighbour(e10);
        G.addNeighbour(e11);
        
        I.addNeighbour(e12);

        List<Vertex> Graph = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        Graph.add(A);
        Graph.add(B);
        Graph.add(C);
        Graph.add(D);
        Graph.add(E);
        Graph.add(F);
        Graph.add(G);
        Graph.add(H);
        Graph.add(I);

        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        edges.add(e4);
        edges.add(e5);
        edges.add(e6);
        edges.add(e7);
        edges.add(e8);
        edges.add(e9);
        edges.add(e10);
        edges.add(e11);
        edges.add(e12);
        edges.add(e13);

        BellmanFord algorithm = new BellmanFord(Graph, edges);
        
        algorithm.computeDistances(Graph.get(0));
        System.out.println(algorithm.getShortestRoute(Graph.get(7)));
    }
}