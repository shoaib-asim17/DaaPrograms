
    public class N_Queens {
        int n;
        int x[];

        public N_Queens(int n) {
            this.n = n;
            x = new int[n];
        }
        public void queens(int k, int n) {
            for (int i = 0; i < n; i++) {
                if (place(k, i)) {
                    x[k] = i;
                    if(k == n-1) {
                        display();
                    }
                    else {
                        queens(k+1, n);
                    }
                }
            }
        }

    public boolean place(int k, int i) {
        for (int j = 0; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }

        }
        return true;
    }
    public void display() {
            for (int i = 0; i < n; i++) {
                System.out.print(x[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 4;
        N_Queens q = new N_Queens(n);
        q.queens(0,n);
    }
}

