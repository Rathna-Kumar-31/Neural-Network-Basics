import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of layers: ");
        int numLayers = sc.nextInt();
        NeuralNetwork nn = new NeuralNetwork(numLayers, sc);
        while (true) {
            System.out.println("Distance Query:\nEnter the starting layer, node and finishing layer, node: \nEnter -1 to exit:");
            int stLayer = sc.nextInt();
            if (stLayer == -1)
                break;
            int stNodeIndex = sc.nextInt();
            int edLayer = sc.nextInt();
            int edNodeIndex = sc.nextInt();
            int distance = nn.getShortestDistance(stLayer, stNodeIndex, edLayer, edNodeIndex);
            System.out.println("Distance between given nodes: " + distance);
        }
    }
}