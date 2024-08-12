
    public class AllPairSP {
        // Constant representing infinity (used to denote the absence of an edge between two vertices)
        static final int INF = Integer.MAX_VALUE;
    
        // Method to find the shortest paths between all pairs of vertices
        public static int[][] All_pairs(int graph[][]) {
            int v = graph.length; // Number of vertices in the graph
            int dist[][] = new int[v][v]; // 2D array to store the shortest distances
    
            // Step 1: Initialize the distance array with the input graph's adjacency matrix
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    dist[i][j] = graph[i][j];
                }
            }
    
            // Step 2: Apply the Floyd-Warshall algorithm to update the distance array
            for (int k = 0; k < v; k++) { // Intermediate vertex
                for (int i = 0; i < v; i++) { // Source vertex
                    for (int j = 0; j < v; j++) { // Destination vertex
                        // If vertex k is on the shortest path from i to j, then update the distance
                        if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j])
                            dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
            return dist; // Return the final distance matrix
        }
    
        // Method to print the solution matrix showing the shortest distances between all pairs of vertices
        public static void printSolution(int dist[][]) {
            int v = dist.length; // Number of vertices in the graph
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    // If no path exists between vertex i and j, print "INF"
                    if (dist[i][j] == INF)
                        System.out.print("INF ");
                    else
                        // Otherwise, print the shortest distance between vertex i and j
                        System.out.print(dist[i][j] + " ");
                }
                System.out.println(); // Move to the next line after printing each row
            }
        }
    
        // Main method to run the program
        public static void main(String args[]) {
            // Example graph represented as an adjacency matrix
            int graph[][] = {
                    {0, 3, INF, 7},
                    {8, 0, 2, INF},
                    {5, INF, 0, 1},
                    {2, INF, INF, 0}
            };
    
            // Call the All_pairs method to find the shortest paths between all pairs of vertices
            int shortestDistance[][] = All_pairs(graph);
    
            // Print the result
            System.out.println("Shortest distance between every pair of vertices:");
            printSolution(shortestDistance);
        }
    }

