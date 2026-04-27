import java.util.*;

public class Knapsack {
    static int t[][];
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();

        int val[]= new int[n];
        int wt[]= new int[n];

        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }

        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }

        t= new int[n+1][c+1];
        int ans= knapsack(n,c,val,wt);
        System.out.println(ans);
    }

    static int knapsack(int n,int c,int val[], int wt[]){
        if(n==0||c==0) return 0;
        if(wt[n-1]<=c){
            return t[n][c]=Math.max(val[n-1]+knapsack(n-1,c-wt[n-1],val,wt),knapsack(n-1,c,val,wt));
        }
        else if(wt[n-1]>c){
            return t[n][c]= knapsack(n-1,c,val,wt);
        }
        return t[n][c];
    }
}
