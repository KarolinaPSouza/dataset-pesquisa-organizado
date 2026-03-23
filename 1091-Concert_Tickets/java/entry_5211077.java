import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class entry_5211077 {
        static FastScanner a = new FastScanner();
        static Reader in =  new Reader();
        static PrintWriter out = new PrintWriter(System.out);
        static StringBuilder sb = new StringBuilder();
        public static void main(String[] args) throws IOException {
                int n = in.nextInt(), m = in.nextInt();
                TreeMap<Integer,Integer> map = new TreeMap<>();
                for(int i = 0; i < n; i++) {
                        int a = in.nextInt();
                        map.put(a, map.getOrDefault(a,0)+1);
                }
                Map.Entry<Integer, Integer> val;
                while(m-- != 0) {
                        int b = in.nextInt();
                        val = map.floorEntry(b);
                        if(val != null){
                                if(val.getValue() == 1) map.remove(val.getKey());
                                else map.put(val.getKey(),val.getValue()-1);
                                sb.append(val.getKey()).append("\n");
                        }
                        else sb.append("-1\n");

                }
                out.print(sb);
                out.close();
        }

        static class Pair{
                int x,h;
                Pair(int a, int b){
                        x = a;
                        h = b;
                }
        }
        static class FastScanner {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer("");

                String next() {
                        while (!st.hasMoreTokens())
                                try {
                                        st = new StringTokenizer(br.readLine());
                                } catch (IOException e) {
                                        e.printStackTrace();
                                }
                        return st.nextToken();
                }

                String nextLine() throws IOException {
                        return br.readLine();
                }

                int nextInt() {
                        return Integer.parseInt(next());
                }

                int[] readArray(int n) {
                        int[] a = new int[n];
                        for (int i = 0; i < n; i++) a[i] = nextInt();
                        return a;
                }

                long nextLong() {
                        return Long.parseLong(next());
                }
        }
        static class Reader {
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



}







