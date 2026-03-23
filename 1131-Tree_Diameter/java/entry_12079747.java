import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_12079747 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(reader.readLine());
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int a = Integer.parseInt(tokenizer.nextToken());
      int b = Integer.parseInt(tokenizer.nextToken());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    int[] initFarthestNode = bfs(1, graph, n);
    int[] secondFarthestNode = bfs(initFarthestNode[0], graph, n);
    writer.write(Integer.toString(secondFarthestNode[1]));

    writer.flush();
    writer.close();
  }

  private static int[] bfs(int start, List<List<Integer>> graph, int n) {
    int[] distance = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      distance[i] = -1;
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    distance[start] = 0;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      for (int neighbor : graph.get(current)) {
        if (distance[neighbor] == -1) {
          distance[neighbor] = distance[current] + 1;
          queue.add(neighbor);
        }
      }
    }

    int maxDistance = -1;
    int farthest = start;
    for (int i = 1; i < n + 1; i++) {
      if (distance[i] > maxDistance) {
        maxDistance = distance[i];
        farthest = i;
      }
    }

    return new int[]{farthest, maxDistance};
  }
}