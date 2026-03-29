//package U04_15;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class entry_12690002 {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        ArrayList<Project> ends = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt();
            Project p = new Project(a, b, c);
            ends.add(p);
        }
        ends.sort(Comparator.comparingInt(o -> o.end));
        long[] dp = new long[n+1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            Project p = ends.get(i);
            int index = biggestLowerBound(p, ends, n);
            long op1 = dp[i];
            long op2 = dp[index] + p.reward;
            dp[i+1] = Math.max(op1, op2);
        }
        System.out.println(dp[n]);
    }
    static int biggestLowerBound(Project p, ArrayList<Project> a, int n) {
        int l = -1, r = n;
        while (r - l > 1) {
            int m = l + (r-l)/2;
            if (a.get(m).end < p.start) {
                l = m;
            } else r = m;
        }
        return l+1;
    }
    static class Project {
        int start;
        int end;
        long reward;
        public Project(int a, int b, long c) {
            start = a; end = b; reward = c;
        }
    }
    static class FastReader {
        StringTokenizer s;
        BufferedReader b;
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String fileName){
            try {
                FileReader in = new FileReader(fileName);
                b = new BufferedReader(in);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        public String next() {
            while (s == null || !s.hasMoreTokens()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }
        public String nextLine() {
            try {
                return b.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}