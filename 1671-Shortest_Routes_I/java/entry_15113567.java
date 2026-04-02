import java.io.*;
import java.util.*;

public class entry_15113567 {
    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                ptr = 0;
                len = System.in.read(buffer);
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' ');
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char)c);
                c = readByte();
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = readByte(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = readByte(); }
            for (; c > ' '; c = readByte())
                val = val * 10 + c - '0';
            return val * sign;
        }
    }


    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i =0 ; i<=n ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<m ; i++){
            list.get((sc.nextInt())).add(new int[]{sc.nextInt() , sc.nextInt()});
        }
        long[] dis = new long[n+1];
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        q.add(new long[]{1,0});
        Arrays.fill(dis , Long.MAX_VALUE);
        dis[1] = 0;
        while(!q.isEmpty()){
            long[] p = q.poll();
            int node = (int)p[0];
            long d = p[1];
            if(d>dis[node]) continue;
            for(int[] i : list.get(node)){
                int val = i[0];
                int di = i[1];
                if(dis[val] > d+(long)di){
                    q.add(new long[]{val,d+(long)di});
                    dis[val] = d+(long)di;
                }
            }
        }
        for(int i = 1 ;i<=n ; i++){
            System.out.print(dis[i]+" ");
        }
        }
    }
