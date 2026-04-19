import java.util.*;

public class GraphColoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] graph = new int[V][V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int[] color = new int[V];
        Arrays.fill(color, -1);

        color[0] = 0;

        for (int i = 1; i < V; i++) {
            boolean[] used = new boolean[V];

            // check neighbors
            for (int j = 0; j < V; j++) {
                if (graph[i][j] == 1 && color[j] != -1) {
                    used[color[j]] = true;
                }
            }

            // find smallest free color
            int c;
            for (c = 0; c < V; c++) {
                if (!used[c]) break;
            }
            color[i] = c;
        }

        // find number of colors used
        int max = 0;
        for (int i = 0; i < V; i++) {
            max = Math.max(max, color[i]);
        }

        System.out.println(max + 1);
    }
}
