import java.io.*;
import java.util.*;

public class entry_2699946 {
  static ArrayList<Integer>[] adj;
  static int[] counter; // goes from 0 to 2. 2 meaning cycle completed
  static int[] check; // checks where we came from.
  static ArrayList<Integer> answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    var st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    adj = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;
        adj[a].add(b);
        adj[b].add(a);
    }
    counter = new int[N];
    check = new int[N];
    for (int i = 0; i < N; i++) {
      check[i] = i;
    }
    for (int i = 0; i < N; i++) {
        if (counter[i] == 0) {
            dfs(i);
        }
    }
    if (answer == null) {
        out.println("IMPOSSIBLE");
    } else {
        out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            out.print(answer.get(i) + 1 + " ");
        }
    }
    out.close();
  }
  public static void dfs(int vertex) {
    if (answer != null)
        return;
    if (counter[vertex] == 0) {
        counter[vertex] = 1;
        for (int x : adj[vertex]) {
            if (check[vertex] != x) {
                check[x] = vertex;
                dfs(x);
            }
        }
    }   
    else if (counter[vertex] == 1) {
        answer = new ArrayList<>();
        var v = vertex;
        do {
            answer.add(v);
            v = check[v];
        } while (v != vertex);
        answer.add(vertex);
    } 
  }
}