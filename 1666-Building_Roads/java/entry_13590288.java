import java.util.*;
import java.io.*;


public class entry_13590288 {
    public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);

      String[] readInput = reader.readLine().split(" ");
      int n = Integer.parseInt(readInput[0]);
      int m = Integer.parseInt(readInput[1]);

      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      for (int i = 0; i <= n; i++) {
        list.add(new ArrayList<Integer>());
      }

      for (int j = 0; j < m; j++) {
        String[] inputRead = reader.readLine().split(" ");
        int city1 = Integer.parseInt(inputRead[0]);
        int city2 = Integer.parseInt(inputRead[1]);
        list.get(city1).add(city2);
        list.get(city2).add(city1);
      }

      boolean[] visited = new boolean[n+1];

      int count = 0;
      ArrayList<Integer> storeRoads = new ArrayList<Integer>();
      for (int k = 1; k <= n; k++) {
        if (!visited[k]) {
          storeRoads.add(k);
          dfs(visited, list, k);
          count += 1;
        }
      }
      pw.println(count - 1);

      int index = 0;
      int minCount = 0;
      if (count- 1 != 0) {
        while (index < storeRoads.size()) {
          if (minCount != 1) {
            pw.print(storeRoads.get(index));
            pw.print(" ");
            minCount += 1;
            index += 1;
          }
          else {
            pw.println(storeRoads.get(index));
            minCount = 0;
            if (index == storeRoads.size() - 1) {
              break;
            }
          }

        }
      }



      pw.close();
  }
  public static void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> list, int k) {
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(k);
    while (!queue.isEmpty()) {
      int first = queue.poll();
      for (Integer neighbor : list.get(first)) {
        if (!visited[neighbor]) {
          queue.add(neighbor);
          visited[neighbor] = true;
        }
      }
    }
  }
}