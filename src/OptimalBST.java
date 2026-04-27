import java.util.*;

public class OptimalBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] keys = new int[n];
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            keys[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            freq[i] = sc.nextInt();
        }

        int result = optimalBST(keys, freq, n);
        System.out.println(result);
    }
    static int optimalBST(int keys[], int freq[], int n){
        int[][] dp = new int[n][n];

        for(int len=1;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=freq[k];
                }
                dp[i][j]=Integer.MAX_VALUE;
                for(int r=i;r<=j;r++){
                    int left=(r>i)?dp[i][r-1]:0;
                    int right= (r<j)?dp[r+1][j]:0;
                    dp[i][j]=Math.min(dp[i][j],left+right+sum);
                }
            }
        }
        return dp[0][n-1];
    }
}
