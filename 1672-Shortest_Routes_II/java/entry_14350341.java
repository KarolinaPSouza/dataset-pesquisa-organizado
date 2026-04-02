import java.io.*;
import java.time.Instant;
import java.util.*;

public class entry_14350341 {
    static class FastReader {

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

    private static long[][] distance;
    private static final long MOD = (long) 10E+14;

    public static void main(String[] args) throws IOException {
//        Long now = Instant.now().toEpochMilli();
        FastReader fr = new FastReader();
//        FastReader fr = new FastReader("src/graph/input.txt");
        int n = fr.nextInt();
        int m = fr.nextInt();
        int q = fr.nextInt();
        distance = new long[n+1][n+1];
        for(int i=1;i<=n;i++) {
            Arrays.fill(distance[i],MOD);
            distance[i][i]=0;
        }
        for (int i=0;i<m;i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            long c = fr.nextLong();
            if (c<distance[a][b]) {
                distance[a][b]=c;
                distance[b][a]=c;
            }
        }
        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                if(i==k || distance[i][k]==MOD) continue;
                for(int j=1;j<=n;j++) {
//                    if(distance[j][k]==MOD)continue;
                    long nd = distance[i][k]+distance[k][j];
                    if (nd<distance[i][j]) distance[i][j]=nd;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++){
            int a = fr.nextInt();
            int b = fr.nextInt();
            long dis = distance[a][b];
            if (dis==MOD) dis = -1;
            sb.append(dis).append(" ");
        }
        System.out.println(sb);
//        Long now2 = Instant.now().toEpochMilli();
//        System.out.println("Time taken " + (now2-now));
    }

}