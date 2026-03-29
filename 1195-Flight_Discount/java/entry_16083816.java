import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.PriorityQueue;

class FastReader {
    private InputStream is = System.in;
    private byte[] inbuf = new byte[1 << 16]; // 64KB Buffer
    private int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    public String next() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public int nextInt() {
        int c = skip();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = readByte();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res = res * 10 + c - '0';
            c = readByte();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = skip();
        long sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = readByte();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res = res * 10 + c - '0';
            c = readByte();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
public class entry_16083816 {
    public static void main(String[] args){
        FastReader ip=new FastReader();
        int n=ip.nextInt(),m=ip.nextInt();
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u=ip.nextInt();
            int v=ip.nextInt();
            int w=ip.nextInt();
            adj.get(u).add(new int[]{v,w});
        }

        long dist[][]=new long[n+1][2];
        for(long i[]:dist) i[0]=i[1]=Long.MAX_VALUE;
        dist[1][0]=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[2],b[2]));
        pq.offer(new long[]{1,0,0});
        while(!pq.isEmpty()){
            long curr[]=pq.poll();
            int i=(int)curr[0],state=(int)curr[1];
            if(dist[i][state]<curr[2]) continue;
            for(int j[]:adj.get(i)){
                if(dist[i][state]+j[1]<dist[j[0]][state]){
                    dist[j[0]][state]=dist[i][state]+j[1];
                    pq.offer(new long[]{j[0],state,dist[j[0]][state]});
                }
                if(state==0){
                    if(dist[i][0]+j[1]/2<dist[j[0]][1]){
                        dist[j[0]][1]=dist[i][0]+j[1]/2;
                        pq.offer(new long[]{j[0],1,dist[j[0]][1]});
                    }
                }
            }
        }
        long ans=Math.min(dist[n][0],dist[n][1]);
        System.out.println(ans);
    }
}