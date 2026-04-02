import java.io.*;
import java.util.*;
public class entry_15691887 {
    static PrintWriter pw;
    static BufferedReader r;
    static StringTokenizer st;

    static boolean[] visited;
    static List<Integer>[] roads;
    public static void main(String[] args) throws IOException {
        r = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        solve();
        pw.close();
        r.close();
    }
    static void solve() throws IOException {
        st = new StringTokenizer(r.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        roads=new ArrayList[n];
        for (int i=0; i<n; i++) {
            roads[i]=new ArrayList<Integer>();
        }
        visited=new boolean[n];
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(r.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            roads[a].add(b);
            roads[b].add(a);
        } 
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i);
                points.add(i);
            }
        }
        pw.println(points.size()-1);
        for (int i=0; i<points.size()-1; i++) {
            pw.println(points.get(i)+1+" "+(points.get(i+1)+1));
        }
    }
    static void dfs(int a) {
        if (visited[a]) return;
        visited[a]=true;
        for (int city:roads[a]) {
            dfs(city);
        }
    }
}