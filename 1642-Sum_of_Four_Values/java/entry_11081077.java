//package SortingAndSearching;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class entry_11081077 {
  private static class Node {
    int start;
    int end;

    public Node(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) throws IOException {
    FastReader fastReader = new FastReader();
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int number = fastReader.nextInt();
    int target = fastReader.nextInt();

    int array[] = new int[number + 1];
    for (int index = 1; index <= number; index++) {
      array[index] = fastReader.nextInt();
    }

    Map<Integer, ArrayList<Node>> hashMap = new HashMap<>();
    for (int start = 1; start <= number; start++) {
      for (int end = start + 1; end <= number; end++) {
        int sum = array[start] + array[end];
        if (hashMap.containsKey(sum)) {
          hashMap.get(sum).add(new Node(start, end));
        } else {
          ArrayList<Node> nodeList = new ArrayList<>();
          nodeList.add(new Node(start, end));
          hashMap.put(sum, nodeList);
        }
      }
    }

    for (Integer proposedSum : hashMap.keySet()) {
      int requiredSum = target - proposedSum;
      if (hashMap.containsKey(requiredSum)) {
        int start = (requiredSum == proposedSum) ? 1 : 0;
        Node proposedNode = hashMap.get(proposedSum).get(0);

        List<Node> nodeList = hashMap.get(requiredSum);
        while (start < nodeList.size()) {
          Node requiredNode = nodeList.get(start++);
          if (proposedNode.start == requiredNode.start
              || proposedNode.start == requiredNode.end
              || proposedNode.end == requiredNode.start
              || proposedNode.end == requiredNode.end) {
            // It will not be distinct
            continue;
          }
          List<Integer> indices =
              Arrays.asList(
                  proposedNode.start, proposedNode.end, requiredNode.start, requiredNode.end);
          Collections.sort(indices);
          for (int index = 0; index < indices.size(); index++) {
            bufferedWriter.write(indices.get(index) + " ");
          }
          bufferedWriter.flush();
          return;
        }
      }
    }

    bufferedWriter.write("IMPOSSIBLE");
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