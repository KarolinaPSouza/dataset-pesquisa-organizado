//package kg.my_algorithms.Codeforces;




import java.io.*;
import java.util.*;

public class entry_7802221 {

    private static final PrintWriter out = new PrintWriter(System.out);
    private static final FastReader fr = new FastReader();
    private static final long MOD = 1_000_000_007L;
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static final Stack<Integer> stack = new Stack<>();
    private static final List<Integer> list = new ArrayList<>();
    private static boolean[] vis;
//        private static final Scanner slow_scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
//        int testCases = fr.nextInt();
//        for(int testCase=1;testCase<=testCases;testCase++) {
//
//        }
        int n = fr.nextInt();
        int m = fr.nextInt();
        vis = new boolean[n];
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u = fr.nextInt()-1;
            int v = fr.nextInt()-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            if(!vis[i] && list.size() == 0){
                dfs(i,-1);
            }
        }
        if(list.size() == 0){
            out.println("IMPOSSIBLE");
        }
        else{
            out.println(list.size());
            for(int a: list) out.print((a+1) + " ");
        }
        out.flush();
    }
    private static void dfs(int node, int parent){
        if(list.size()>0) return;
        if(vis[node]){
            list.add(node);
            while(stack.peek()!=node){
                list.add(stack.pop());
            }
            list.add(node);
            return;
        }
        stack.push(node);
        vis[node] = true;
        for(int child: graph.get(node)){
            if(child!=parent) dfs(child,node);
        }
        if(list.size()>0) return;
        stack.pop();
    }
}


class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
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