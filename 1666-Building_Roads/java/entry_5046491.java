import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class entry_5046491 {
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cities = Integer.parseInt(st.nextToken());
        arr = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i<cities; i++) arr.add(new ArrayList<Integer>());
        int roads = Integer.parseInt(st.nextToken());
        for(int i = 0; i<roads; i++) {
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken()) - 1;
            int city2 = Integer.parseInt(st.nextToken()) - 1;
            arr.get(city1).add(city2);
            arr.get(city2).add(city1);
        }
        visited = new boolean[cities];
        visited[0] = true;
        dfs(0);
        StringBuilder sb = new StringBuilder("");
        int count = 0;
        for(int i = 0; i<cities; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
                count++;
                sb.append("1 " + (i+1)+"\n");
            }
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
    public static void dfs(int root) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addAll(arr.get(root));
        while(!deque.isEmpty()) {
            int city = deque.poll();
            if(!visited[city]) {
                visited[city] = true;
                deque.addAll(arr.get(city));
            }
        }
    }
}