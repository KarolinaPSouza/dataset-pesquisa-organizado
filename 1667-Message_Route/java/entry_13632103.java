import java.io.*;
import java.util.*;

public class entry_13632103 {
     static List<List<Integer>> adj;
    static int[] parent;
    static boolean[] vis;
    static int steps;
    static List<Integer> ans;

    static class Pair {
        int node;
        int level;
        Pair(int node,int level){
            this.node = node;
            this.level = level;
        }

    }


    static void findpath(int idx){
          if(parent[idx] == -1){
            ans.add(idx);
            return;
          }

          findpath(parent[idx]);
          ans.add(idx);
    }

    public static void main(String[] args)throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
        adj.add(new ArrayList<>());
       }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        vis = new boolean[n+1];
        parent = new int[n+1];


        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,1));
        vis[1] = true;
        parent[1] = -1;

        while(!q.isEmpty()){
            Pair obj = q.poll();
            int node = obj.node;
            int level = obj.level;

            if(node == n){
                steps = level;
                break;
            }

            for(int i:adj.get(node)){
                if(!vis[i]){
                    vis[i] = true;
                    parent[i] = node;
                    q.add(new Pair(i, level+1));
                }
            }
        }





        if(!vis[n]){
            System.out.println("IMPOSSIBLE");
        }else{
             ans = new ArrayList<>();
             findpath(n);
            System.out.println(steps);
            for(int i: ans){
                System.out.print(i+" ");
            }
        }



    }
}