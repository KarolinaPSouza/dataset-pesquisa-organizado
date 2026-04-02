import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

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
public class entry_16082697 {
    public static void main(String[] args){
        long MAX=(long)1e12;
        FastReader ip=new FastReader();
        StringBuilder op=new StringBuilder();
        int n=ip.nextInt(),m=ip.nextInt();
        int q=ip.nextInt();
        long dist[][]=new long[n+1][n+1];
        for(long i[]:dist) Arrays.fill(i,MAX);
        for(int i=1;i<=n;i++) dist[i][i]=0;
        for(int i=0;i<m;i++){
            int u=ip.nextInt();
            int v=ip.nextInt();
            int w=ip.nextInt();
            dist[u][v]=dist[v][u]=Math.min(dist[u][v],w);
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(dist[i][k]!=MAX && dist[k][j]!=MAX);
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        while(q-->0){
            int a=ip.nextInt(),b=ip.nextInt();
            op.append(dist[a][b]==MAX?-1:dist[a][b]).append("\n");
        }
        System.out.println(op);
    }
}