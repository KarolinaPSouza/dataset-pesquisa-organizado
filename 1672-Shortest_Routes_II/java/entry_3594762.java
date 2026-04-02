import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class entry_3594762 {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long q = sc.nextInt();
        long[][] matrix = new long[n][n];
        //init matrix
        for(int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], Long.MAX_VALUE);
            matrix[i][i] = 0;
        }
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int val = sc.nextInt();
            //case for when matrix updates a path with a longer path
            if(matrix[x - 1][y - 1] > val) {
                matrix[x - 1][y - 1] = val;
                matrix[y - 1][x - 1] = val;
            }

        }

        //Floyd-marshall
        for(int k = 0; k < matrix.length; k++) {
            for(int v = 0; v < matrix.length; v++) {
                //consider the case where we don't know any distance yet
                long distForKV = k < v ? matrix[k][v] : matrix[v][k];
                if(v == k || distForKV == Long.MAX_VALUE) {
                    continue;
                }
                //undirected graph, can only worry about diagonal
                for(int w = v + 1; w < matrix.length; w++) {
                    long distForVW = k < v ? matrix[k][w] : matrix[w][k];
                    if(k == w || w == v || distForVW == Long.MAX_VALUE) {
                        continue;
                    }
                    if(matrix[v][w] > distForKV + distForVW) {
                        matrix[v][w] = distForKV + distForVW;
                        matrix[w][v] = distForKV + distForVW;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(matrix[x - 1][y - 1] == Long.MAX_VALUE && matrix[y - 1][x - 1] == Long.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(Math.min(matrix[x - 1][y - 1], matrix[y - 1][x - 1]));
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    /***************************************************************************************
     *    Title: FastScanner
     *    Author: Matt Fontaine
     *    Availability: http://www.usaco.org/current/data/sol_disrupt_platinum_open18.html
     *
     ***************************************************************************************/
    static class FastScanner{
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream)
        {
            this.stream = stream;
        }

        int read()
        {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars){
                curChar = 0;
                try{
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c)
        {
            return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
        }

        boolean isEndline(int c)
        {
            return c=='\n'||c=='\r'||c==-1;
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String next(){
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do{
                res.appendCodePoint(c);
                c = read();
            }while(!isSpaceChar(c));
            return res.toString();
        }

        String nextLine(){
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do{
                res.appendCodePoint(c);
                c = read();
            }while(!isEndline(c));
            return res.toString();
        }
    }
}