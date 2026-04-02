import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class entry_2078570 {
    private static List<Integer> list[];
    private static boolean visited[];
    private static int count = 0;
    private static ArrayList<Integer> nodes = new ArrayList();
    public static void main(String args[]) {    
        FastReader input = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = input.nextInt();
        int m = input.nextInt();
        list = new LinkedList[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) list[i] = new LinkedList();
        for(int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        cc(1);
        out.println(count - 1);
        for(int i = 0; i < nodes.size() - 1; i++) {
            out.println(nodes.get(i)+" "+nodes.get(i+1));
        }
        out.flush();
    }
    public static void dfs(int source) {
        visited[source] = true;
        for(int i = 0; i < list[source].size(); i++) {
            int child = list[source].get(i);
            if(!visited[child]) {
                dfs(child);
            }
        }
    }
    public static void cc(int source) {
        for(int i = 1; i < list.length; i++) {
            if(!visited[i]) {
                dfs(i);
                nodes.add(i);
                count++;
            }
        }
    }
}

class Pair implements Comparable<Pair> {    
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int first() {
        return x;
    }
    public int second() {
        return y;
    }

    public int compareTo(Pair p) {
        if(this.first() == p.first()) {
            return 0;
        }else if(this.first() > p.first()) {
            return 1;
        }else {
            return -1;
        }
    } 
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    public String next() {
        while(st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }catch(Exception e) {
                System.out.println(e);
            }
        }     
        return st.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public String getString() {
        return next();
    }
}