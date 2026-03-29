//package com.company2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class entry_3494145 {

    static List<Integer> cycle = new ArrayList<>();
    static class Reader {
        final private int             BUFFER_SIZE = 1 << 16;
        private       DataInputStream din;
        private       byte[]          buffer;
        private       int             bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    static class Edge {
        int u;
        int v;
        int w;
        Edge(int u, int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }
    static class Node{
        int ver;
        long dist;
        long half;
        Node(int ver, long dist,long half){
            this.ver = ver;
            this.dist= dist;
            this.half=half;
        }
    }
    public static void main(String[] args) throws IOException {
 // write your code here
        List<Edge> edges = new ArrayList<>();
        List<List<Edge>> adj = new ArrayList<>();
      //  Scanner sc = new Scanner(System.in);
        Reader s = new Reader();
        int n = s.nextInt();
        int m = s.nextInt();
        //System.out.println(n+","+m);
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
           // System.out.println(i);
            int u= s.nextInt();
            int v=s.nextInt();
            int w= s.nextInt();

            Edge t= new Edge(u,v,w);
            edges.add(t);
            adj.get(u).add(t);

        }

        System.out.println(findShortestPath(edges,n,adj));
    }

    public static long findShortestPath(List<Edge> edges,int n, List<List<Edge>> adj){

        long[] d= new long[n+1];
        long[] h= new long[n+1];
        int[] c= new int[n+1];
        for(int i=0;i<n;i++){
            c[i+1]=-1;
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>((o1, o2) -> {
            if(o1.dist<o2.dist){
                return -1;
            }
            return 1;
        });

        PriorityQueue<Node> pq2 = new PriorityQueue<Node>((o1, o2) -> {
            if(o1.half<o2.half){
                return -1;
            }
            return 1;
        });
        for(int i=1;i<n+1;i++){
            d[i]=Long.MAX_VALUE;
            h[i]=Long.MAX_VALUE;
        }
        d[1]=0;
        h[1]=Long.MAX_VALUE;
        pq.add(new Node(1,0,Long.MAX_VALUE));
        int cnt=0;
        while(!pq.isEmpty() && cnt<n){
            Node t= pq.poll();
            if(c[t.ver]==0){
                continue;
            }
            c[t.ver]=0;
            cnt++;
            for(int i=0;i<adj.get(t.ver).size();i++){
                int v = adj.get(t.ver).get(i).v;
                int w = adj.get(t.ver).get(i).w;
                if(d[v]>d[t.ver]+w){
                    d[v]=d[t.ver]+w;

                    h[v]=Math.min(d[t.ver]+w/2,h[v]);
                    pq.add(new Node(v,d[v],h[v]));
                }
                if(h[v]>d[t.ver]+w/2){
                    h[v]=d[t.ver]+w/2;
                }

            }
        }
        for(int i=0;i<n;i++){
            c[i+1]=-1;
        }

        h[1]=0;
        pq2.add(new Node(1,0,h[1]));
        cnt=0;
        while(!pq2.isEmpty() && cnt<n){
            Node t= pq2.poll();
            if(c[t.ver]==0){
                continue;
            }
            c[t.ver]=0;
            cnt++;
            for(int i=0;i<adj.get(t.ver).size();i++){
                int v = adj.get(t.ver).get(i).v;
                int w = adj.get(t.ver).get(i).w;
                if(h[v]>h[t.ver]+w){
                    h[v]=h[t.ver]+w;
                }
                pq2.add(new Node(v,d[v],h[v]));
            }
        }
       /* for(int i=1;i<=n;i++) {
            System.out.println(d[i]+","+h[i]);
        }*/
        return h[n];

    }
}

