import java.io.*;
import java.util.*;

public class entry_16027653 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] in = new int[n];
        int[]out = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = sc.nextInt();
            out[i] = sc.nextInt();
        }
        Arrays.sort(in);
        Arrays.sort(out);
        int i = 0,j =0,cur = 0,max = 0;
        while(i < n && j< n){
            if(in[i] <=  out[j]){
                cur++;
                max = Math.max(cur,max);
                i++;
            }else{
                j++;
                cur--;
            }
        }
        System.out.println(max);

    }
}