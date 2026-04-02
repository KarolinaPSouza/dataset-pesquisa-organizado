import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class entry_3649916 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; ++i) {
            coins[i] = sc.nextInt();
        }

        int[] minNums = new int[x + 1];

        for (int i = 1; i <= x; ++i) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int comp = i - coin;
                if (comp >= 0) {
                    int num = minNums[comp] + 1;
                    if (num > 0) {
                        min = Math.min(min, num);
                    }
                }
            }
            minNums[i] = min != Integer.MAX_VALUE ? min : -1;
        }

        System.out.println(minNums[x]);
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