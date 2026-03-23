//package TreeAlgorithms;

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

public class entry_10921138 {
  public static void main(String[] args) throws IOException {
    FastReader fastReader = new FastReader();
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int numNodes = fastReader.nextInt();
    List<Integer> tree[] = new ArrayList[numNodes + 1];
    for (int index = 1; index <= numNodes; index++) {
      tree[index] = new ArrayList<>();
    }

    for (int index = 1; index < numNodes; index++) {
      int node1 = fastReader.nextInt();
      int node2 = fastReader.nextInt();

      tree[node1].add(node2);
      tree[node2].add(node1);
    }

    Queue<Integer> bfsQueue = new LinkedList<>();
    bfsQueue.add(1);

    int answer = -1;
    int northPole = 1;

    boolean visited[] = new boolean[numNodes + 1];
    while (!bfsQueue.isEmpty()) {
      answer += 1;
      northPole = bfsQueue.peek();

      int length = bfsQueue.size();
      for (int index = 1; index <= length; index++) {
        int node = bfsQueue.poll();
        visited[node] = true;

        for (Integer neighbour : tree[node]) {
          if (!visited[neighbour]) {
            bfsQueue.add(neighbour);
          }
        }
      }
    }

    answer = -1;
    bfsQueue = new LinkedList<>();
    bfsQueue.add(northPole);
    visited = new boolean[numNodes + 1];
    while (!bfsQueue.isEmpty()) {
      answer += 1;

      int length = bfsQueue.size();
      for (int index = 1; index <= length; index++) {
        int node = bfsQueue.poll();
        visited[node] = true;

        for (Integer neighbour : tree[node]) {
          if (!visited[neighbour]) {
            bfsQueue.add(neighbour);
          }
        }
      }
    }

    bufferedWriter.write(answer + "\n");
    bufferedWriter.flush();
  }

  private static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        if (st.hasMoreTokens()) {
          str = st.nextToken("\n");
        } else {
          str = br.readLine();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}