import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;


public class entry_1127506 {
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
     public static int []parent;
        public void solve(int testNumber, InputReader in, PrintWriter out) {
   int n = in.nextInt(), m = in.nextInt();
   parent = new int[n+1];
   for(int i=1;i<=n; i++)
    parent[i] = i;
   for(int i = 1; i<=m; i++)
   {
    int x = in.nextInt(), y = in.nextInt();
    union(x,y);
   }
   ArrayList<Integer> arr = new ArrayList<>();
   int cnt=0;
   for(int i = 1; i<=n; i++){
    if(parent[find(i)]==i){
     cnt++;
     arr.add(i);
    }
   }
   out.println((cnt-1));
   int x = arr.get(0);
   for(int i=1; i<cnt; i++)
   {
    out.println(x+" "+arr.get(i));
    x = arr.get(i);
   }
        }
        private static int find(int x)
  {
  if(parent[x]==x)
   return x;
  else 
   return parent[x] = find(parent[x]);
  }
  private static void union(int x, int y)
     {
   int x_set= find(x);
   int y_set=find(y);
   parent[y_set] = x_set;
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
