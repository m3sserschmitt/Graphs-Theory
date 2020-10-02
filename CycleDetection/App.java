import java.util.ArrayList;
import java.util.List;

class App {
    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");
        Vertex vertex6 = new Vertex("6");

        vertex1.setNeighbour(vertex2);
        vertex2.setNeighbour(vertex3);

        vertex3.setNeighbour(vertex1);

        vertex4.setNeighbour(vertex1);
        vertex4.setNeighbour(vertex5);
        
        vertex5.setNeighbour(vertex6);

        vertex6.setNeighbour(vertex4);

        List<Vertex> graph = new ArrayList<>();
        graph.add(vertex1);
        graph.add(vertex2);
        graph.add(vertex3);
        graph.add(vertex4);
        graph.add(vertex5);
        graph.add(vertex6);

        CycleDetection cycleDetection = new CycleDetection();
        cycleDetection.detectCycle(graph);
    }
}