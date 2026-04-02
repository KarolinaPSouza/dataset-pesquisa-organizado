// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class entry_13793886 {

    public static List<Integer>[] graph;

    public static boolean dfs(int node, int[] color, int newColor)
    {
        if(color[node] == 0)
        {
            color[node] = newColor;

            if(newColor == 1)
            {
                newColor =2;
            }
            else
            {
                newColor = 1;
            }

            for(int i = 0;i<graph[node].size();i++)
            {
                if(!dfs(graph[node].get(i), color, newColor))
                {
                    return false;
                }
            }

            return true;
        }
        else
        {
            if(color[node]!=newColor)
            {
                return false;
            }
            return true;
        }

    }

 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  StringTokenizer st = new StringTokenizer(r.readLine());
  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];

        for(int i =0;i<n;i++)
        {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i =0;i<m;i++)
        {
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] colors = new int[n];

        boolean possible = true;

        for(int i =0;i<n;i++)
        {
            if(colors[i]!=0)
            {
                continue;
            }
            if(!dfs(i, colors, 1))
            {
                possible = false;
                break;
            }
        }

        if(!possible)
        {
            pw.println("IMPOSSIBLE");
        }
        else
        {
            for(int i =0;i<n;i++)
            {
                pw.print(colors[i]+" ");
            }
        }

  /*
   * Make sure to include the line below, as it
   * flushes and closes the output stream.
   */
  pw.close();
 }
}

