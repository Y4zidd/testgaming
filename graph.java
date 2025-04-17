public class graph {
    // make bfs and dfs
    private int vertices; // Number of vertices
    private int edges; // Number of edges

    private boolean[][] adjacencyMatrix; // Adjacency matrix representation
    public graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        adjacencyMatrix = new boolean[vertices][vertices];
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            adjacencyMatrix[source][destination] = true;
            adjacencyMatrix[destination][source] = true; // For undirected graph
        }
    }

    // Depth First Search (DFS) algorithm
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(startVertex, visited);
    }

    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[vertex][i] && !visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    // Breadth First Search (BFS) algorithm
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];
        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[vertex][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    // Getters for vertices and edges
    public int getVertices() {
        return vertices;
    }
    public int getEdges() {
        return edges;
    }

    // Main method for testing
    public static void main(String[] args) {
        graph g = new graph(5, 4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        System.out.println("DFS starting from vertex 0:");
        g.dfs(0);

        System.out.println("\nBFS starting from vertex 0:");
        g.bfs(0);
    }
}