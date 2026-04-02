import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class entry_11393939 {
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = fr.nextInt();
        long x = fr.nextLong();
        String[] s = fr.nextLine().split(" ");
        long[] arr = new long[n];

        for (int i=0; i < s.length; i++) {
            arr[i] = Long.parseLong(s[i]);
        }

        HashMap<Long, Integer> hm = new HashMap<Long, Integer>();
        for (int i=0; i < arr.length; i++) {
            long diff = x - arr[i];
            if (hm.get(diff) != null) {
                out.print(hm.get(diff) + 1 + " ");
                out.print(i + 1);
                out.flush();
                return; 
            } else {
                hm.put(arr[i], i);
            }
        }
        out.print("IMPOSSIBLE");
        out.flush();
    }
}