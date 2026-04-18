import java.util.*;
//Palindrome
public class LPS {
    static int dp[][];
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s1= sc.nextLine();

        String s2= new StringBuilder(s1).reverse().toString();

        int n=s1.length();
        int m=s2.length();

        char ch1[]= s1.toCharArray();
        char ch2[]= s2.toCharArray();

        dp= new int[n+1][m+1];

        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans=LCS(ch1,ch2,n,m);
        System.out.println(ans);
    }
    static int LCS(char ch1[],char ch2[], int n, int m){
        if(n==0||m==0) return 0;

        if(ch1[n-1]==ch2[m-1]){
            return dp[n][m]= 1+LCS(ch1,ch2,n-1,m-1);
        }
        else{
            return dp[n][m]= Math.max(LCS(ch1,ch2,n-1,m),LCS(ch1,ch2,n,m-1));
        }
    }
}
