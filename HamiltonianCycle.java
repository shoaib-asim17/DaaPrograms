public class HamiltonianCycle {
    int n;
    int[][] cost;
    int[] x;

    public HamiltonianCycle() {
        n = 6;
        cost = new int[][]{
            {0, 1, 1, 0, 1, 0},
            {1, 0, 1, 0, 0, 1},
            {1, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {1, 0, 0, 1, 0, 1},
            {0, 1, 0, 0, 1, 0}
        };
        x = new int[n];
        x[0] = 1; // Start at vertex 1 (index 0)
    }

    public void hamiltonian(int k) {
        do {
            nextValue(k);
            if (x[k] == 0) return;
            if (k == n - 1) display();
            else hamiltonian(k + 1);
        } while (true);
    }

    public void nextValue(int k) {
        do {
            x[k] = (x[k] + 1) % (n + 1);
            if (x[k] == 0) return; // Backtrack if no value is possible

            if (cost[x[k - 1] - 1][x[k] - 1] != 0) { // Check if there's an edge
                int j;
                for (j = 0; j < k; j++) {
                    if (x[j] == x[k]) break; // Check for repeated vertex
                }
                if (j == k) { // No repetition found
                    if (k < n - 1 || (k == n - 1 && cost[x[n - 1] - 1][x[0] - 1] != 0)) {
                        return; // Valid next move found
                    }
                }
            }
        } while (true);
    }

    public void display() {
        for (int i = 0; i < n; i++) {
            System.out.print((x[i] - 1) + "\t");
        }
        System.out.print((x[0] - 1) + "\t");
        System.out.println();
    }

    public static void main(String[] args) {
        HamiltonianCycle c = new HamiltonianCycle();
        c.hamiltonian(1);
    }
}
