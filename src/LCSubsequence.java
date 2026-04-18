import java.util.*;

public class LCSubsequence {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s1= sc.nextLine();
        String s2= sc.nextLine();
        int n=s1.length();
        int m=s2.length();

        char ch1[]=s1.toCharArray();
        char ch2[]=s2.toCharArray();

        int ans= LCS(ch1,ch2,n,m);
        System.out.println(ans);
    }

    static int LCS(char ch1[], char ch2[], int n,int m){
        if(n==0|| m==0){
            return 0;
        }
        if(ch1[n-1]==ch2[m-1]){
            return 1+LCS(ch1,ch2,n-1,m-1);
        }
        else{
            return Math.max(LCS(ch1,ch2,n,m-1),LCS(ch1,ch2,n-1,m));
        }
    }
}
