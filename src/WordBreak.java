import java.util.*;

public class WordBreak {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String[] d= sc.nextLine().split(" ");
        String s= sc.nextLine();

        System.out.println(wordbreak(s, d) ? 1 : 0);
    }
    static boolean wordbreak(String s, String[] d){
        boolean dp[]= new boolean[s.length()+1];

        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(String word:d){
                int len=word.length();
                if(i>=len && dp[i-len]){
                    if(s.substring(i-len,i).equals(word)){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}

