import java.io.*;
import java.util.*;

public class entry_2831966 {
    static int na = 200003;
    static int[] hd = new int[na+1], nx = new int[na+1], to = new int[na+1], sol = new int[na+1];


    private static void insert(int num, int id) {
        nx[id] = hd[num];
        hd[num] = id;
        to[id] = id;
    }
    private static void dfs(int node) {
        sol[node] = 1;
        for(int i = hd[node]; i != 0; i = nx[i]) {
            dfs(to[i]);
            sol[node] += sol[to[i]];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 2; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            insert(num, i);
        }
        dfs(1);
        int count = 0;
//        System.out.println(Arrays.toString(sol));
        for(int i = 1; i <= n; i++) {
            if(sol[i] != 0) {
                out.print(sol[i]-1);
                if(i < n) out.print(" ");
                else out.println();
            }
        }
        out.close();
    }
}
