import java.util.Scanner;
import java.util.PriorityQueue;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class entry_16042769 {
    static class Pair{
        int idx;
        long val;
        int used;
        public Pair(int idx,long val,int used){
            this.idx = idx;
            this.val = val;
            this.used= used;
        }
        int getIdx(){
            return idx;
        }
        long getVal(){
            return val;
        }
    }

    public static void main(String[] args) throws Exception{

        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int m = fs.nextInt();


        List<List<int[]>> graph = new ArrayList<>(n);

        for(int i=0;i<n;i++)graph.add(new ArrayList<int[]>());

        for(int i=0;i<m;i++){
            int a = fs.nextInt()-1;
            int b = fs.nextInt()-1;
            int c = fs.nextInt();
            graph.get(a).add(new int[]{b,c});
        }

        long[][] dist = new long[n][2];
        for(int i=0;i<n;i++)
        Arrays.fill(dist[i],Long.MAX_VALUE);

        PriorityQueue<Pair> queue = new PriorityQueue<>(new PairComparator());

        queue.add(new Pair(0,0,0));
        dist[0][0]=0;
        dist[0][1]=0;

        while(!queue.isEmpty()){
            Pair curr = queue.remove();
            if(dist[curr.idx][curr.used] != curr.val)continue;
            for(int[] neigh : graph.get(curr.idx)){
                if(dist[neigh[0]][curr.used] > curr.val +neigh[1]){
                    dist[neigh[0]][curr.used] = curr.val + neigh[1];
                    queue.add(new Pair(neigh[0],dist[neigh[0]][curr.used],curr.used));
                }
                if(curr.used==0){
                    if(dist[neigh[0]][1] > curr.val +neigh[1]/2){
                          dist[neigh[0]][1] = curr.val + neigh[1]/2;
                          queue.add(new Pair(neigh[0],dist[neigh[0]][1],1));
                    }
                }
            }
        }
        System.out.println(dist[n-1][1]);
    }

    static class PairComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair p1, Pair p2) {
            return Long.compare(p1.val,p2.val);
        }

    }


 static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            int c; do { c = read(); } while (c <= ' ');
            long sgn = 1;
            if (c == '-') { sgn = -1; c = read(); }
            long val = 0;
            while (c > ' ') { val = val * 10 + (c - '0'); c = read(); }
            return val * sgn;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }

} 