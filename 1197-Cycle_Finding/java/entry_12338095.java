import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class entry_12338095 {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;



    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        // br = new BufferedReader(new FileReader("in.txt"));
        // out = new PrintWriter(new FileWriter("out.txt"));

        int t = 1;
        // t = readInt();
        while(t-- > 0){
            solve();
        }

        out.close();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
        st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }


    // Solution Method

    public  static void solve() throws IOException{
        int n,m;
        n = readInt();
        m = readInt();

        int edges[][] = new int[m][3];
        for(int i = 0; i < m;i++){
            edges[i][0] = readInt();
            edges[i][1] = readInt();
            edges[i][2] = readInt();
        }

        int[] cameFrom = new int[n+1];

        long[] dist = new long[n+1];
        Arrays.fill(dist,0);
        // for instance runing bellman ford from node 1.
        // if there is a cycle then it will obviously be found in Bellman Ford.
        for(int i = 0 ; i < n ; i++){
            for(var j:edges){
                if(dist[j[0]] == Long.MAX_VALUE) continue;
                long relax = dist[j[0]] + j[2]; // 1...i[0] + i[0]...i[1]
                if(dist[j[1]] > relax){
                    dist[j[1]] = relax;
                    cameFrom[j[1]] = j[0];
                    if(i == n-1){
                        int loopStartsAt = j[0];
                        for(int z = 0 ; z < n ; z++) loopStartsAt = cameFrom[loopStartsAt];
                        j[0] = loopStartsAt;
                        StringBuilder res = new StringBuilder();
                        do{
                            res.append(new StringBuilder(loopStartsAt+"").reverse()).append(" ");
                            loopStartsAt = cameFrom[loopStartsAt];
                        }while(loopStartsAt != j[0]);
                        res.append(new StringBuilder(j[0]+"").reverse());
                        res.reverse();
                        out.println("YES");
                        out.print(res);
                        return;
                    }
                }
            }
        }

        out.println("NO");
    }


    public static int[] getParent(int[][] edges,int n){
        int parent[] = new int[n+1];
        int rank[] = new int[n+1];
        for(int i = 1 ; i<= n ;i++) parent[i] = i;

        for(var i:edges){
            int p1 = FUP(i[0],parent);
            int p2 = FUP(i[1],parent);
            if(p1 == p2) continue;
            union(p1,p2,parent,rank);
        }

        return parent;
    }

    public static int FUP(int node,int[] parent){
        if(node == parent[node]) return node;
        return parent[node] = FUP(parent[node],parent);
    }

    public static void union(int parentA,int parentB,int[] parent,int[] rank){
        if(rank[parentA] > rank[parentB]){
            parent[parentB] = parentA;
        }else{
            parent[parentA] = parentB;
            rank[parentA] = Math.max(rank[parentA] , rank[parentB] + 1);
        }
    }
}