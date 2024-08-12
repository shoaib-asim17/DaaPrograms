public class Knapsack01 {
    public void knapsack(int p[],int w[],int c,int f[][])
    {
        int n=p.length-1;
        int ymax=Math.min(w[n]-1, c);
        for(int y=0;y<=ymax;y++)
        {
            f[n][y]=0;
            
        }
        for(int y=w[n];y<=c;y++)
        {
            f[n][y]=p[n];
        }
        for(int i=n-1;i>1;i--)
        {
            ymax=Math.min(w[i]-1, c);
            for(int y=0;y<=ymax;y++)
            {
                f[i][y]=f[i+1][y];
            }
            for(int y=w[i];y<=c;y++)
            {
                f[i][y]=Math.max(f[i+1][y], f[i+1][y-w[i]+p[i]]);
            }

        }
        f[1][c]=f[2][c];
        if(c>=w[1])
        {
            f[1][c]=Math.max(f[1][c], f[2][c-w[1]+p[1]]);
        }
    }
        public void traceback(int[][] f, int[] w, int c,int[] x)
        {
            int n=w.length-1;
            for(int i=1;i<n;i++)
            {
                if(f[i][c]==f[i+1][c])
                {
                    x[i]=0;
                }
                else{
                    x[i]=1;
                    c-=w[i];
                }
            }
            x[n]=(f[n][c]>0)?1:0;
        }
        public static void main(String[] args)
        {
            Knapsack01 k= new Knapsack01();
            int n=3;
            int c=6;
            int [] p= {0,1,2,5};
            int [] w= {0,2,3,4};
            int [] x= new int [n+1];
            int [][] f= new int[n+1][c+1];

            k.knapsack(p, w, c, f);

            System.out.println("optimal profit: "+f[1][c]);
            k.traceback(f, w, c, x);
            for(int i=1;i<=n;i++)
            {
                System.out.println(x[i]+" ");
            }
            System.out.println(" ");

        }
    
}
