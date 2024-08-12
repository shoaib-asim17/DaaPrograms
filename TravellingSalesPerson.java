import java.util.*;

public class TravellingSalesPerson {
    int n;
    int adjmat[][];
    int[] verticesSet;

    public TravellingSalesPerson() {
        n = 4;
        adjmat = new int[][]{
            {0, 10, 15, 20},
            {5, 0, 9, 10},
            {6, 13, 0, 12},
            {8, 8, 9, 0}
        };
        verticesSet = new int[n - 1];
        for (int i = 1; i < n; i++) {
            verticesSet[i - 1] = i;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Permutation(0, nums, result);
        return result;
    }

    private void Permutation(int i, int[] nums, List<List<Integer>> result) {
        if (i == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                list.add(n);
            }
            result.add(list); // Fixed the placement of result.add(list)
        } else {
            for (int j = i, l = nums.length; j < l; j++) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                Permutation(i + 1, nums, result);
                // Swapping back to restore the original array
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    int tspdp() {
        int mincost = Integer.MAX_VALUE;
        int minpath[] = new int[n + 1];

        List<List<Integer>> result1 = permute(verticesSet);
        Iterator<List<Integer>> itri = result1.iterator(); // Fixed result1

        while (itri.hasNext()) {
            int cost = 0;
            int path[] = new int[n + 1];
            int ipath = 1;

            List<Integer> o = itri.next(); // Fixed the cast

            Iterator<Integer> itrj = o.iterator();

            path[0] = 0; // Starting from the first vertex (0)
            while (itrj.hasNext()) {
                path[ipath++] = itrj.next();
            }
            path[ipath] = 0; // Returning to the starting point

            for (int i = 0; i < n; i++) {
                cost = cost + adjmat[path[i]][path[i + 1]];
            }

            if (cost < mincost) {
                mincost = cost; // Fixed assignment
                minpath = path.clone(); // Copying the path
            }
        }
        System.out.println("Minimum Cost Tour: " + mincost);

        for (int i = 0; i < n; i++) {
            System.out.print(minpath[i] + "-->");
        }
        System.out.print(minpath[n]);

        System.out.println();

        return mincost; // Returning the minimum cost
    }

    public static void main(String[] args) {
        TravellingSalesPerson t = new TravellingSalesPerson();
        int cost = t.tspdp();
    }
}
