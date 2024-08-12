public class Greedyknapsack {
    
    void greedyks() {
        int i;
        int n = 7;
        float profit[] = {6, 10, 18, 15, 3, 5, 7};
        float weight[] = {1, 2,  4, 5, 1, 3, 7};
        int m = 15;
        float x[] = {0, 0, 0, 0, 0, 0, 0};
        
        float u = m;
        for(i = 0; i < n; i++) {
            if(weight[i] > u) {
                break;
            }
            x[i] = 1;
            u = u - weight[i];
        }
        if(i<=n) {
            x[i] = u / weight[i];
        }
        float total = 0;
        for(i = 0; i < n; i++) {
            System.out.println("Quantities of object " + (i+1));
        }
        System.out.println("");
                for(i=0; i < n; i++) {
                    System.out.println("Profit of object " + (i+1)+" : " + x[i] + " * " + profit[i] + " = " +(profit[i]*x[i]));
                    total = total + profit[i]*x[i];
                }
                System.out.println("Final profit : " + total);
    } 
    
    public static void main(String[] args) {
       Greedyknapsack ks = new Greedyknapsack();
       ks.greedyks();
    }
}
