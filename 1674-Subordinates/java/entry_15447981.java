import java.io.*;
import java.util.*;
import java.math.*;

public class entry_15447981 {
    static int[] subs;
    static Edge[] es;
    static int[] head;
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        //BufferedReader r = new BufferedReader(new FileReader("time.in"));
        //PrintWriter pw = new PrintWriter(new FileWriter("time.out"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());

        es = new Edge[n - 1];
        head = new int[n];
        Arrays.fill(head, -1);

        st = new StringTokenizer(r.readLine());
        for(int i = 1; i < n; i++) {
            int a = Integer.parseInt(st.nextToken()) - 1;
            es[i - 1] = new Edge(i, head[a]);
            head[a] = i - 1;
        }

        subs = new int[n];
        dfs(0);

        pw.print(subs[0]);
        for(int i = 1; i < n; i++) {
            pw.print(' ');
            pw.print(subs[i]);
        }
        pw.println();

        pw.flush(); 
    }

    static void dfs(int index) {
        int[] stack = new int[head.length];
        int sp = 0;
        stack[sp++] = index;
        int[] order = new int[head.length];
        int o = 0;
        while(sp > 0) {
            int n = stack[--sp];
            order[o++] = n;
            for(int e = head[n]; e != -1; e = es[e].nxt) {
                stack[sp++] = es[e].to;
            }
        }

        for(int i = head.length - 1; i >= 0; i--) {
            int sum = 0;
            for(int e = head[order[i]]; e != -1; e= es[e].nxt) {
                sum += subs[es[e].to] + 1;
            }
            subs[order[i]] = sum;
        }
    }

    static class Edge {
        int to;
        int nxt;
        public Edge(int to, int nxt){
            this.to = to;
            this.nxt = nxt;
        }
    }



}