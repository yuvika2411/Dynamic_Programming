import java.util.*;

public class SubsetSum {
    static ArrayList<String> result = new ArrayList<>();

    public static void solve(int[] arr, int i, int sum, int target, String ans){

        if(sum == target){
            result.add(ans.trim()); // store
            return;
        }

        if(i == arr.length || sum > target) return;

        // include
        solve(arr, i+1, sum + arr[i], target, ans + arr[i] + " ");

        // exclude
        solve(arr, i+1, sum, target, ans);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        solve(arr, 0, 0, target, "");

        if(result.size() == 0){
            System.out.println("-1");
        } else {
            // reverse print (VERY IMPORTANT)
            for(int i = result.size() - 1; i >= 0; i--){
                System.out.println(result.get(i)+" ");
            }
        }
    }
}
