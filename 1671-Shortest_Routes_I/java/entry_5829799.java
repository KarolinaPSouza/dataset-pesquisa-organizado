import java.util.*;
import java.io.*;

public class entry_5829799 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        st = new StringTokenizer(br.readLine());
        int cities = Integer.parseInt(st.nextToken());
        int roads = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i = 0; i < cities+1;i++)
            adj.add(new ArrayList<pair>());

        boolean[] visited = new boolean[cities+1];
        long[] dist = new long[cities+1];
        dist[1] = 0;
        for(int i = 2; i < cities+1;i++)
            dist[i] = Long.MAX_VALUE;


        while(roads-->0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(from).add(new pair(to,w));
        }

        PriorityQueue<pair> queue = new PriorityQueue<>();
        queue.add(new pair(1,0));


        while(!queue.isEmpty()){
            pair curEdge = queue.poll();
            if(visited[curEdge.to])
                continue;
            visited[curEdge.to] = true;

            for(pair c: adj.get(curEdge.to)){
                if(dist[curEdge.to]+c.w < dist[c.to]){
                    dist[c.to] = dist[curEdge.to]+c.w;
                    queue.add(new pair(c.to, dist[c.to]));
                }

            }
        }

        for(int i = 1; i < cities+1;i++)
            pw.print(dist[i]+" ");
        pw.close();
    }

    public static class pair implements Comparable<pair>{
        int to;
        long w;
        public pair(int too, long ww){
            to = too;
            w = ww;
        }


        @Override
        public int compareTo(pair o) {
            return Long.compare(w,o.w);
        }

        public String toString(){
            return String.valueOf(to);
        }
    }







}
