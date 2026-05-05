import java.util.*;

public class TravellingSalesman {
    static int n;
    static int graph[][];
    static boolean visited[];
    static ArrayList<Integer> path= new ArrayList<>();
    static ArrayList<Integer> bestpath= new ArrayList<>();
    static int mincost=Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        visited = new boolean[n];
        graph = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=sc.nextInt();
            }
        }

        visited[0]=true;
        path.add(0);
        tsp(0,1,0);
        System.out.println(mincost);
        for(int i:bestpath){
            System.out.print(i+" ");
        }
    }

    static void tsp(int city,int count, int cost){
        if(count==n && graph[city][0]>0){
            int total= cost+graph[city][0];
            if(total<mincost){
                mincost=total;
                bestpath= new ArrayList<>(path);
                bestpath.add(0);
            }
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i] && graph[city][i]>0){
                visited[i]= true;
                path.add(i);
                tsp(i,count+1,cost+graph[city][i]);
                visited[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
