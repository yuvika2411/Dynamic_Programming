import java.util.*;
public class MinJumps {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }

        System.out.println(jumps(arr,n));
    }
    static int jumps(int[] arr, int n){
        int jumps=0;
        int end=0;
        int far=0;

        for(int i=0;i<n-1;i++){
            far=Math.max(far,i+arr[i]);
            if(i==end){
                jumps++;
                end=far;
                if(end<=i) return -1;
            }
        }
        return jumps;
    }
}
