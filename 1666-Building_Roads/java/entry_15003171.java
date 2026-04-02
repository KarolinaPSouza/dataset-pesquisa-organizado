import java.io.*;
import java.util.*;

public class entry_15003171 {

  static class Solution {
    int[] parent, sz;

    public int ancestor(int u)
    {
      if(parent[u]==u) return u;
      parent[u] = ancestor(parent[u]);
      return parent[u];
    }


    public boolean union(int u, int v)
    {
      u = ancestor(u);
      v = ancestor(v);
      if(u==v) return false;

      if(sz[u]<sz[v])
      {
        int t= u;
        u = v;
        v = t;
      }
      parent[v] = u;
      sz[u]+=sz[v];
      components--;
      return true;

    }
    int components;

    public List<int[]> buildRoads(int n, List<int[]> roads) {
      parent = new int[n];
      for(int i=0;i<parent.length;i++)
      {
        parent[i] = i;
      }
      sz = new int[n];
      Arrays.fill(sz,1);
      components = n;
      //Collections.sort(roads, (x,y)->Integer.compare(x[2], y[2]));
      long cost = 0L;

      for(int[] road: roads)
      {
        union(road[0]-1, road[1]-1);
      }
      ArrayList<Integer> heads = new ArrayList<>();
      for(int i=0;i<n;i++)
      {
        if(parent[i]==i)
        {
          heads.add(i);

        }
      }
      List<int[]> arr = new ArrayList<>();
      for(int i=0;i<heads.size()-1;i++)
      {
        arr.add(new int[]{heads.get(i)+1, heads.get(i+1)+1});
      }
      return arr;

    }
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner(System.in);
    int n = fs.nextInt(), m = fs.nextInt();
    List<int[]> roads = new ArrayList<>(m);
    for (int i = 0; i < m; i++) {
      int a = fs.nextInt(), b = fs.nextInt();
      roads.add(new int[]{a, b});
    }
    Solution sol = new Solution();
    List<int[]> add = sol.buildRoads(n, roads);

    StringBuilder sb = new StringBuilder();
    sb.append(add.size()).append('\n');
    for (int[] e : add) sb.append(e[0]).append(' ').append(e[1]).append('\n');
    System.out.print(sb.toString());
  }

  // Minimal fast scanner
  static class FastScanner {
    private final InputStream in;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;
    FastScanner(InputStream is) { in = is; }
    private int read() throws IOException {
      if (ptr >= len) {
        len = in.read(buffer);
        ptr = 0;
        if (len <= 0) return -1;
      }
      return buffer[ptr++];
    }
    String next() throws IOException {
      StringBuilder sb = new StringBuilder();
      int c;
      while ((c = read()) <= ' ' && c != -1) {}
      while (c > ' ') { sb.append((char)c); c = read(); }
      return sb.toString();
    }
    int nextInt() throws IOException { return Integer.parseInt(next()); }
  }
}