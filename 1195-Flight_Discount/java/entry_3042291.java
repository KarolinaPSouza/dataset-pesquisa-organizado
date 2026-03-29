//package entry_3042291;
import java.io.*;
import java.util.*;


public class entry_3042291 {

 static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }


 static class Edge {
  int destination;
  int weight;

  public Edge(int d, int w) {
   this.destination = d;
   this.weight = w;
  }
 }

 static class Graph {
  int vertices;
  LinkedList<Edge> [] adjacencyList;

  @SuppressWarnings("unchecked")
  Graph(int vertices) {
   this.vertices = vertices;
   adjacencyList = new LinkedList[vertices + 1];
   for(int i = 0; i <= vertices; ++i)
    adjacencyList[i] = new LinkedList<Edge>();
  }

  public void addEdge(int source, int destination, int weight) {
   Edge e = new Edge(destination, weight);
   adjacencyList[source].add(e);
  }

 }

 static class Node implements Comparable<Node> {
  int node;
  long cost;
  int discount;

  Node(int node, long cost, int discount) {
   this.node = node;
   this.cost = cost;
   this.discount = discount;
  }

  public int compareTo(Node n1) {
   if(this.cost < n1.cost)
    return -1;
   else if(this.cost > n1.cost)
    return 1;
   return 0;
  }
 }

 public static void main(String []args) throws IOException {
  Reader br = new Reader();
  int n = br.nextInt();
  int m = br.nextInt();

  Graph graph = new Graph(n);
  for(int i = 0; i < m; ++i)
   graph.addEdge(br.nextInt(), br.nextInt(),br.nextInt());

  long dist[][] = new long[2][n + 1];
  boolean visited[][] = new boolean[2][n + 1];

  Arrays.fill(dist[0], Long.MAX_VALUE);
  Arrays.fill(dist[1], Long.MAX_VALUE);

  PriorityQueue<Node> pq = new PriorityQueue<Node>();
  pq.add(new Node(1, 0, 0));

  while(!pq.isEmpty()) {
   Node curr_node = pq.poll();
   if(visited[curr_node.discount][curr_node.node] == true)
    continue;
   visited[curr_node.discount][curr_node.node] = true;
   if(curr_node.node == n && curr_node.discount == 1) {
    System.out.println(curr_node.cost);
    return;
   }

   List<Edge> list = graph.adjacencyList[curr_node.node];

   for(Edge edge : list) {
    if(dist[curr_node.discount][edge.destination] > curr_node.cost + edge.weight) {
     dist[curr_node.discount][edge.destination] = curr_node.cost + edge.weight;
     pq.add(new Node(edge.destination, dist[curr_node.discount][edge.destination], curr_node.discount));
    }

    if(curr_node.discount == 0) {
     if(dist[1][edge.destination] > curr_node.cost + edge.weight/2) {
      dist[1][edge.destination] = curr_node.cost + edge.weight/2;
      pq.add(new Node(edge.destination, dist[1][edge.destination], 1));
     }
    }
   }
  }
 }
}