import java.io.*;
import java.util.*;


public class entry_599709 {
static long mod = (long)(pow(10, 9) + 7);
static int n;
static int[] team;
static List<Integer>[] adj;
static void fill(int i) {
 Queue<Integer> q = new ArrayDeque<Integer>();;
 q.add(i);
 team[i] = 1;
 while (!q.isEmpty()) {
  int head = q.poll();
  for (int x: adj[head]) {
   if (team[x] == 0) {
    team[x] = 3-team[head];
    q.add(x);
   }
   else if (team[x] == team[head]) {
    out.println("IMPOSSIBLE");
    out.close();
    System.exit(0);
   }
  }
 }
}
   public static void main(String[] args) throws IOException{
       sc = new Reader();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      n = sc.nextInt();
      int m = sc.nextInt();
      team = new int[n];
      adj = new ArrayList[n];
      for (int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
      for (int i = 0; i < m; i++) {
       int a = sc.nextInt()-1;
       int b = sc.nextInt()-1;
       adj[a].add(b);
       adj[b].add(a);
      }
      for (int i = 0; i < n; i++) {
       if (team[i] == 0) {
        fill(i);
       }
      }

       for (int x: team) out.print(x + " ");
       out.println();





      out.close();
   }

   static long pow(long a, long N) {
    if (N == 0) return 1;
    else if (N == 1) return a;
    else {
     long R = pow(a,N/2);
     if (N % 2 == 0) {
      return R*R;
     }
     else {
      return R*R*a;
     }
    }
   }


   static long powMod(long a, long N) {
    if (N == 0) return 1;
    else if (N == 1) return a % mod;
    else {
     long R = powMod(a,N/2) % mod;
    // out.println(R);
     R = R * R % mod;
     if (N % 2 == 1) {
      R = R* a % mod;
     }
      return R % mod;
    }
   }




   //-----------PrintWriter for faster output---------------------------------
  // public static PrintWriter out;

   //-----------MyScanner class for faster input----------
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;

      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }

      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
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

      String nextLine(){
          String str = "";
   try {
      str = br.readLine();
   } catch (IOException e) {
      e.printStackTrace();
   }
   return str;
      }

   }
   //--------------------------------------------------------


   static class Reader 
   { 
       final private int BUFFER_SIZE = 1 << 16; 
       private DataInputStream din; 
       private byte[] buffer; 
       private int bufferPointer, bytesRead; 

       public Reader() 
       { 
           din = new DataInputStream(System.in); 
           buffer = new byte[BUFFER_SIZE]; 
           bufferPointer = bytesRead = 0; 
       } 

       public Reader(String file_name) throws IOException 
       { 
           din = new DataInputStream(new FileInputStream(file_name)); 
           buffer = new byte[BUFFER_SIZE]; 
           bufferPointer = bytesRead = 0; 
       } 

       public String readLine() throws IOException 
       { 
           byte[] buf = new byte[64]; // line length 
           int cnt = 0, c; 
           while ((c = read()) != -1) 
           { 
               if (c == '\n') 
                   break; 
               buf[cnt++] = (byte) c; 
           } 
           return new String(buf, 0, cnt); 
       } 

       public int nextInt() throws IOException 
       { 
           int ret = 0; 
           byte c = read(); 
           while (c <= ' ') 
               c = read(); 
           boolean neg = (c == '-'); 
           if (neg) 
               c = read(); 
           do
           { 
               ret = ret * 10 + c - '0'; 
           }  while ((c = read()) >= '0' && c <= '9'); 

           if (neg) 
               return -ret; 
           return ret; 
       } 

       public long nextLong() throws IOException 
       { 
           long ret = 0; 
           byte c = read(); 
           while (c <= ' ') 
               c = read(); 
           boolean neg = (c == '-'); 
           if (neg) 
               c = read(); 
           do { 
               ret = ret * 10 + c - '0'; 
           } 
           while ((c = read()) >= '0' && c <= '9'); 
           if (neg) 
               return -ret; 
           return ret; 
       } 

       public double nextDouble() throws IOException 
       { 
           double ret = 0, div = 1; 
           byte c = read(); 
           while (c <= ' ') 
               c = read(); 
           boolean neg = (c == '-'); 
           if (neg) 
               c = read(); 

           do { 
               ret = ret * 10 + c - '0'; 
           } 
           while ((c = read()) >= '0' && c <= '9'); 

           if (c == '.') 
           { 
               while ((c = read()) >= '0' && c <= '9') 
               { 
                   ret += (c - '0') / (div *= 10); 
               } 
           } 

           if (neg) 
               return -ret; 
           return ret; 
       } 

       private void fillBuffer() throws IOException 
       { 
           bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
           if (bytesRead == -1) 
               buffer[0] = -1; 
       } 

       private byte read() throws IOException 
       { 
           if (bufferPointer == bytesRead) 
               fillBuffer(); 
           return buffer[bufferPointer++]; 
       } 

       public void close() throws IOException 
       { 
           if (din == null) 
               return; 
           din.close(); 
       } 
   }

 public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
 public static Reader sc = new Reader();
}








