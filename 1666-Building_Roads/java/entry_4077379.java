import java.io.*;
import java.util.*;


public class entry_4077379 {
    public static ArrayList<Integer> cities[];
    public static Boolean[] visited;
    public static ArrayList<Integer> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer l1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int m = Integer.parseInt(l1.nextToken());

        cities = new ArrayList[n+1];
        visited = new Boolean[n+1];
        for (int i=0; i<=n; i++) {
            visited[i] = false;
        }

        for (int i=0; i<=n; i++) cities[i] = new ArrayList<>();

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            cities[c1].add(c2);
            cities[c2].add(c1);
        }
        int res = count_components();
        System.out.println(res-1);
        for (int i=1; i<res; i++) {
            System.out.println(stack.get(i-1) + " " + stack.get(i));
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : cities[node]) {
            if(!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static int count_components() {
        int cnt = 0;
        for (int i=1; i<=cities.length-1; i++) {
            if(!visited[i]) {
                cnt++;
                stack.add(i);
                dfs(i);
            }
        }
        return cnt;
    }
}