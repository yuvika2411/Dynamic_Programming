import java.util.*;
public class Permutations {
    static void generatePermutations(char[] arr, boolean[] used, StringBuilder current, List<String> result) {
        if (current.length() == arr.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.append(arr[i]);

            generatePermutations(arr, used, current, result);

            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char[] arr = input.toCharArray();
        Arrays.sort(arr);

        boolean[] used = new boolean[arr.length];
        List<String> result = new ArrayList<>();

        generatePermutations(arr, used, new StringBuilder(), result);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}


