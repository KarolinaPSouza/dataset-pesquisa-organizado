import java.util.*;
import java.io.*;

public class entry_13863791 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        char nextChar() {
            return next().charAt(0);
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            int n = in.nextInt();
            int x = in.nextInt();

            int[][] wt=new int[n][2];
            for(int i=0;i<n;i++) {
                wt[i][0]=in.nextInt();
                wt[i][1]=i+1;
            }

            Arrays.sort(wt,(a,b)->a[0]-b[0]);
            int l=0;
            int r=wt.length-1;
            boolean f=false;
            while(l<r){
                if(wt[l][0]+wt[r][0]==x){
                    int min=Math.min(wt[l][1],wt[r][1]);
                    int max=Math.max(wt[l][1],wt[r][1]);
                    out.println(min+" "+max);
                    f=true;
                    break;
                }
                else if(wt[l][0]+wt[r][0]<x){
                    l++;
                }
                else{
                    r--;
                }
            }
            if(!f)
                out.println("IMPOSSIBLE");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}