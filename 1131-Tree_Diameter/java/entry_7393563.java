import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class entry_7393563 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        boolean[] visited = new boolean[n];
        List<Integer>[] adjs = new ArrayList[n];
        String[] words;
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        for(int i=0; i<n-1; i++) {
            words = reader.readLine().split(" ");
            int a=Integer.parseInt(words[0])-1, b=Integer.parseInt(words[1])-1;
            adjs[a].add(b);
            adjs[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int last = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int curr = q.poll();
                visited[curr] = true;
                for(int next: adjs[curr]) {
                    if(!visited[next]) {
                        q.offer(next);
                        last = next;
                    }
                }
            }
        }
        visited = new boolean[n];
        q.offer(last);
        int dist = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int curr = q.poll();
                visited[curr] = true;
                for(int next: adjs[curr]) {
                    if(!visited[next]) {
                        q.offer(next);
                    }
                }
            }
            dist++;
        }
        System.out.println(dist-1);
    }
}