import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class entry_9257914 {
  public static void main(String[] args) throws IOException {
    FastReader fastReader = new FastReader();
    PrintWriter printWriter = new PrintWriter(System.out);

    int cityCount = fastReader.nextInt();
    int roadCount = fastReader.nextInt();

    List<List<Integer>> graphAdjList =
        IntStream.range(0, cityCount)
            .mapToObj(i -> new ArrayList<Integer>())
            .collect(Collectors.toCollection(ArrayList::new));

    for (int i = 0; i < roadCount; i++) {
      int cityA = fastReader.nextInt() - 1;
      int cityB = fastReader.nextInt() - 1;

      graphAdjList.get(cityA).add(cityB);
      graphAdjList.get(cityB).add(cityA);
    }

    DFSUtil dfsUtil = new DFSUtil(graphAdjList);
    if (!dfsUtil.hasCycle()) {
      printWriter.println("IMPOSSIBLE");
    } else {
      List<Integer> cycleVertices = dfsUtil.getCycle();
      StringBuilder resultStringBuilder = new StringBuilder();
      resultStringBuilder.append(cycleVertices.size()).append("\n");

      for (int cycleVertex : cycleVertices) {
        resultStringBuilder.append(cycleVertex + 1).append(" ");
      }
      printWriter.println(resultStringBuilder.toString().trim());
    }
    printWriter.close();
  }

  static class DFSUtil {
    private List<List<Integer>> graphAdjList;

    private enum DFSState {
      NOT_TRAVERSED,
      TRAVERSING,
      TRAVERSED
    }

    private final List<DFSState> dfsStates;
    private final List<Integer> parents;
    private boolean hasCycle;
    private int startCycle;
    private int endCycle;

    public List<Integer> getParents() {
      return parents;
    }

    private void setParent(int index, int value) {
      this.parents.set(index, value);
    }

    private void setHasCycle(boolean hasCycle) {
      this.hasCycle = hasCycle;
    }

    public void setStartCycle(int startCycle) {
      this.startCycle = startCycle;
    }

    public void setEndCycle(int endCycle) {
      this.endCycle = endCycle;
    }

    public DFSUtil(List<List<Integer>> graphAdjList) {
      this.graphAdjList = graphAdjList;
      this.hasCycle = false;
      this.parents = new ArrayList<>(Collections.nCopies(graphAdjList.size(), -1));
      this.dfsStates =
          new ArrayList<>(Collections.nCopies(graphAdjList.size(), DFSState.NOT_TRAVERSED));
      this.startCycle = -1;
      this.endCycle = -1;

      this.doDFS();
    }

    private void doDFS() {
      for (int i = 0; i < graphAdjList.size(); i++) {
        if (dfsStates.get(i) == DFSState.NOT_TRAVERSED) {
          doDFSNode(i);
        }
      }
    }

    private void doDFSNode(int vertex) {
      dfsStates.set(vertex, DFSState.TRAVERSING);
      for (int adjVertex : graphAdjList.get(vertex)) {
        if (dfsStates.get(adjVertex) == DFSState.NOT_TRAVERSED) {
          this.setParent(adjVertex, vertex);
          doDFSNode(adjVertex);
        } else if (this.getParents().get(vertex) != adjVertex) {
          this.setHasCycle(true);
          this.setEndCycle(vertex);
          this.setStartCycle(adjVertex);
        }
      }
      dfsStates.set(vertex, DFSState.TRAVERSED);
    }

    public boolean hasCycle() {
      return this.hasCycle;
    }

    public List<Integer> getCycle() {
      List<Integer> cycleVertices = new ArrayList<>();
      if (!this.hasCycle()) {
        return cycleVertices;
      }

      int currentVertex = startCycle;
      cycleVertices.add(endCycle);
      cycleVertices.add(currentVertex);
      do {
        currentVertex = parents.get(currentVertex);
        cycleVertices.add(currentVertex);
      } while (currentVertex != endCycle);

      return cycleVertices;
    }
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(in));
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
      return parseInt(next());
    }

    long nextLong() {
      return parseLong(next());
    }

    double nextDouble() {
      return parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }
}