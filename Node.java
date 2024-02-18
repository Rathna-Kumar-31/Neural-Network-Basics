public class Node {
    int nextNodes;
    int[] weights;
    int layer;
    int nodeIndex;

    Node(int layer, int node, int nextNodes, Scanner sc) {
        this.nextNodes = nextNodes;
        this.layer = layer - 1;
        this.nodeIndex = node - 1;
        if (nextNodes == 0)
            return;
        this.weights = new int[nextNodes];
        System.out.println("Node #" + node + ": ");
        for (int i = 0; i < nextNodes; i++)
            this.weights[i] = sc.nextInt();
    }

    int getDistance(int node) {
        return this.weights[node];
    }
}