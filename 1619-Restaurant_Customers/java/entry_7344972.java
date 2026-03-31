import java.io.*;

import java.util.*;
public class entry_7344972 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st = null;
        PrintWriter pw;
        BufferedWriter bw;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
            pw = new PrintWriter(
                    new OutputStreamWriter(System.out));
            bw = new BufferedWriter(
                    new OutputStreamWriter(System.out));
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
                if (st != null && st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextArr(int n) {
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        FastReader fr = new FastReader();

        int t = 1;
        while(t-->0)
        {
            int n = fr.nextInt();
            TreeMap<Integer,Integer> tm = new TreeMap<>();
            for(int i=0;i<n;i++)
            {
                tm.put(fr.nextInt(),1);
                tm.put(fr.nextInt(),-1);
            }
            int res = 0;
            int max = 0;
            for(int i:tm.values())
            {
                res += i;
                max = Math.max(max,res);
            }
            System.out.println(max);
        }
        fr.pw.close();
    }

}