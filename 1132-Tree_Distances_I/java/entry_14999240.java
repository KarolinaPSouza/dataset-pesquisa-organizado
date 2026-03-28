import java.io.*;
import java.util.*;

public class entry_14999240 {

  static class Solution {
    /**
     * @param n     number of nodes labeled 1..n
     * @param edges list of undirected edges; each edge is {a, b} with 1 <= a,b <= n
     * @return long[] ans of length n where ans[i] is the sum of distances from node (i+1) to all other nodes
     */
    ArrayList<Integer>[] adj;
    long[] firstmax;
    long[] secondmax;
    long[] ans;

    public long[] sumDistances(int n, List<int[]> edges) {
      adj = ( ArrayList<Integer>[]) new ArrayList[n];
      for(int i=0;i<n;i++)
      {
        adj[i] = new ArrayList<>();
      }
      for(int[] edge: edges)
      {
        adj[edge[0]-1].add(edge[1]-1);
        adj[edge[1]-1].add(edge[0]-1);
      }


      firstmax = new long[n];
      secondmax = new long[n];

      dfs1(0,-1);

      ans = new long[n];
      ans[0] = firstmax[0];



      reroot(0,-1);

      return ans;

    }
    public void reroot(int node, int parent)
    {

      /*
      ArrayDeque<int[]> dq = new ArrayDeque<>();
      dq.addFirst(new int[]{node, parent, 0});
      while(dq.size()>0)
      {
        int[] top = dq.peekFirst();
        node = top[0];
        parent = top[1];
        if(top[2]==0)
        {
          top[2]=1;
          for(int neigh: adj[node]) {
            if(neigh==parent) continue;
            long sumexcludingneigh = rerootsum[node] - rerootsum[neigh] - rerootcnt[neigh];
             long nextneighcnt = rerootcnt[neigh] + rerootcnt[node] - rerootcnt[neigh];
             long nextneighsum =
                rerootsum[neigh] + sumexcludingneigh + (rerootcnt[node] - rerootcnt[neigh]);
             rerootsum[neigh] = nextneighsum;
            rerootcnt[neigh] = nextneighcnt;
            ans[neigh] = rerootsum[neigh];
            dq.addFirst(new int[]{neigh, node, 0});
          }
        }
        else
        {
          dq.pollFirst();
        }
      }
      */


      /*for(int neigh: adj[node])
      {
        if(neigh==parent) continue;
        //now to make neigh the root instea dof node
        //what woul it cost
        long sumexcludingneigh = rerootsum[node] - rerootsum[neigh] - rerootcnt[neigh];
         long nextneighcnt = rerootcnt[neigh] + rerootcnt[node] - rerootcnt[neigh];
         long nextneighsum = rerootsum[neigh] + sumexcludingneigh + (rerootcnt[node] - rerootcnt[neigh]);
         rerootsum[neigh] = nextneighsum;
        rerootcnt[neigh] = nextneighcnt;
        ans[neigh] = rerootsum[neigh];
         reroot(neigh, node);
      }*/

      /*
      for(int neigh: adj[node])
      {
        if(neigh==parent) continue;
        //now to make neigh the root instea dof node
        //what woul it cost
        long candidate = firstmax[node] + 1;
        if(firstmax[neigh]+1 == firstmax[node]) {
          candidate = secondmax[node] + 1;
        }
          if(candidate>firstmax[neigh])
          {
            secondmax[neigh] = firstmax[neigh];
            firstmax[neigh] = candidate;
          }
          if(candidate>secondmax[neigh])
          {
            secondmax[neigh] = candidate;
          }
          //we dont care bat first/second max of root hat has now become child!
        ans[neigh] = firstmax[neigh];
         reroot(neigh, node);
      }
        */

      ArrayDeque<int[]> dq = new ArrayDeque<>();
      dq.addFirst(new int[]{node, parent, 0});
      while(dq.size()>0)
      {
        int[] top = dq.peekFirst();
        node = top[0];
        parent = top[1];
        if(top[2]==0)
        {
          top[2]=1;
          for(int neigh: adj[node]) {
            if(neigh==parent) continue;
            long candidate = firstmax[node] + 1;
            if(firstmax[neigh]+1 == firstmax[node]) {
              candidate = secondmax[node] + 1;
            }
            if(candidate>firstmax[neigh])
            {
              secondmax[neigh] = firstmax[neigh];
              firstmax[neigh] = candidate;
            }
            if(candidate>secondmax[neigh])
            {
              secondmax[neigh] = candidate;
            }
            //we dont care bat first/second max of root hat has now become child!
            ans[neigh] = firstmax[neigh];
            dq.addFirst(new int[]{neigh, node, 0});
          }
        }
        else
        {
          dq.pollFirst();
        }
      }

    }
    public void dfs1(int node, int parent)
    {

      ArrayDeque<int[]> dq = new ArrayDeque<>();
      dq.addFirst(new int[]{node, parent,0});//state 0 , calling, 1, retued
      while(dq.size()>0)
      {
        int[] top = dq.peekFirst();
        node = top[0];
        parent = top[1];
        if(top[2]==1)
        {
          for(int neigh: adj[node]) {
            if(neigh==parent) continue;
            if(1+firstmax[neigh]>firstmax[node])
            {
              secondmax[node] = firstmax[node];
              firstmax[node] = 1+firstmax[neigh];
            }
            else if(1+firstmax[neigh]>secondmax[node])
            {
              secondmax[node] = 1+firstmax[neigh];
            }
          }
          dq.pollFirst();
        }
        else {
          top[2]=1;
          for (int neigh : adj[node]) {
            if (neigh == parent)
              continue;
            dq.addFirst(new int[]{neigh, node, 0});
          }
        }

      }
      /*
      for(int neigh: adj[node])
      {
        if(neigh==parent) continue;
        dfs1(neigh, node);
        if(1+firstmax[neigh]>firstmax[node])
        {
          secondmax[node] = firstmax[node];
          firstmax[node] = 1+firstmax[neigh];
        }
        else if(1+firstmax[neigh]>secondmax[node])
        {
          secondmax[node] = 1+firstmax[neigh];
        }
      }*/



      /*
      for(int neigh: adj[node])
      {
        if(neigh==parent) continue;
        dfs1(neigh, node);
        cnt[node]+=cnt[neigh];
        sum[node]+=sum[neigh];
        sum[node]+=cnt[neigh];
      }*/

      /*
      ArrayDeque<int[]> dq = new ArrayDeque<>();
      dq.addFirst(new int[]{node, parent,0});//state 0 , calling, 1, retued
      while(dq.size()>0)
      {
        int[] top = dq.peekFirst();
        node = top[0];
        parent = top[1];
        if(top[2]==1)
        {
          for(int neigh: adj[node]) {
            if(neigh==parent) continue;
            cnt[node] += cnt[neigh];
            sum[node] += sum[neigh];
            sum[node] += cnt[neigh];
          }
          dq.pollFirst();
        }
        else {
          top[2]=1;
          for (int neigh : adj[node]) {
            if (neigh == parent)
              continue;
            dq.addFirst(new int[]{neigh, node, 0});
          }
        }
       }
        */

    }

  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner(System.in);
    int n = fs.nextInt();
    List<int[]> edges = new ArrayList<>(n - 1);
    for (int i = 0; i < n - 1; i++) {
      int a = fs.nextInt(), b = fs.nextInt();
      edges.add(new int[]{a, b});
    }
    Solution sol = new Solution();
    long[] ans = sol.sumDistances(n, edges);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < ans.length; i++) {
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