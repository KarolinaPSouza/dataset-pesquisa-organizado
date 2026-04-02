//package org.vineethkanaparthi.graphs;

import java.io.*;
import java.util.*;

public class entry_9077333 {

    public static class Result{
        private int[] group;
        private boolean found;

        Result(int[] group, boolean found){
            this.group = group;
            this.found = found;
        }

        public int[] getGroup() {
            return group;
        }

        public void setGroup(int[] group) {
            this.group = group;
        }

        public boolean isFound() {
            return found;
        }

        public void setFound(boolean found) {
            this.found = found;
        }
    }
    public static class Edge{
        private int src;
        private int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        public int getSrc() {
            return src;
        }

        public void setSrc(int src) {
            this.src = src;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(int dest) {
            this.dest = dest;
        }
    }
    int n;

    List<Edge> edges;
    List<Integer>[] graph;

    entry_9077333(int n, List<Edge> edges){
        this.n = n;
        this.edges = edges;
        this.graph = new ArrayList[n];
        Arrays.setAll(this.graph, i -> new ArrayList<>());
        for(Edge edge: edges){
            int u = edge.getSrc()-1;
            int v = edge.getDest()-1;
            graph[u].add(v);
            graph[v].add(u);
        }
    }

    public boolean bfs(int i, boolean[] visited, int[] group){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        group[i] = 1;
        boolean possible = true;
        while(!q.isEmpty()) {
            int u = q.poll();
            for (Integer v : graph[u]) {
                if (visited[v]) {
                    if (group[v] == group[u]) {
                        possible = false;
                        break;
                    }
                } else {
                    visited[v] = true;
                    group[v] = (group[u] == 1) ? 2 : 1;
                    q.offer(v);
                }
            }
        }
        return possible;
    }

    public Result segregate(){
        int[] group = new int[n];
        boolean[] visited = new boolean[n];
        boolean possible = true;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(!bfs(i, visited, group)){
                    possible = false;
                    break;
                }
            }
        }

        return new Result(group, possible);
    }

    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            List<entry_9077333.Edge> edges = new ArrayList<>();
            for(int i=0;i<m;i++){
                input = reader.readLine().split(" ");
                int src = Integer.parseInt(input[0]);
                int dest = Integer.parseInt(input[1]);
                entry_9077333.Edge e = new entry_9077333.Edge(src, dest);
                edges.add(e);
            }

            entry_9077333 bt = new entry_9077333(n, edges);
            Result result = bt.segregate();
            if(result.isFound()){
                int[] group = result.getGroup();
//                writer.write(group.length + "\n");
                for(int i=0;i<group.length;i++){
                    writer.write(group[i] + " ");
                }
                writer.write("\n");
            }else{
                writer.write("IMPOSSIBLE\n");
            }

            reader.close();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}