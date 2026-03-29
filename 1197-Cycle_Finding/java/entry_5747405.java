import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class entry_5747405 {


    public static void main(String[] args) {

        FastReader in=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t = 1;
        while (t-- > 0) {

            int n = in.nextInt();
            int m = in.nextInt();

            ArrayList<Integer> adl[];
            adl = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adl[i] = new ArrayList<>();
            }

            long dist[] = new long[n + 1];
            Arrays.fill(dist, (long) (1e15));
            dist[1]=0;
            int parent[]=new int[n+1];
            int edge[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = in.nextInt();
                edge[i][1] = in.nextInt();
                edge[i][2] = in.nextInt();
            }


            for (int i = 0; i < n - 1; i++) {
                for (int x[] :
                        edge) {

                    int from = x[0];
                    int to = x[1];
                    long cost = x[2];

                    if (dist[from] + cost < dist[to]) {
                        dist[to] = dist[from] + cost;
                        parent[to]=from;
                    }
                }

            }
            int f=-1;
            for (int x[]:
                    edge) {

                int from=x[0];
                int to=x[1];
                int cost=x[2];

                if(dist[from]+cost<dist[to]) {
                    dist[to]=dist[from]+cost;
                    parent[to]=from;
                    f=to;
                }
            }
            if(f==-1) out.println("NO");
            else{
                out.println("YES");

                for (int i = 1; i <=n ; i++) {
                    f=parent[f];
                }

                ArrayList<Integer> arr=new ArrayList<>();
                int curr=f;
                do{
                    arr.add(curr);
                    curr=parent[curr];
                }while(curr!=f);

                arr.add(curr);
                for (int i = arr.size()-1; i >=0 ; i--) {
                    if(i!=arr.size()-1) out.print(" ");
                    out.print(arr.get(i));
                }

            }


            out.close();

        }

    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
}
