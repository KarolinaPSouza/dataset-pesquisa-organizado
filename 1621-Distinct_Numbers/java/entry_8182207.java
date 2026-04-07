//BufferedReader br = new BufferedReader(new FileReader("traffic.in"));
//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));

import java.io.*;
import java.util.*;

public class entry_8182207 {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();

  int n = io.nextInt();
        Set<Integer> nums = new HashSet<>();

        for(int i = 0; i < n; i++){
            int num = io.nextInt();
            nums.add(num);
        }

        io.println(nums.size());
        io.flush();

    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

}