import java.util.*;
public class MaxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        // Step 1: Initialize variables
        int buy1 = Integer.MAX_VALUE;   // minimum price for first buy
        int sell1 = 0;                 // max profit after first sell

        int buy2 = Integer.MAX_VALUE;  // effective cost for second buy
        int sell2 = 0;                 // max profit after second sell

        // Step 2: Traverse prices
        for (int price : prices) {

            // minimum price for first buy
            buy1 = Math.min(buy1, price);

            // max profit after first sell
            sell1 = Math.max(sell1, price - buy1);

            // effective cost for second buy
            // (we use profit from first sell to reduce cost)
            buy2 = Math.min(buy2, price - sell1);

            // max profit after second sell
            sell2 = Math.max(sell2, price - buy2);
        }

        // final answer
        return sell2;
    }
}
