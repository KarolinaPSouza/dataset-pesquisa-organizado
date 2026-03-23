import java.io.*;
import java.util.*;

public class entry_10085704 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for(int i = 0; i < n - 1; i++){
            StringTokenizer edge = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(edge.nextToken()) - 1;
            int b = Integer.parseInt(edge.nextToken()) - 1;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        maxDist(tree, 0, n);
        System.out.println(maxDist(tree, last, n) - 1);

    }
    private static int last;
    private static long maxDist(List<List<Integer>> tree, int start, int n){
        Queue<Integer> que = new LinkedList<>();

        long dist = 0;
        que.offer(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; i++){
                int curr = que.poll();
                for(int neighbour: tree.get(curr)){
                    if(visited[neighbour]) continue;
                    que.offer(neighbour);
                    visited[neighbour] = true;
                }
                last = curr;
            }
            dist++;
        }
        return dist;
    }
}