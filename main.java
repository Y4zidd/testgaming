public class main {
    //dfs anda bsf
    public static void main(String[] args) {
        // Create a graph with 5 vertices
        Graph graph = new Graph(5);

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        // Perform DFS starting from vertex 0
        System.out.println("Depth First Search (DFS) starting from vertex 0:");
        graph.dfs(0);

        // Perform BFS starting from vertex 0
        System.out.println("\nBreadth First Search (BFS) starting from vertex 0:");
        graph.bfs(0);
    }
}
