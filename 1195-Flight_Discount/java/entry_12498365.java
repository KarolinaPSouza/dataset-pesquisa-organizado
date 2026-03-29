//package graphAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class entry_12498365 {

    private static class Entry{
        long dist;
        int start;
        int discountUse;

        public Entry(long dist,int start,int discountUse){
            this.dist = dist;
            this.start = start;
            this.discountUse = discountUse;
        }
    }

    private static class Edge{
        int end;
        long weight;

        public Edge(int end,long weight){
            this.end = end;
            this.weight = weight;
        }
    }

    private static class EntryComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry e1,Entry e2){
            return Long.compare(e1.dist,e2.dist);
        }
    }

    public static void main(String[] args){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer inRead = new StringTokenizer(in.readLine());

            int n = Integer.parseInt(inRead.nextToken());
            int m = Integer.parseInt(inRead.nextToken());

            long[][] distance = new long[n+1][2];
            List<List<Edge>> edges = new ArrayList<>(n+1);

            for(int i=0;i<n+1;i++){
                distance[i][0] = Long.MAX_VALUE;
                distance[i][1] = Long.MAX_VALUE;
                edges.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                inRead = new StringTokenizer(in.readLine());

                int a = Integer.parseInt(inRead.nextToken());
                int b = Integer.parseInt(inRead.nextToken());
                long weight = Long.parseLong(inRead.nextToken());

                edges.get(a).add(new Edge(b,weight));
            }

            PriorityQueue<Entry> queue = new PriorityQueue<>(new EntryComparator());
            distance[1][0] = 0;
            distance[1][1] = 0;
            queue.offer(new Entry(0,1,0));

            while(!queue.isEmpty()){
                Entry e = queue.poll();
                if(distance[e.start][e.discountUse] < e.dist) continue;
//                System.out.println(e.dist+" "+e.start+" "+e.discountUse);
                for(Edge ed : edges.get(e.start)){
//                    System.out.println(ed.end+" "+ed.weight);
                    if(e.discountUse == 1){
                        if(distance[ed.end][1] > e.dist + ed.weight){
                            distance[ed.end][1] = e.dist + ed.weight;
                            queue.offer(new Entry(distance[ed.end][1],ed.end,1));
                        }
                    }else{
                        if(distance[ed.end][0] > e.dist + ed.weight){
                            distance[ed.end][0] = e.dist + ed.weight;
                            queue.offer(new Entry(distance[ed.end][0],ed.end,0));
                        }
                        int isOk = 0;
                        if(distance[e.start][1] < Long.MAX_VALUE && distance[ed.end][1] > distance[e.start][1] + ed.weight){
                            isOk = 1;
                            distance[ed.end][1] = distance[e.start][1] + ed.weight;
                        }

                        if(distance[ed.end][1] > e.dist + ed.weight/2) {
                            isOk = 1;
                            distance[ed.end][1] = e.dist + ed.weight / 2;
                        }

                        if(isOk == 1)
                            queue.offer(new Entry(distance[ed.end][1],ed.end,1));
                    }
                }
            }

            System.out.println(Long.min(distance[n][1],distance[n][0]));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
