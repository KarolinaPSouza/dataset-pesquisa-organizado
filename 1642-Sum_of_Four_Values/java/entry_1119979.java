import java.util.*;
import java.io.*;
public class entry_1119979 {
    static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 

        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 

        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 

        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 

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
            } 
            while ((c = read()) >= '0' && c <= '9'); 
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
            } 
            while ((c = read()) >= '0' && c <= '9'); 

            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 

            if (neg) 
                return -ret; 
            return ret; 
        } 

        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
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
static class V {
        int a, l, r;
        V(int a, int l, int r) {
            this.a = a; this.l = l; this.r = r;
        }
    }
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] aa = new int[n];
        Integer[] ii = new Integer[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
            ii[i] = i;
        }
        Arrays.sort(ii, (i, j) -> aa[i] - aa[j]);
        int m = n * (n - 1) / 2;
        V[] vv = new V[m];
        m = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int i_ = ii[i], j_ = ii[j];
                vv[m++] = new V(aa[i_] + aa[j_], i, j);
            }
        Arrays.sort(vv, (u, v) -> u.a != v.a ? u.a - v.a : u.l - v.l);
        for (int i = 0, j = m - 1; i < j; i++) {
            long a = vv[i].a;
            while (i < j && a + vv[j].a > x)
                j--;
            if (i < j && a + vv[j].a == x && vv[i].r < vv[j].l) {
                int il = ii[vv[i].l] + 1;
                int ir = ii[vv[i].r] + 1;
                int jl = ii[vv[j].l] + 1;
                int jr = ii[vv[j].r] + 1;
                System.out.println(il + " " + ir + " " + jl + " " + jr);
                return;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}