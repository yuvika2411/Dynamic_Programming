import java.util.*;
public class EggDropping {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        System.out.print(eggdrop(n,k));
    }
    public static int eggdrop(int n, int k){
        int[] dp= new int[n+1];
        int moves=0;
        while(dp[n]<k){
            moves++;
            for(int i=n;i>0;i--){
                dp[i]=dp[i]+dp[i-1]+1;
            }
        }
        return moves;
    }
}
