//package cses;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class entry_3662029 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);

        int numCustomers = sc.nextInt();

        List<CustomerPoint> pointList = new ArrayList<>();
        for (int i = 0; i < numCustomers; i++) {
            pointList.add(new CustomerPoint(sc.nextInt(), true));
            pointList.add(new CustomerPoint(sc.nextInt(), false));
        }

        Collections.sort(pointList);

        int curOverlaps = 0;
        int maxOveraps = 0;
        for (CustomerPoint p : pointList) {
            if (p.isStart) {
                curOverlaps++;
            } else {
                maxOveraps = Math.max(curOverlaps, maxOveraps);
                curOverlaps--;
            }
        }

        System.out.println(maxOveraps);
    }

    static class CustomerPoint implements Comparable {
        int time;
        boolean isStart;

        public CustomerPoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        public int compareTo(Object o) {
            CustomerPoint i = (CustomerPoint) o;

            return time - i.time;
        }
    }

    // implementation gotten from here:
    // http://www.usaco.org/current/data/sol_disrupt_platinum_open18.html
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