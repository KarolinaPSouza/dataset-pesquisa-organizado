import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_710463 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sc.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        sc.lines().forEach((String line) -> {
            final StringTokenizer tokenizer = new StringTokenizer(line);
            int c1 = Integer.parseInt(tokenizer.nextToken())-1;
            int c2 = Integer.parseInt(tokenizer.nextToken())-1;
            adjList.get(c1).add(c2);
            adjList.get(c2).add(c1);
        });

        boolean[] vis = new boolean[n];
        ArrayList<Integer> heads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                heads.add(i+1);
                Stack<Integer> queue = new Stack<>();
                queue.add(i);
                while(!queue.isEmpty()) {
                    int pos = queue.pop();
                    if (vis[pos]) continue;
                    vis[pos] = true;
                    queue.addAll(adjList.get(pos));
                }
            }
        }
        System.out.println(heads.size()-1);
        for (int i = 1; i < heads.size(); i++) {
            System.out.println(heads.get(i) + " " + heads.get(i-1));
        }
    }
}