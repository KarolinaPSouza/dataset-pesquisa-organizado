import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class entry_1718771 {

 public static void main(String[] args) {
  if (args.length > 0 && args[0].toLowerCase().equals("local")) {
   try {
    System.setIn(new FileInputStream("input.txt"));
    System.setOut(new PrintStream(new File("output.txt")));
   } catch (IOException exc) {
   }
  }
  Task task = new Task();
  task.solve();
 }

 public static class Task {
  static final long MOD = (long) 1e9 + 7;
  static final PrintWriter out = new PrintWriter(System.out);
  List<ArrayList<Integer>> depths;
  ArrayList<Integer>[] adjList;
  int[] vis, maxOutside;
  int[][] maxInside;

  public void solve() {
   try {
    Scan sc = new Scan();
    int n = (int) sc.scanLong();
    maxInside = new int[n][2];
    vis = new int[n];
    maxOutside = new int[n];
    adjList = new ArrayList[n];
    depths = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < n; ++i)
     adjList[i] = new ArrayList<Integer>();
    for (int i = 1; i < n; ++i) {
     int a = -1 + (int) sc.scanLong();
     int b = -1 + (int) sc.scanLong();
     adjList[a].add(b);
     adjList[b].add(a);
    }
    Queue<int[]> q = new LinkedList<int[]>();
    q.offer(new int[] { 0, 0 });

    while (!q.isEmpty()) {
     int[] curr = q.poll();
     vis[curr[0]] = 1;
     if (depths.size() <= curr[1])
      depths.add(new ArrayList<Integer>());
     depths.get(curr[1]).add(curr[0]);
     if (adjList[curr[0]] == null)
      continue;
     for (int i = 0, end = adjList[curr[0]].size(); i < end; ++i) {
      int nbr = adjList[curr[0]].get(i);
      if (vis[nbr] == 0)
       q.offer(new int[] { nbr, curr[1] + 1 });
      else {
       // "mark" parent
       adjList[curr[0]].set(i, -1);
      }
     }
    }
    int maxToLeaf1, maxToLeaf2, children, curr, nbr;
    for (int i = depths.size() - 2; i >= 0; --i) {
     for (int j = 0, end = depths.get(i).size(); j < end; ++j) {
      curr = depths.get(i).get(j);
      maxToLeaf1 = 0;
      maxToLeaf2 = 0;
      children = 0;
      for (int k = 0, k_end = adjList[curr].size(); k < k_end; ++k) {
       nbr = adjList[curr].get(k);
       // identify "marked" parent and ignore
       if (nbr < 0) {
        continue;
       }
       ++children;
       if (maxInside[nbr][0] >= maxToLeaf1) {
        maxToLeaf2 = maxToLeaf1;
        maxToLeaf1 = maxInside[nbr][0];
       } else if (maxInside[nbr][0] > maxToLeaf2) {
        maxToLeaf2 = maxInside[nbr][0];
       }
      }
      maxInside[curr][0] = maxToLeaf1 + (children > 0 ? 1 : 0);
      maxInside[curr][1] = maxToLeaf2 + (children > 1 ? 1 : 0);
     }
    }

    for (int i = 0, i_end = depths.size() - 1; i < i_end; ++i) {
     for (int j = 0, end = depths.get(i).size(); j < end; ++j) {
      curr = depths.get(i).get(j);
      for (int k = 0, k_end = adjList[curr].size(); k < k_end; ++k) {
       nbr = adjList[curr].get(k);
       // identify "marked" parent and ignore
       if (nbr < 0) {
        continue;
       }
       if (maxInside[nbr][0] + 1 == maxInside[curr][0]) {
        maxOutside[nbr] = 1 + (maxOutside[curr] > maxInside[curr][1] ? maxOutside[curr]
          : maxInside[curr][1]);
       } else {
        maxOutside[nbr] = 1 + (maxOutside[curr] > maxInside[curr][0] ? maxOutside[curr]
          : maxInside[curr][0]);
       }
      }
     }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; ++i) {
     sb.append(maxInside[i][0] > maxOutside[i] ? maxInside[i][0] : maxOutside[i]).append(" ");
    }
    out.println(sb);
   } finally {
    out.close();
   }
  }

  private void debug(Object... x) {
   StringBuilder sb = new StringBuilder();
   for (Object o : x)
    sb.append(String.valueOf(o)).append(" ");
   out.println(sb);
  }
 }

 public static class Scan {
  private byte[] buf = new byte[1024];
  private int index;
  private InputStream in;
  private int total;

  public Scan() {
   in = System.in;
  }

  public int scan() {
   if (total < 0)
    throw new InputMismatchException();
   if (index >= total) {
    index = 0;
    try {
     total = in.read(buf);
    } catch (IOException e) {
     throw new RuntimeException(e);
    }
    if (total <= 0)
     return -1;
   }
   return buf[index++];
  }

  public long scanLong() {
   long integer = 0;
   int n = scan();
   while (isWhiteSpace(n))
    n = scan();
   int neg = 1;
   if (n == '-') {
    neg = -1;
    n = scan();
   }
   while (!isWhiteSpace(n)) {
    if (n >= '0' && n <= '9') {
     integer *= 10;
     integer += n - '0';
     n = scan();
    } else
     throw new InputMismatchException();
   }
   return neg * integer;
  }

  public double scanDouble() {
   double doub = 0;
   int n = scan();
   while (isWhiteSpace(n))
    n = scan();
   int neg = 1;
   if (n == '-') {
    neg = -1;
    n = scan();
   }
   while (!isWhiteSpace(n) && n != '.') {
    if (n >= '0' && n <= '9') {
     doub *= 10;
     doub += n - '0';
     n = scan();
    } else
     throw new InputMismatchException();
   }
   if (n == '.') {
    n = scan();
    double temp = 1;
    while (!isWhiteSpace(n)) {
     if (n >= '0' && n <= '9') {
      temp /= 10;
      doub += (n - '0') * temp;
      n = scan();
     } else
      throw new InputMismatchException();
    }
   }
   return doub * neg;
  }

  public String scanString() {
   StringBuilder sb = new StringBuilder();
   int n = scan();
   while (isWhiteSpace(n))
    n = scan();
   while (!isWhiteSpace(n)) {
    sb.append((char) n);
    n = scan();
   }
   return sb.toString();
  }

  public char scanChar() {
   int n = scan();
   while (isWhiteSpace(n))
    n = scan();
   return (char) n;
  }

  private boolean isWhiteSpace(int n) {
   if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
    return true;
   return false;
  }
 }
}