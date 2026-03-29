import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class entry_14362714 {
    private static class FastReader {

        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        // default: stdin
        FastReader() {
            this.in = System.in;
        }

        // read from file
        FastReader(String fileName) throws FileNotFoundException {
            this.in = new FileInputStream(fileName);
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' '); // skip whitespace
            boolean neg = c == '-';
            if (neg) c = readByte();
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    private static class Triplet{
        int position;
        long cost;
        boolean couponUsed;
        Triplet(int position, long cost, boolean couponUsed) {
            this.position=position;
            this.cost=cost;
            this.couponUsed=couponUsed;
        }
    }

    private static Long[][] costArr;
    private static Long INF = (long) 10E+14;

    public static void main(String[] args) throws IOException {
//        Long now = Instant.now().toEpochMilli();
        FastReader fr = new FastReader();
//        FastReader fr = new FastReader("src/graph/input.txt");
        int n = fr.nextInt();
        int m = fr.nextInt();
        costArr = new Long[n+1][2];
        List<Long[]>[] adjList = new List[n+1];
        for(int i=1;i<=n;i++) {
            Arrays.fill(costArr[i], INF);
            adjList[i] = new ArrayList<>();
        }
        for (int i=0;i<m;i++) {
            int a = fr.nextInt();
            long b = fr.nextLong();
            long c = fr.nextLong();
            adjList[a].add(new Long[]{b,c});
        }
        solve(adjList);
        System.out.println(costArr[n][1]);
    }

    private static void solve(List<Long[]>[] adjList) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>(new Comparator<Triplet>() {
            @Override
            public int compare(Triplet o1, Triplet o2) {
                return Long.compare(o1.cost, o2.cost);
            }
        });
        pq.add(new Triplet(1,0,false));
        while(!pq.isEmpty()) {
            Triplet u = pq.poll();
            if (u.couponUsed && costArr[u.position][1] < u.cost) continue;
            else if (!u.couponUsed && costArr[u.position][0] < u.cost) continue;
            if(u.couponUsed) costArr[u.position][1] = Math.min(costArr[u.position][1],u.cost);
            else costArr[u.position][0] = Math.min(costArr[u.position][0],u.cost);
            for(Long[] neighbour: adjList[u.position]) {
                int v = Math.toIntExact(neighbour[0]);
                long cost = u.cost+neighbour[1];
                if(u.couponUsed) {
                    if (costArr[v][1]<=cost) continue;
                    costArr[v][1]=cost;
                    pq.add(new Triplet(v,cost, u.couponUsed));
                } else {
                    if (cost<costArr[v][0]) {
                        costArr[v][0] = cost;
                        pq.add(new Triplet(v,cost, u.couponUsed));
                    }
                    cost = u.cost+neighbour[1]/2;
                    if (costArr[v][1]<=cost) continue;
                    costArr[v][1]=cost;
                    pq.add(new Triplet(v,cost, true));
                }
            }
        }
    }
}