import java.util.ArrayList;
import java.util.List;

class DisjointSet {
    // private int nodeCount = 0;
    // private int setCount = 0;
    private List<Node> rootNodes; // representatives;

    public DisjointSet(List<Vertex> vertexList) {
        this.rootNodes = new ArrayList<>(vertexList.size());
        this.makeSets(vertexList);
    }

    public int find(Node node) {
        Node currentNode = node;

        while(currentNode.getParent() != null) {
            currentNode = currentNode.getParent();
        }

        Node rootNode = currentNode;
        currentNode = node;

        while(currentNode != rootNode) {
            Node tempNode = currentNode.getParent();
            currentNode.setParent(rootNode);
            currentNode = tempNode;
        }

        return rootNode.getId();
    }

    public void union(Node node1, Node node2) {
        int index1 = find(node1);
        int index2 = find(node2);

        if(index1 == index2) {
            return;
        }

        Node root1 = this.rootNodes.get(index1);
        Node root2 = this.rootNodes.get(index2);

        if(root1.getRank() < root2.getRank()) {
            root1.setParent(root2);
        } else if(root1.getRank() > root2.getRank()) {
            root2.setParent(root1);
        } else {
            root2.setParent(root1);
            root1.setRank(root1.getRank() + 1);
        }

        // this.setCount --;
    }

    private void makeSets(List<Vertex> vertexList) {
        for(Vertex vertex : vertexList) {
            this.makeSet(vertex);
        }
    }

    private void makeSet(Vertex vertex) {
        Node n = new Node(0, this.rootNodes.size(), null);
        vertex.setNode(n);
        this.rootNodes.add(n);
        // this.setCount ++;
        // this.nodeCount ++;
    }
}