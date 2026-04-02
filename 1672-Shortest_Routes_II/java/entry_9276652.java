import java.io.*;
import java.util.*;

public class entry_9276652 {

  public static void main(String[] args) throws IOException {
    FastReader fastReader = new FastReader(System.in);
    PrintWriter printWriter =
        new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int vertexCount = fastReader.nextInt();
    int edgeCount = fastReader.nextInt();
    int queryCount = fastReader.nextInt();

    Graph graph = new Graph(vertexCount);
    for (int i = 0; i < edgeCount; i++) {
      int cityA = fastReader.nextInt() - 1;
      int cityB = fastReader.nextInt() - 1;
      int distance = fastReader.nextInt();

      graph.addEdge(cityA, cityB, distance);
    }
    graph.computeAllPairShortestPaths();

    StringBuilder resultStringBuilder = new StringBuilder();
    for (int i = 0; i < queryCount; i++) {
      int cityA = fastReader.nextInt() - 1;
      int cityB = fastReader.nextInt() - 1;
      resultStringBuilder
          .append(
              (graph.getShortestDistance(cityA, cityB) == Long.MAX_VALUE
                  ? -1
                  : graph.getShortestDistance(cityA, cityB)))
          .append("\n");
    }
    printWriter.println(resultStringBuilder.toString().trim());
    printWriter.close();
  }

  private static class Graph {
    long[][] graphAdjMatrix;

    public Graph(int vertexCount) {
      this.graphAdjMatrix = new long[vertexCount][vertexCount];
      for (int i = 0; i < vertexCount; i++) {
        Arrays.fill(this.graphAdjMatrix[i], Long.MAX_VALUE);
        this.graphAdjMatrix[i][i] = 0L;
      }
    }

    public void addEdge(int vertexA, int vertexB, long distance) {
      this.graphAdjMatrix[vertexA][vertexB] =
          Long.min(this.graphAdjMatrix[vertexA][vertexB], distance);
      this.graphAdjMatrix[vertexB][vertexA] =
          Long.min(this.graphAdjMatrix[vertexB][vertexA], distance);
    }

    public void computeAllPairShortestPaths() {
      for (int k = 0; k < this.graphAdjMatrix.length; k++) {
        for (int i = 0; i < this.graphAdjMatrix.length; i++)
          if (this.graphAdjMatrix[i][k] != Long.MAX_VALUE) {
            for (int j = 0; j < this.graphAdjMatrix.length; j++)
              if (this.graphAdjMatrix[k][j] != Long.MAX_VALUE) {
                this.graphAdjMatrix[i][j] =
                    Long.min(
                        this.graphAdjMatrix[i][j],
                        this.graphAdjMatrix[i][k] + this.graphAdjMatrix[k][j]);
              }
          }
      }
    }

    public long getShortestDistance(int cityA, int cityB) {
      return this.graphAdjMatrix[cityA][cityB];
    }
  }

  static class FastReader {
    InputStream is;

    FastReader(InputStream is) {
      this.is = is;
    }

    byte[] bb = new byte[1 << 15];
    int k, l;

    byte getc() throws IOException {
      if (k >= l) {
        k = 0;
        l = is.read(bb);
        if (l < 0) return -1;
      }
      return bb[k++];
    }

    byte skip() throws IOException {
      byte b;
      while ((b = getc()) <= 32)
        ;
      return b;
    }

    int nextInt() throws IOException {
      int n = 0;
      for (byte b = skip(); b > 32; b = getc()) n = n * 10 + b - '0';
      return n;
    }
  }
}