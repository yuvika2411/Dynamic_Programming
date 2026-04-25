import java.util.*;
public class HamiltonianCycle {
    static int n;
    static int[][] graph;
    static int[] path;

    // Check if vertex v can be placed at position pos
    static boolean isSafe(int v, int pos) {

        // Check if current vertex is connected to previous
        if (graph[path[pos - 1]][v] == 0)
            return false;

        // Check if already visited
        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }

        return true;
    }

    // Backtracking function
    static boolean backtrack(int pos) {

        // Base case: all vertices included
        if (pos == n) {
            // Check last to first connection
            return graph[path[pos - 1]][path[0]] == 1;
        }

        // Try all vertices
        for (int v = 1; v < n; v++) {

            if (isSafe(v, pos)) {

                path[pos] = v; // choose

                if (backtrack(pos + 1)) // explore
                    return true;

                path[pos] = -1; // un-choose (backtrack)
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        graph = new int[n][n];

        // Input adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        path = new int[n];
        Arrays.fill(path, -1);

        path[0] = 0; // start from vertex 0

        if (!backtrack(1)) {
            System.out.println("Solution does not exist");
        } else {
            for (int i = 0; i < n; i++)
                System.out.print(path[i] + " ");

            System.out.println(path[0]); // complete cycle
        }
    }
}
