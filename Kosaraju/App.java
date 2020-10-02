class App {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");
        Vertex G = new Vertex("G");
        Vertex H = new Vertex("H");

        Edge e1 = new Edge(A, C);
        Edge e2 = new Edge(C, B);
        Edge e3 = new Edge(B, A);

        Edge e4 = new Edge(C, E);
        Edge e5 = new Edge(E, G);
        Edge e6 = new Edge(G, E);
        Edge e7 = new Edge(G, H);
        Edge e8 = new Edge(H, G);
        Edge e9 = new Edge(H, F);

        Edge e10 = new Edge(F, D);
        Edge e11 = new Edge(D, F);

        Edge e12 = new Edge(B, D);

        Edge e13 = new Edge(C, D);
        
        Edge e14 = new Edge(E, F);

        graph.addEdge(e1);
        graph.addEdge(e2);
        graph.addEdge(e3);
        graph.addEdge(e4);
        graph.addEdge(e5);
        graph.addEdge(e6);
        graph.addEdge(e7);
        graph.addEdge(e8);
        graph.addEdge(e9);
        graph.addEdge(e10);
        graph.addEdge(e11);
        graph.addEdge(e12);
        graph.addEdge(e13);
        graph.addEdge(e14);

        // System.out.println(graph.getVertexes());
        // System.out.println(graph.getVertexes().get(6).getNeighbours());

        // graph.transpose();

        // System.out.println(graph.getVertexes());
        // System.out.println(graph.getVertexes().get(6).getNeighbours());

        KosarajuAlgorithm algorithm = new KosarajuAlgorithm(graph);
        algorithm.computeStronglyConnectedComponents();

        System.out.println(algorithm.getComponents());
    }
}