import java.io.*;
import java.util.*;
public class entry_6178248 {
    static ArrayList<Integer>[] connections;
    static boolean visited[];
    static int[] parent;
    static ArrayDeque<Integer> next;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        connections = new ArrayList[n];
        next = new ArrayDeque<>();
        parent = new int[n];
        Arrays.fill(parent,-1);
        for(int i=0;i<n;i++) connections[i] = new ArrayList<>();
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            connections[a].add(b);
            connections[b].add(a);
        }
        next.add(0);
        visited[0] = true;
        bfs(n-1);
        if(parent[n-1]==-1) System.out.println("IMPOSSIBLE");
        else {
            Stack<Integer> ans = new Stack<>();
            StringBuilder sb = new StringBuilder();
            ans.add(n);
            int val = n-1;
            while(parent[val]!=-1) {
                ans.add(parent[val]+1);
                val = parent[val];
            }
            System.out.println(ans.size());
            while(!ans.isEmpty()) {
                sb.append(ans.pop()).append(" ");
            }
            System.out.println(sb);
        }
    }
    public static void bfs(int find) {
        if(next.isEmpty() || find==next.peekFirst()) return;
        int idx = next.pollFirst();
        for(int i=0;i<connections[idx].size();i++) {
            int check = connections[idx].get(i);
            if(!visited[check]) {
                visited[check] = true;
                next.addLast(check);
                parent[check] = idx;
            }
        }
        bfs(find);
    }
}