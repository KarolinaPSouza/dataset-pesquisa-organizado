import java.util.*;
import java.io.*;

public class entry_3553346 {

    public static void main(String[] arg) {
        FastScanner sc = new FastScanner(System.in);
        int numCities = sc.nextInt();
        int numRoads = sc.nextInt();
        int numQueries = sc.nextInt();

        // create matrix of paths
        long[][] arr = new long[numCities][numCities];
        for (int i = 0; i < numCities; ++i) {
            for (int j = 0; j < numCities; ++j) {
                if (i != j) {
                    arr[i][j] = Long.MAX_VALUE;
                }
            }
        }

        // read in paths
        for (int i = 0; i < numRoads; ++i) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            long weight = sc.nextLong();
            if (weight < arr[a][b]) {
                arr[a][b] = weight;
                arr[b][a] = weight;
            }
        }

        // floyd warshall
        for (int k = 0; k < numCities; ++k) {
            for (int v = 0; v < numCities; ++v) {
                for (int w = 0; w < numCities; ++w) {
                    if (v != w) {
                        if (arr[v][k] != Long.MAX_VALUE && arr[k][w] != Long.MAX_VALUE) {
                            long dist = arr[v][k] + arr[k][w];
                            arr[v][w] = Math.min(arr[v][w], dist);
                        }
                    }
                }
            }
        }

        // output for designated queries
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numQueries; ++i) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            if (arr[a][b] == Long.MAX_VALUE) {
                result.append(-1);
            } else {
                result.append(arr[a][b]);
            }
            result.append("\n");
        }
        System.out.print(result.toString());
    }

    // wrapper class created by competitive programming coach Matt Fontaine
    public static class FastScanner{
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