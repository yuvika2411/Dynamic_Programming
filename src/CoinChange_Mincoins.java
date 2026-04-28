import java.util.*;
public class CoinChange_Mincoins {
        static int t[][];

        public static void main(String[] args){
            Scanner sc= new Scanner(System.in);
            int sum=sc.nextInt();
            int n=sc.nextInt();

            int arr[]= new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }

            t= new int[n+1][sum+1];

            // change here
            for(int i=0;i<n+1;i++){
                t[i][0]=0;   // 0 coins needed for sum 0
            }

            for(int j=1;j<sum+1;j++){
                t[0][j]=Integer.MAX_VALUE-1; // infinity
            }

            // main DP
            for(int i=1;i<n+1;i++){
                for(int j=1;j<sum+1;j++){

                    if(arr[i-1] <= j){
                        t[i][j] = Math.min(
                                1 + t[i][j - arr[i-1]],   // include
                                t[i-1][j]                 // exclude
                        );
                    }
                    else{
                        t[i][j]=t[i-1][j];
                    }
                }
            }

            // if not possible
            if(t[n][sum] == Integer.MAX_VALUE-1)
                System.out.print(-1);
            else
                System.out.print(t[n][sum]);
        }
}
