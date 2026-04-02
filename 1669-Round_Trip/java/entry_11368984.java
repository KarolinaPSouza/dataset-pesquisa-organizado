
/**
* @author E-Sir
*
*/

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class entry_11368984 {
    static final int MOD = 1_000_000_007;
    static List<Integer>[] adj;
    static int[] parent;
    static int[] color;
    static int start,end;
    static int N,M;

    static int readInt(String s){return Integer.parseInt(s);}
    static long readLong(String s){return Long.parseLong(s);}
    static int[] readIntArr(String s){
        String[] tk = s.split(" ");
        int n = tk.length;
        int[] res = new int[n];
        for(int i =0;i<n;i++)
            res[i] = readInt(tk[i]);
        return res;
    }
    static long[] readLongArr(String s){
        String[] tk = s.split(" ");
        int n = tk.length;
        long[] res = new long[n];
        for(int i =0;i<n;i++){
            res[i] = Long.parseLong(tk[i]);
        }
        return res;
    }

    static <T extends Comparable<T>> T max(T a, T b){
        return a.compareTo(b) > 0 ? a : b;
    }

    static <T extends Comparable<T>> T min(T a, T b){
        return a.compareTo(b) < 0 ? a : b;
    }
    static int abs(int a, int b){return Math.abs(a-b);}
    static long abs(long a, long b){return Math.abs(a-b);}
    static class Pair<E,T>{
        E val1;
        T val2;
        public Pair(E val1, T val2){
            this.val1 = val1;
            this.val2 = val2;
        }
    }
    static boolean dfs(int v){
        color[v] = 1;
        for(int u : adj[v]){
            if(color[u] == 0){
                parent[u]=v;
                if(dfs(u))
                    return true;

            }
            else if(color[u] == 2){
                start = v;
                end = u;
                return true;
            }
        }
        color[v]=2;
        return false;
    }

    public static void solve() throws IOException{
        PrintWriter pw = new PrintWriter(System.out);
        StringBuilder st = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = readIntArr(br.readLine());
        N = nm[0]; M =nm[1];
        adj = new ArrayList[N+1];
        parent = new int[N+1];
        color = new int[N+1];
        start = -1;
        end = -1;

        for(int i =1;i<N+1;i++)adj[i]=new ArrayList<>();
        for(int i =0;i<M;i++){
            int[] ab = readIntArr(br.readLine());
            int a = ab[0], b= ab[1];
            adj[a].add(b);adj[b].add(a);
        }
        for(int i =1;i<N+1;i++){
            if(color[i] == 0 && dfs(i)) break;
        }
        if(start == -1)st.append("IMPOSSIBLE\n");
        else{
            List<Integer> res = new ArrayList<>();
            res.add(start);
            for(int v = end;v != start;v = parent[v])res.add(v);
            res.add(start);
            Collections.reverse(res);
            st.append(res.size()).append('\n');
            for(int a : res)st.append(a).append(" ");
        }




        pw.println(st);
        pw.flush();
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}