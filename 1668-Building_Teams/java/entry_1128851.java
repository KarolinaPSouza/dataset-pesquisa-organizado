import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class entry_1128851 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
   int n = in.nextInt(), m = in.nextInt(); 
         Map<Integer,List<Integer>> graph = new HashMap<>();
         for(int i = 1; i<=n; i++)
          graph.put(i,new ArrayList<>());
         for(int i=1; i<=m; i++)
         {
          int src = in.nextInt(), dst =  in.nextInt();
          addEdge(graph, src, dst);
         }
         bfs(graph, n, out);
        } // end solve method
        private static void bfs(Map<Integer,List<Integer>>graph, int n,PrintWriter out)
        {
         int []color= new int[n+1];
         Arrays.fill(color,Integer.MAX_VALUE);
         boolean is= true;
         for(int i=1; i<=n; i++)
         {
          if(color[i]!=Integer.MAX_VALUE)
           continue;
          is = true;
          Queue<Integer> q = new LinkedList<>();
          q.add(i);
          color[i]=0;
          while(q.isEmpty()!=true)
          {
           int u = q.poll();
           for(int x :graph.get(u))
           {
            if(color[x]==Integer.MAX_VALUE)
            {
             color[x]=1-color[u];
             q.add(x);
            }
            else if(color[x]==color[u])
             is=false;
           }
          }
          if(is==false)
           break;
         }
         if(is==true)
         {
          for(int i=1;i<=n; i++)
           out.print((color[i]+1)+ " ");
         }
         else
          out.println("IMPOSSIBLE");
        }
        private static void addEdge(Map<Integer,List<Integer>>graph, int src, int dst)
        {
         List<Integer> list = graph.get(src);
         if(list == null)
         {
          list = new ArrayList<>();
          graph.put(src,list);
         }
         list.add(dst);
         list = graph.get(dst);
         if(list == null)
         {
          list = new ArrayList<>();
          graph.put(dst,list);
         }
         list.add(src);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
