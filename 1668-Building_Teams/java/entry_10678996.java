//package GraphAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class entry_10678996 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    String dimension[] = bufferedReader.readLine().split(" ");
    int totalNodes = Integer.parseInt(dimension[0]);
    int totalRoute = Integer.parseInt(dimension[1]);

    List<Integer> graph[] = new ArrayList[totalNodes + 1];
    for (int index = 0; index <= totalNodes; index++) {
      graph[index] = new ArrayList<>();
    }

    for (int index = 0; index < totalRoute; index++) {
      String friendship[] = bufferedReader.readLine().split(" ");
      int node1 = Integer.parseInt(friendship[0]);
      int node2 = Integer.parseInt(friendship[1]);

      graph[node1].add(node2);
      graph[node2].add(node1);
    }

    int colour[] = new int[totalNodes + 1];
    Arrays.fill(colour, -1);

    boolean possible = true;
    for (int node = 1; node <= totalNodes && possible; node++) {
      if (colour[node] != -1) {
        continue; // Already coloured
      }

      colour[node] = 1;
      ArrayDeque<Integer> deque = new ArrayDeque<>();
      deque.add(node);

      while (!deque.isEmpty() && possible) {
        int people = deque.poll();

        for (Integer neighbour : graph[people]) {
          int requiredColour = (colour[people] == 1) ? 2 : 1;

          if (colour[neighbour] == -1) {
            colour[neighbour] = requiredColour;
            deque.add(neighbour);
          } else if (colour[neighbour] != requiredColour) {
            possible = false;
            break;
          }
        }
      }
    }

    if (possible) {
      for (int index = 1; index <= totalNodes; index++) {
        bufferedWriter.write(colour[index] + " ");
      }
    } else {
      bufferedWriter.write("IMPOSSIBLE");
    }

    bufferedWriter.flush();
  }
}