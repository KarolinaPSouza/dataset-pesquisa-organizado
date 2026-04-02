import java.io.*;
import java.util.*;

public class entry_8346983 {
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter(System.out);
        FastIO io = new FastIO();
  int n = io.nextInt();
  int m = io.nextInt();
        //StringTokenizer st;// = new StringTokenizer(io.readLine());
        //int n = Integer.parseInt(st.nextToken());
        //int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[n+1];

        for(int i = 0; i <= n; i++) 
            adj[i] = (new ArrayList<Integer>());

        for(int i = 0; i < m; i++) {
            //st = new StringTokenizer(io.read());
            //int a = Integer.parseInt(st.nextToken());
            //int b = Integer.parseInt(st.nextToken());
            int a = io.nextInt();
            int b = io.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] t = new int[n+1]; //0 is unvis, 1 = 1, 2 = 2
        boolean[] vis = new boolean[n+1]; 

        for(int i = 1; i <= n; i++) {
            if(vis[i]) continue;
            LinkedList<Integer> q = new LinkedList<>();
            q.push(i);
            t[i] = 1; //Doesnt matter if not connected

            while(!q.isEmpty()) {
                int curr = q.poll();

                if(!vis[curr]) {
                    for(int k : adj[curr]) {
                        if(!vis[k]) {
                            q.push(k);

                            if(t[curr] == t[k]) {
                                io.println("IMPOSSIBLE");
                                io.close();
                                return;
                            } 
                            t[k] = (3-t[curr]);
                        }
                    }
                }

                vis[curr] = true;
            }
        }

        for(int i = 1; i < n; i++)
            io.print(t[i] + " ");
        io.println(t[n]);
        io.close();
    }
}
class FastIO extends PrintWriter {
 private InputStream stream;
 private byte[] buf = new byte[1 << 16];
 private int curChar;
 private int numChars;

 // standard input
 public FastIO() { this(System.in, System.out); }

 public FastIO(InputStream i, OutputStream o) {
  super(o);
  stream = i;
 }

 // file input
 public FastIO(String i, String o) throws IOException {
  super(new FileWriter(o));
  stream = new FileInputStream(i);
 }

 // throws InputMismatchException() if previously detected end of file
 private int nextByte() {
  if (numChars == -1) { throw new InputMismatchException(); }
  if (curChar >= numChars) {
   curChar = 0;
   try {
    numChars = stream.read(buf);
   } catch (IOException e) { throw new InputMismatchException(); }
   if (numChars == -1) {
    return -1;  // end of file
   }
  }
  return buf[curChar++];
 }

 // to read in entire lines, replace c <= ' '
 // with a function that checks whether c is a line break
 public String next() {
  int c;
  do { c = nextByte(); } while (c <= ' ');

  StringBuilder res = new StringBuilder();
  do {
   res.appendCodePoint(c);
   c = nextByte();
  } while (c > ' ');
  return res.toString();
 }

 public int nextInt() {  // nextLong() would be implemented similarly
  int c;
  do { c = nextByte(); } while (c <= ' ');

  int sgn = 1;
  if (c == '-') {
   sgn = -1;
   c = nextByte();
  }

  int res = 0;
  do {
   if (c < '0' || c > '9') { throw new InputMismatchException(); }
   res = 10 * res + c - '0';
   c = nextByte();
  } while (c > ' ');
  return res * sgn;
 }

 public double nextDouble() { return Double.parseDouble(next()); }
}