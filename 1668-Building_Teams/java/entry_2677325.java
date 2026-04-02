import java.io.*;
    import java.util.*;
    import java.util.InputMismatchException;

public class entry_2677325 {
     int mod = (int)1e9+7;
    public static void main(String[] args) throws Exception {
        entry_2677325 cf = new entry_2677325();
        cf.solve();
    }
    public boolean bfsCheck(List<List<Integer>> adj,int i,int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;
        while(!q.isEmpty()) {
            Integer nde = q.poll();
            for(Integer it:adj.get(nde)) {
                if(color[it]==-1) {
                    color[it] = 1 - color[nde];
                    q.add(it);
                }else if(color[it]==color[nde]) {
                    return false;
                }
            }
        }
        return true;
    }
    public void solve() {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        //Union un = new Union();
          int n = in.readInt();
        int m = in.readInt();
        boolean flag = false;
        int color[] = new int[n+1];
        Arrays.fill(color,-1);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            int a = in.readInt();
            int b = in.readInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        for(int i=1;i<=n;i++) {
            if(color[i]==-1) {
                if(!bfsCheck(adj,i,color)) {
                    out.print("IMPOSSIBLE");
                    return;
                }
            }
        }
            for(int i=1;i<=n;i++) {
                out.print(color[i]+1+" ");
            }



    }
    //logn time
    public long findPower(long x,long n) {
        long ans = 1;
        long nn = n;
        while(nn>0) {
            if(nn%2==1) {
                ans = (ans*x) % mod;
                nn-=1;
            }else {
                x = (x*x)%mod;
                nn/=2;
            }
        }
        return ans%mod;
    }

        //FAST IO
        private static class InputReader {
            private InputStream stream;
            private byte[] buf = new byte[1024];
            private int curChar;
            private int numChars;
            private SpaceCharFilter filter;

            public InputReader(InputStream stream) {
                this.stream = stream;
            }

            public int read() {
                if (numChars == -1) {
                    throw new InputMismatchException();
                }
                if (curChar >= numChars) {
                    curChar = 0;
                    try {
                        numChars = stream.read(buf);
                    } catch (IOException e) {
                        throw new InputMismatchException();
                    }
                    if (numChars <= 0) {
                        return -1;
                    }
                }
                return buf[curChar++];
            }

            public int readInt() {
                int c = read();
                while (isSpaceChar(c)) {
                    c = read();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
                int res = 0;
                do {
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    res *= 10;
                    res += c - '0';
                    c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
            }

            public String readString() {
                int c = read();
                while (isSpaceChar(c)) {
                    c = read();
                }
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = read();
                } while (!isSpaceChar(c));
                return res.toString();
            }

            public double readDouble() {
                int c = read();
                while (isSpaceChar(c)) {
                    c = read();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
                double res = 0;
                while (!isSpaceChar(c) && c != '.') {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    res *= 10;
                    res += c - '0';
                    c = read();
                }
                if (c == '.') {
                    c = read();
                    double m = 1;
                    while (!isSpaceChar(c)) {
                        if (c == 'e' || c == 'E') {
                            return res * Math.pow(10, readInt());
                        }
                        if (c < '0' || c > '9') {
                            throw new InputMismatchException();
                        }
                        m /= 10;
                        res += (c - '0') * m;
                        c = read();
                    }
                }
                return res * sgn;
            }

            public long readLong() {
                int c = read();
                while (isSpaceChar(c)) {
                    c = read();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = read();
                }
                long res = 0;
                do {
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    res *= 10;
                    res += c - '0';
                    c = read();
                } while (!isSpaceChar(c));
                return res * sgn;
            }

            public boolean isSpaceChar(int c) {
                if (filter != null) {
                    return filter.isSpaceChar(c);
                }
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }

            public String next() {
                return readString();
            }

            public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
            }
        }

        private static class OutputWriter {
            private final PrintWriter writer;

            public OutputWriter(OutputStream outputStream) {
                writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
            }

            public OutputWriter(Writer writer) {
                this.writer = new PrintWriter(writer);
            }

            public void print(Object... objects) {
                for (int i = 0; i < objects.length; i++) {
                    if (i != 0) {
                        writer.print(' ');
                    }
                    writer.print(objects[i]);
                }
                writer.flush();
            }

            public void printLine(Object... objects) {
                print(objects);
                writer.println();
                writer.flush();
            }

            public void close() {
                writer.close();
            }

            public void flush() {
                writer.flush();
            }
        }
    }