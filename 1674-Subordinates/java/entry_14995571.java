import java.io.*;
import java.util.*;

public class entry_14995571 {

  static class Solution {
    /**
     * @param n total number of employees labeled 1..n (1 is the general director)
     * @param boss an int[n+1] array where boss[i] is the direct boss of employee i (for i>=2);
     *             boss[1] can be 0 or ignored
     * @return int[] counts where counts[i] is the number of (direct or indirect) subordinates of employee i
     */

    public int[] countSubordinates(int n, int[] boss) {
      //System.out.println(" boss "+Arrays.toString(boss));
      ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
      for(int i=0;i<n;i++)
      {
        adj[i]  = new ArrayList<>();
      }
      for(int i=0;i<boss.length;i++)
      {
        //i+1 th person's boss is boss[i]
        adj[boss[i]-1].add(i+1);
      }
      int[] ans = new int[n];
      //dfs(0,-1, ans, adj);
      ArrayDeque<State> dq = new ArrayDeque<>();
      dq.addFirst(new State(0,-1, null));
      while(dq.size()>0)
      {
          State top = dq.pollFirst();
          top.cnt+=top.childretval;
          top.childretval=0;
          //top.explorer++;

          while(top.explorer<adj[top.node].size()) {
            int neigh = adj[top.node].get(top.explorer);
            if(neigh==top.parent)
            {
              top.explorer++;
              continue;
            }
            else
            {
              break;
            }
          }

          if(top.explorer<adj[top.node].size()) {
              int childNode = adj[top.node].get(top.explorer);
              State childState = new State(childNode, top.node, top);
              top.explorer++;
              dq.addFirst(top);
              dq.addFirst(childState);
          }
          else {
            ans[top.node] = top.cnt-1;
            if(top.parentState!=null)
            {
              top.parentState.childretval = top.cnt;
            }
          }



      }



      return ans;
    }
    static class State
    {
      State parentState;
      int explorer;
      int cnt;
      int node;
      int parent;
      int childretval;

      public State(int node, int parent, State parentState)
      {
        this.node = node;
        this.cnt = 1;
        this.explorer = 0;
        this.parent = parent;
        this.parentState = parentState;
        this.childretval = 0;
      }
    }
    public int dfs(int node, int parent, int[] ans,  ArrayList<Integer>[] adj )
    {
        int cnt  = 1;
        for(int neigh: adj[node])
        {
          if(neigh==parent) continue;
          cnt+=dfs(neigh, node, ans,adj);
        }
        ans[node] = cnt-1;
        return cnt;
    }
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner(System.in);
    int n = fs.nextInt();
    int[] boss = new int[n-1]; // 1-based
    for (int i = 0; i < n-1; i++) boss[i] = fs.nextInt();

    Solution sol = new Solution();
    int[] ans = sol.countSubordinates(n, boss);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i > 0) sb.append(' ');
      sb.append(ans[i]);
    }
    System.out.println(sb.toString());
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