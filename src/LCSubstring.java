import java.util.*;

public class LCSubstring {
    static int dp[][];
    static int maxlen;
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s1= sc.nextLine();
        String s2= sc.nextLine();
        int n=s1.length();
        int m=s2.length();

        char ch1[]=s1.toCharArray();
        char ch2[]=s2.toCharArray();

        dp= new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }

        LCS(ch1,ch2,n,m);
        System.out.println(maxlen);
    }

    static int LCS(char ch1[], char ch2[], int n,int m){
        if(n==0||m==0) return 0;

        if(dp[n][m]!=-1) return dp[n][m];

        LCS(ch1,ch2,n-1,m);
        LCS(ch1,ch2,n,m-1);

        if(ch1[n-1]==ch2[m-1]){
            dp[n][m]= 1+ LCS(ch1,ch2,n-1,m-1);
            maxlen=Math.max(maxlen,dp[n][m]);
        }
        else{
            dp[n][m]=0;
        }

        return dp[n][m];
    }
}
