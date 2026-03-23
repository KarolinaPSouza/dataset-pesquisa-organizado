import java.util.*;
import java.io.*;
public class entry_3667084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q=  new LinkedList<Integer>();
        int d = 0;
        int last = 0;
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()){
            int size = q.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                int get = q.remove();
                for (int a : adj[get]) {
                    if (!vis[a]) {
                        count++;
                        vis[a] = true;
                        q.add(a);
                        last = a;
                    }
                }
            }
            if(count > 0) {
                d++;
            }
        }
        d = 0;
        q.add(last);
        vis = new boolean[n];
        vis[last] = true;
        while (!q.isEmpty()){
            int size = q.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                int get = q.remove();
                for (int a : adj[get]) {
                    if (!vis[a]) {
                        count++;
                        vis[a] = true;
                        q.add(a);
                    }
                }
            }
            if(count > 0) {
                d++;
            }
        }
        System.out.println(d);
    }
}