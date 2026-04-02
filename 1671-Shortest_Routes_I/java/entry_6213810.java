import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class entry_6213810 {

  private static FastReader reader = new FastReader(System.in);
  private static FastWriter writer = new FastWriter(System.out);

  private static final long LONG_INFINITY = Long.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    int numberOfCities = reader.nextInt();
    int numberOfConnections = reader.nextInt();
    List<Adjacency>[] adjacencyList = reader.nextDirectedAdjacencyList(numberOfCities, numberOfConnections);

    long[] distanceToSourceCity = new long[numberOfCities];
    for (int city = 0; city < numberOfCities; city++) {
      distanceToSourceCity[city] = LONG_INFINITY;
    }

    Queue<PriorityQueueItem<Integer>> queue = new PriorityQueue<>(
      numberOfCities,
      (item, otherItem) -> Long.compare(item.weight, otherItem.weight)
    );

    int sourceCity = 0;
    distanceToSourceCity[sourceCity] = 0;
    queue.add(new PriorityQueueItem<>(sourceCity, distanceToSourceCity[sourceCity]));

    while (!queue.isEmpty()) {
      PriorityQueueItem<Integer> item = queue.remove();
      int city = item.value;
      long distance = item.weight;

      if (distance > distanceToSourceCity[city]) {
        continue;
      }

      for (Adjacency adjacency : adjacencyList[city]) {
        int adjacentCity = adjacency.node;

        long connectionDistance = adjacency.weight;
        long newDistanceToSourceCity = distanceToSourceCity[city] + connectionDistance;

        if (newDistanceToSourceCity < distanceToSourceCity[adjacentCity]) {
          distanceToSourceCity[adjacentCity] = newDistanceToSourceCity;
          queue.add(new PriorityQueueItem<>(adjacentCity, newDistanceToSourceCity));
        }
      }
    }

    writer.writeJoinedArrayLine(distanceToSourceCity, " ");
    writer.flush();
  }

  public static class PriorityQueueItem<Value> {

    public final Value value;
    public final long weight;

    public PriorityQueueItem(Value value, long weight) {
      this.value = value;
      this.weight = weight;
    }
  }

  public static class FastReader {

    private BufferedReader input;
    private StringTokenizer lineTokenizer;

    public FastReader(InputStream inputStream) {
      input = new BufferedReader(new InputStreamReader(inputStream));
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(nextToken());
    }

    public long nextLong() throws IOException {
      return Long.parseLong(nextToken());
    }

    public String nextToken() throws IOException {
      if (lineTokenizer == null || !lineTokenizer.hasMoreTokens()) {
        lineTokenizer = new StringTokenizer(input.readLine());
      }
      return lineTokenizer.nextToken();
    }

    @SuppressWarnings("unchecked")
    public List<Adjacency>[] nextDirectedAdjacencyList(int numberOfNodes, int numberOfEdges) throws IOException {
      List<Adjacency>[] adjacencyList = new LinkedList[numberOfNodes];

      for (int node = 0; node < numberOfNodes; node++) {
        adjacencyList[node] = new LinkedList<>();
      }

      for (int edge = 0; edge < numberOfEdges; edge++) {
        int sourceNode = reader.nextInt() - 1;
        int targetNode = reader.nextInt() - 1;
        long weight = reader.nextLong();
        adjacencyList[sourceNode].add(new Adjacency(targetNode, weight));
      }

      return adjacencyList;
    }
  }

  public static class Adjacency {

    public final int node;
    public final long weight;

    public Adjacency(int node, long weight) {
      this.node = node;
      this.weight = weight;
    }
  }

  public static class FastWriter {

    private BufferedOutputStream output;

    public FastWriter(OutputStream outputStream) {
      output = new BufferedOutputStream(outputStream);
    }

    public void writeJoinedArrayLine(long[] array, String separator) throws IOException {
      StringJoiner joiner = new StringJoiner(separator);
      for (long value : array) {
        joiner.add(Long.toString(value));
      }
      writer.writeLine(joiner.toString());
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