//package GraphAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class entry_10675863 {
  public static int disjointSet[];

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    String dimension[] = bufferedReader.readLine().split(" ");
    int cities = Integer.parseInt(dimension[0]);
    int roads = Integer.parseInt(dimension[1]);

    disjointSet = new int[cities + 1];
    Arrays.fill(disjointSet, -1);
    for (int index = 0; index < roads; index++) {
      String road[] = bufferedReader.readLine().split(" ");
      int node1 = Integer.parseInt(road[0]);
      int node2 = Integer.parseInt(road[1]);

      unify(node1, node2);
    }

    List<Integer> rootCities = new ArrayList<>();
    for (int city = 1; city <= cities; city++) {
      if (disjointSet[city] < 0) rootCities.add(city);
    }

    bufferedWriter.write((rootCities.size() - 1) + "\n");
    for (int index = 1; index < rootCities.size(); index++) {
      bufferedWriter.write(rootCities.get(index - 1) + " " + rootCities.get(index) + "\n");
    }

    bufferedWriter.flush();
  }

  public static int findParent(int node) {
    if (disjointSet[node] < 0) {
      return node;
    } else {
      return findParent(disjointSet[node]);
    }
  }

  public static void unify(int node1, int node2) {
    int parent1 = findParent(node1);
    int parent2 = findParent(node2);

    if (parent1 != parent2) {
      if (disjointSet[parent1] < disjointSet[parent2]) {
        disjointSet[parent1] += disjointSet[parent2];
        disjointSet[parent2] = parent1;
      } else {
        disjointSet[parent2] += disjointSet[parent1];
        disjointSet[parent1] = parent2;
      }
    }
  }
}