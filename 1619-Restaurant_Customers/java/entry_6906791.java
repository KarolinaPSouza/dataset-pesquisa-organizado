import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_6906791 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static class Pair implements Comparable<Pair>{
        public int ind;
        public int val;

        public Pair(int ind, int val) {
            this.ind = ind;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return ind - o.ind;
        }

        public String toString() {
            return ind+": "+val;
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        ArrayList<Pair> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = in.nextInt();
            a.add(new Pair(index, 1));

            index = in.nextInt();
            a.add(new Pair(index, -1));
        }
        a.sort(Comparator.naturalOrder());
        int max = 0;
        int count = 0;
        for (Pair p : a) {
            count += p.val;
            if (count > max)
                max = count;
        }
//        System.out.println(a);
        System.out.println(max);
    }
}