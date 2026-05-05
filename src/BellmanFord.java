import java.util.*;

public class BellmanFord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(), E = sc.nextInt();
        int[][] edge = new int[E][3];

        for(int i=0;i<E;i++)
            edge[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};

        int src = sc.nextInt();

        int[] d = new int[V];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[src] = 0;

        // relax edges
        for(int i=0;i<V-1;i++)
            for(int[] e : edge)
                if(d[e[0]] != Integer.MAX_VALUE && d[e[0]] + e[2] < d[e[1]])
                    d[e[1]] = d[e[0]] + e[2];

        // negative cycle check
        for(int[] e : edge)
            if(d[e[0]] != Integer.MAX_VALUE && d[e[0]] + e[2] < d[e[1]]){
                System.out.println(-1);
                return;
            }

        // output
        for(int i=0;i<V;i++)
            System.out.println(i + " " + (d[i]==Integer.MAX_VALUE ? "INF" : d[i]));
    }
}
