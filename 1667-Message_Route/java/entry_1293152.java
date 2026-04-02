import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class entry_1293152 {

 static PrintWriter out = new PrintWriter(System.out);
 static FastScanner scan = new FastScanner(System.in);

 static ArrayList<ArrayList<Integer>> adj;
 static int n;
 static int m;

 public static void main(String[] args) {
  adj = new ArrayList<>();
  n = scan.nextInt();
  m = scan.nextInt();

  for(int i = 0; i < n; i++)
   adj.add(new ArrayList<>());
  for(int i = 0; i < m; i++) {
   int a = scan.nextInt() - 1;
   int b = scan.nextInt() - 1;
   adj.get(a).add(b);
   adj.get(b).add(a);
  }

  Queue<Integer> q = new LinkedList<>();
  boolean vis[] = new boolean[n];
  int[] prev = new int[n];
  Arrays.fill(prev, -1);
  q.add(0);
  vis[0] = true;
  while(!q.isEmpty()) {
   int curr = q.poll();

   if(curr == n-1)
    break;

   for(int k : adj.get(curr)) {
    if(!vis[k]) {
     q.add(k);
     prev[k] = curr;
     vis[k] = true;
    }
   }
  }

  if(prev[n-1] == -1) {
   out.println("IMPOSSIBLE");
  }
  else {
   int i = n-1;
   int ans = 0;
   Stack<Integer> stack = new Stack<>();
   stack.add(n);
   while(i != 0) {
    i = prev[i];
    stack.add(i+1);
    ans++;
   }
   out.println(ans+1);
   while(!stack.isEmpty())
    out.print(stack.pop() + " ");
   out.println();
  }
  out.close();
 }

 static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}