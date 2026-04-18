import java.util.*;

public class RodCutting {
    static int t[][];
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int price[]= new int[n];
        for(int i=0;i<n;i++){
            price[i]=sc.nextInt();
        }

        int length[]= new int[n];
        for(int i=0;i<n;i++){
            length[i]=i+1;
        }

        t= new int[n+1][length.length+1];

        for(int i=0;i<n+1;i++){
            t[i][0]=0;
        }
        for(int j=1;j<n+1;j++){
            t[0][j]=0;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(length[i-1]<=j){
                    t[i][j]= Math.max(price[i-1]+t[i][j-length[i-1]],t[i-1][j]);
                }
                else{
                    t[i][j]= t[i-1][j];
                }
            }
        }

        System.out.println(t[n][n]);
    }
}
