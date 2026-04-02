import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class entry_6206030 {

  private static FastReader reader = new FastReader(System.in);
  private static FastWriter writer = new FastWriter(System.out);

  public static void main(String[] args) throws IOException {
    int numberOfComputers = reader.nextInt();
    int numberOfConnections = reader.nextInt();

    List<Integer>[] adjacencyList = reader.nextUndirectedAdjacencyList(numberOfComputers, numberOfConnections);

    boolean[] isVisited = new boolean[numberOfComputers];
    int[] distanceToSourceComputer = new int[numberOfComputers];
    int[] previousComputer = new int[numberOfComputers];
    LinkedList<Integer> queue = new LinkedList<>();

    for (int computer = 0; computer < numberOfComputers; computer++) {
      distanceToSourceComputer[computer] = -1;
      previousComputer[computer] = -1;
    }

    int sourceComputer = 0;
    int targetComputer = numberOfComputers - 1;

    distanceToSourceComputer[sourceComputer] = 0;
    isVisited[sourceComputer] = true;
    queue.addLast(sourceComputer);

    while (!queue.isEmpty()) {
      int computer = queue.removeFirst();

      for (int adjacentComputer : adjacencyList[computer]) {
        if (isVisited[adjacentComputer]) {
          continue;
        }
        isVisited[adjacentComputer] = true;
        distanceToSourceComputer[adjacentComputer] = distanceToSourceComputer[computer] + 1;
        previousComputer[adjacentComputer] = computer;
        queue.addLast(adjacentComputer);
      }
    }

    boolean solutionExists = distanceToSourceComputer[targetComputer] != -1;

    if (!solutionExists) {
      writer.writeLine("IMPOSSIBLE");
      writer.flush();
      return;
    }

    int numberOfComputersInPath = distanceToSourceComputer[targetComputer] + 1;
    writer.writeLine(numberOfComputersInPath);

    String[] computersInPath = new String[numberOfComputersInPath];

    int computer = targetComputer;
    for (int index = numberOfComputersInPath - 1; index >= 0; index--) {
      computersInPath[index] = Integer.toString(computer + 1);
      computer = previousComputer[computer];
    }

    writer.writeLine(String.join(" ", computersInPath));
    writer.flush();
  }

  public static class FastReader {

    private BufferedReader input;
    private StringTokenizer lineTokenizer;

    public FastReader(InputStream inputStream) {
      input = new BufferedReader(new InputStreamReader(inputStream));
    }

    public int nextInt() throws IOException {
      if (lineTokenizer == null || !lineTokenizer.hasMoreTokens()) {
        lineTokenizer = new StringTokenizer(input.readLine());
      }
      return Integer.parseInt(lineTokenizer.nextToken());
    }

    @SuppressWarnings("unchecked")
    public List<Integer>[] nextUndirectedAdjacencyList(int numberOfNodes, int numberOfEdges) throws IOException {
      List<Integer>[] adjacencyList = new LinkedList[numberOfNodes];

      for (int node = 0; node < numberOfNodes; node++) {
        adjacencyList[node] = new LinkedList<>();
      }

      for (int edge = 0; edge < numberOfEdges; edge++) {
        int sourceNode = reader.nextInt() - 1;
        int targetNode = reader.nextInt() - 1;
        adjacencyList[sourceNode].add(targetNode);
        adjacencyList[targetNode].add(sourceNode);
      }

      return adjacencyList;
    }
  }

  public static class FastWriter {

    private BufferedOutputStream output;

    public FastWriter(OutputStream outputStream) {
      output = new BufferedOutputStream(outputStream);
    }

    public void writeLine(int value) throws IOException {
      writeLine(Integer.toString(value));
    }

    public void writeLine(String value) throws IOException {
      write(value + "\n");
    }

    private void write(String value) throws IOException {
      output.write(value.getBytes());
    }

    public void flush() throws IOException {
      output.flush();
    }
  }
}