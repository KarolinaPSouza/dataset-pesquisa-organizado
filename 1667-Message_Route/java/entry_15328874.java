import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.StringTokenizer;

public class entry_15328874 {
  private static final Random RANDOM = new Random();
  private static final int MOD = 1000_000_000 + 7;


  private void solve(FastScanner fastScanner, PrintWriter writer) {
    int n = fastScanner.nextInt();
    int m = fastScanner.nextInt();
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int start = fastScanner.nextInt();
      int end = fastScanner.nextInt();
      graph.get(start - 1).add(end - 1);
      graph.get(end - 1).add(start - 1);
    }
    int[] distance = new int[n];
    int[] parent = new int[n];
    boolean[] visited = new boolean[n];
    Arrays.fill(distance, Integer.MAX_VALUE);
    Arrays.fill(parent, -1);
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    visited[0] = true;
    distance[0] = 0;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int adjacentNode : graph.get(node)) {
        if (visited[adjacentNode]) {
          continue;
        }
        visited[adjacentNode] = true;
        parent[adjacentNode] = node;
        distance[adjacentNode] = distance[node] + 1;
        queue.add(adjacentNode);
      }
    }
    if (parent[n - 1] == -1) {
      writer.println("IMPOSSIBLE");
      return;
    }
    writer.println(distance[n - 1] + 1);
    List<Integer> ans = new ArrayList<>();
    int node = n - 1;
    while (node != -1) {
      ans.add(node + 1);
      node = parent[node];
    }
    Collections.reverse(ans);
    for (int i : ans) {
      writer.print(i + " ");
    }
  }

  public static void main(String[] args) {
    FastScanner fastScanner = new FastScanner();
    PrintWriter writer = new PrintWriter(System.out);
    new entry_15328874().solve(fastScanner, writer);
    writer.flush();
    writer.close();
  }

  private static int powerMod(int x, int m, int MOD) {
    if (m == 1) {
      return (x + MOD) % MOD;
    } else if (m == 0) {
      return 1;
    }
    int recurse = powerMod(x, m / 2, MOD);
    int half = (int) (((long) recurse * (long) recurse) % (long) MOD);
    if ((m & 1) == 0) {
      return half;
    }
    return (int) (((long) half * (long) x) % (long) MOD);
  }

  private static void shuffleArray(int[] array) {
    int index, temp;
    for (int i = array.length - 1; i > 0; i--) {
      index = RANDOM.nextInt(i + 1);
      temp = array[index];
      array[index] = array[i];
      array[i] = temp;
    }
  }

  private static class FastScanner {
    private final BufferedReader bufferedReader;
    private StringTokenizer stringTokenizer = new StringTokenizer("");

    public FastScanner() {
      this(false);
    }

    public FastScanner(boolean file) {
      if (!file) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return;
      }
      try {
        bufferedReader = new BufferedReader(new FileReader("test_input.txt"));
      } catch (FileNotFoundException e) {
        throw new RuntimeException("test_input.txt file not found", e);
      }
    }

    public String next() {
      while (!stringTokenizer.hasMoreTokens())
        try {
          stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      return stringTokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public int[] readArray(int n) {
      int[] a = new int[n];
      for (int i = 0; i < n; i++) a[i] = nextInt();
      return a;
    }

    public long nextLong() {
      return Long.parseLong(next());
    }
  }
}