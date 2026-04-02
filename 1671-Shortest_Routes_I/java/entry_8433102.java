import java.util.*;
import java.math.BigInteger;
/** Simple yet moderately fast I/O routines.
 *
 * Example usage:
 *
 * Kattio io = new Kattio(System.in, System.out);
 *
 * while (io.hasMoreTokens()) {
 *    int n = io.getInt();
 *    double d = io.getDouble();
 *    double ans = d*n;
 *
 *    io.println("Answer: " + ans);
 * }
 *
 * io.close();
 *
 *
 * Some notes:
 *
 * - When done, you should always do io.close() or io.flush() on the
 *   Kattio-instance, otherwise, you may lose output.
 *
 * - The getInt(), getDouble(), and getLong() methods will throw an
 *   exception if there is no more data in the input, so it is generally
 *   a good idea to use hasMoreTokens() to check for end-of-file.
 *
 * @author: Kattis
 */

import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
 super(new BufferedOutputStream(System.out));
 r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
 super(new BufferedOutputStream(o));
 r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
 return peekToken() != null;
    }

    public int getInt() {
 return Integer.parseInt(nextToken());
    }

    public double getDouble() { 
 return Double.parseDouble(nextToken());
    }

    public long getLong() {
 return Long.parseLong(nextToken());
    }

    public String getWord() {
 return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
 if (token == null) 
     try {
  while (st == null || !st.hasMoreTokens()) {
      line = r.readLine();
      if (line == null) return null;
      st = new StringTokenizer(line);
  }
  token = st.nextToken();
     } catch (IOException e) { }
 return token;
    }

    private String nextToken() {
 String ans = peekToken();
 token = null;
 return ans;
    }
}



class Edge {
    private int d;
    private int fat;

    public Edge(int ds, int f) {
        d = ds;
        fat = f;
    }

    public int getD() {
        return d;
    }

    public int getF() {
        return fat;
    }

    public String toString() {
        return d + " " + fat;
    }
}

class Node implements Comparable<Node> {
    private long dist;
    private int name;

    public Node (int n, long d) {
        dist = d;
        name = n;
    }

    public long getDist() {
        return dist;
    }

    public int getName() {
        return name;
    }

    public int compareTo(Node n) {
        return Long.compare(dist,n.dist); // maybe change order
    }
}



public class entry_8433102 {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int m = io.getInt();

        Map<Integer, List<Edge>> g = new HashMap<>();

        long[] fat = new long[n];
        fat[0] = 0;

        g.put(0, new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = io.getInt() - 1;
            int b = io.getInt() - 1;
            int c = io.getInt();

            if (!g.containsKey(a)) {
                g.put(a, new ArrayList<>());
            }
            if (!g.containsKey(b)) {
                g.put(b, new ArrayList<>());
            }
            // if (g.get(a)[b] != 0 && g.get(a)[b] < c)
                // continue;
            g.get(a).add(new Edge(b, c));
            // System.out.println(a + " " + g.get(a).toString());

        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node me = pq.poll();
            long far = me.getDist();

            if (fat[me.getName()] != 0 && far > fat[me.getName()]) 
                continue;
            List<Edge> kids = g.get(me.getName()); 

            for (int i = 0; i < kids.size(); i++) {
                long gone = kids.get(i).getF();
                int name = kids.get(i).getD();
                // System.out.println(me.getName() + ": " + far + " " + gone + " " + i + " " + fat[i]);
                if ((name != 0 && fat[name] == 0) || far + gone < fat[name]) {
                    // System.out.println("           " + buddy);
                    fat[name] = far + gone;
                    pq.add(new Node(name, far + gone));
                }
            }
        }

        for (int i = 0; i < fat.length; i++) {
            io.print(fat[i] + " ");   
        }

        io.close();
    }


}