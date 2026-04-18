import java.util.*;

public class Knapsack {
    static int t[][];
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();

        int[] p= new int[n];
        int[] wt= new int[n];

        for(int i=0;i<n;i++){
            p[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }

        t= new int[n+1][c+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(t[i],-1);
        }

        int ans= knapsack(wt,p,n,c);
        System.out.println(ans);
    }

    static int knapsack(int[]wt, int[]p, int n, int c){
        if(n==0 || c==0) return 0;
        if(t[n][c]!=-1) return t[n][c];
        if(wt[n-1]<=c){
            return t[n][c]=Math.max(p[n-1]+knapsack(wt,p,n-1,c-wt[n-1]),knapsack(wt,p,n-1,c));
        }
        else if(wt[n-1]>c){
            return t[n][c]=knapsack(wt,p,n-1,c);
        }

        return 0;
    }
}
