public class NeuralNetwork {
    int numLayers;
    int[] nodeLength;
    Node[][] nodes;
    int maxNodes;

    NeuralNetwork(int numLayers, Scanner sc) {
        this.numLayers = numLayers;
        this.nodeLength = new int[numLayers];
        int maxNodes = 0;
        for (int i = 0; i < numLayers; i++) {
            System.out.println("Enter the number of nodes in Layer #" + (i + 1) + ": ");
            int numNodes = sc.nextInt();
            this.nodeLength[i] = numNodes;
            maxNodes = Math.max(maxNodes, numNodes);
        }
        this.maxNodes = maxNodes;
        this.nodes = new Node[numLayers][maxNodes];
        for (int i = 0; i < numLayers; i++) {
            for (int j = 0; j < nodeLength[i]; j++) {
                this.nodes[i][j] = new Node(i + 1, j + 1, i < numLayers - 1 ? nodeLength[i + 1] : 0, sc);
            }
        }
    }

    int getShortestDistance(int stLayer, int stNodeIndex, int edLayer, int edNodeIndex) throws Exception {
        Node start = getNode(stLayer, stNodeIndex);
        Node end = getNode(edLayer, edNodeIndex);
        return getShortestDistance(0, start, end);
    }

    Node getNode(int layer, int node) throws Exception {
        if (layer > this.numLayers || layer < 1 || node > this.nodeLength[layer - 1] || node < 1) {
            throw new Exception("Invalid node or layer");
        }
        return this.nodes[layer - 1][node - 1];
    }

    int getShortestDistance(int distance, Node current, Node end) {
        int nextLayer = current.layer + 1;
        if (nextLayer == end.layer) {
            return distance + current.getDistance(end.nodeIndex);
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < this.nodeLength[nextLayer]; i++) {
            Node n = this.nodes[nextLayer][i];
            if (n == null)
                continue;
            int dx = distance + current.getDistance(i);
            int d = getShortestDistance(dx, n, end);
            minDistance = Math.min(minDistance, d);
        }
        return minDistance;
    }
}
