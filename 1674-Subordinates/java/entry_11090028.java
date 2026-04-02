//package TreeAlgorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_11090028 {
  public static void main(String[] args) throws IOException {
    FastReader fastReader = new FastReader();
    int numEmployee = fastReader.nextInt();

    List<Integer> tree[] = new ArrayList[numEmployee + 1];
    for (int index = 1; index <= numEmployee; index++) {
      tree[index] = new ArrayList<>();
    }

    int inDegree[] = new int[numEmployee + 1];
    for (int index = 2; index <= numEmployee; index++) {
      int reporter = fastReader.nextInt();
      tree[index].add(reporter);
      inDegree[reporter] += 1;
    }

    int subordinates[] = new int[numEmployee + 1];

    Queue<Integer> queue = new ArrayDeque<>();
    for (int index = 1; index <= numEmployee; index++) {
      if (inDegree[index] == 0) queue.add(index);
    }

    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (Integer neighbour: tree[node]) {
        inDegree[neighbour] -= 1;
        subordinates[neighbour] += subordinates[node] + 1;

        if (inDegree[neighbour] == 0) queue.add(neighbour);
      }
    }

    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int index = 1; index <= numEmployee; index++) {
      bufferedWriter.write(subordinates[index] + " ");
    }

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