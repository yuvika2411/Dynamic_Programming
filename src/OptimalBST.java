import java.util.*;

public class OptimalBST {
    public static int optimalBST(int[] keys, int[] freq, int n) {

        int[][] dp = new int[n][n];

        // Prefix sum for frequencies (to compute sum quickly)
        int[] prefix = new int[n];
        prefix[0] = freq[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + freq[i];
        }
        // Helper to get sum of freq[i..j]
        // sum(i, j) = prefix[j] - prefix[i-1]
        for (int i = 0; i < n; i++) {
            dp[i][i] = freq[i];
        }

        // length of interval
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                int sum = prefix[j] - (i > 0 ? prefix[i - 1] : 0);

                // Try making each key in range root
                for (int r = i; r <= j; r++) {
                    int left = (r > i) ? dp[i][r - 1] : 0;
                    int right = (r < j) ? dp[r + 1][j] : 0;

                    int cost = left + right + sum;

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

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

        sc.close();
    }
}
