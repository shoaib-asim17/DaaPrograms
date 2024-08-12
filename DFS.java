

public class DFS {
    public int vertices;
    public int adjmat[][];
    public int visited[];

    // Constructor to initialize the graph
    public DFS() {
        vertices = 8;  // Initialize the number of vertices
        visited = new int[vertices];  // Initialize visited array
        adjmat = new int[][] {
            {0,1,1,0,0,0,0,0},
            {1,0,0,1,1,0,0,0},
            {1,0,0,0,0,1,1,0},
            {0,1,0,0,0,0,0,1},
            {0,1,0,0,0,0,0,1},
            {0,0,1,0,0,0,0,1},
            {0,0,1,0,0,0,0,1},
            {0,0,0,1,1,1,0,0}
        };
    }

    // DFS function to traverse the graph
    public void dfs(int s) {
        if (visited[s] == 0) {
            System.out.println(s + " ");
            visited[s] = 1;
        }
        
        for (int j = 0; j < vertices; j++) {
            if (adjmat[s][j] == 1 && visited[j] == 0) {
                dfs(j);  // Corrected recursive call
            }
        }
    }

    // Main function to execute the DFS
    public static void main(String args[]) {
        DFS g = new DFS();
        System.out.println("DFS Traversal:");
        g.dfs(0);  // Start DFS traversal from vertex 0
    }
}
