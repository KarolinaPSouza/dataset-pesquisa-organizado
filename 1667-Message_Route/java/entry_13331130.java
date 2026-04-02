import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.compare;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class entry_13331130 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(in));
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
            return parseInt(next());
        }

        long nextLong() {
            return parseLong(next());
        }

        double nextDouble() {
            return parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    //Codeforces venus2006
                    //gadagadigadagadaoo >~<
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Pair implements Comparable<Pair> {
        int val, index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return compare(this.val, o.val);
        }

        @Override
        public String toString() {
            return "(" + val + ", " + index + ")";
        }
    }


    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
            out.flush();
        }
    }

    static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            list.get(u).add(v);
            list.get(v).add(u);
        }
        int[] parent = new int[n + 1];
        boolean[]v=new boolean[n+1];
        int[]cnt=new int[n+1];
        ArrayDeque<Integer>q=new ArrayDeque<>();
        q.add(1);v[1]=true;parent[1]=-1;cnt[1]=1;
        while (!q.isEmpty()){
            int node=q.poll();
            for(int x:list.get(node)){
                if(!v[x]){
                    v[x]=true;
                    parent[x]=node;
                    cnt[x]=cnt[node]+1;
                    q.add(x);
                }
            }
        }
        if(!v[n]){
            out.println("IMPOSSIBLE");
            return;
        }
        ArrayDeque<Integer>s=new ArrayDeque<>();
        out.println(cnt[n]);
        while(parent[n]!=-1){
            s.addFirst(n);
            n=parent[n];
        }
        s.addFirst(1);
        while (!s.isEmpty()){
            out.print(s.pollFirst() + " ");
        }

    }
}