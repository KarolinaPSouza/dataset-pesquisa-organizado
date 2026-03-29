import java.io.*;
import java.util.*;



/**
 * Simple yet moderately fast I/O routines.
 * Some notes:
 *
 * - When done, you should always do io.close() or io.flush() on the
 *   Kattio-instance, otherwise, you may lose output.
 *
 * - The nextInt(), nextDouble(), and nextLong() methods will throw an
 *   exception if there is no more data in the input.
 *
 * @author: Kattis
 */



public class entry_8841312 {
    static int max_area = Integer.MIN_VALUE;
    static int min_perm = Integer.MAX_VALUE;
    static int[] drow = {-1,1,0,0};
    static int[] dcol = {0,0,-1,1};
    static double ans = 0;
 //mulitset
 public static void add(TreeMap<Integer, Integer> ret, int x){
  if(ret.containsKey(x)) ret.put(x, ret.get(x)+1);
  else ret.put(x, 1);
 }
 public static void remove(TreeMap<Integer, Integer> ret, int x){
  if(ret.containsKey(x)) {
   ret.put(x, ret.get(x)-1);
   if(ret.get(x)==0) ret.remove(x);
  }
 }



    public static void dfs(int node, List<Integer> adj[], boolean visited[]){
  if(visited[node]) return;
  visited[node] = true;

  for(Integer nei : adj[node]){
            dfs(nei, adj, visited);
  }

 }

    public static long binarySearch(long dp[][], int index, int start){
        int begin = 0;
        int end = index-1;
        long ans = 0;
        while(begin<=end){
            int mid = (begin) + (end-begin)/2;
            long temp_end = dp[mid][1];
            if(temp_end < start){
                ans = dp[mid][0];
                begin=mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }

 public static void main(String[] args) throws IOException{
  //FastIO io = new FastIO("input.in", "input.out");
  //FastIO io = new FastIO();
  Kattio io = new Kattio();
  //Kattio io = new Kattio("wormsort");
  int n = io.nextInt();
        int arr[][] = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0] = io.nextInt();
            arr[i][1] = io.nextInt();
            arr[i][2] = io.nextInt();

        }
        Arrays.sort(arr, Comparator.comparingInt(i->i[1]));
        long dp[][] = new long[n][2];
        dp[0][0] = arr[0][2];
        dp[0][1] = arr[0][1];
        for(int i=1;i<n;i++){
            long not_take = dp[i-1][0];
            long take = arr[i][2];
            long ans = binarySearch(dp, i, arr[i][0]);
            take+=ans;
            dp[i][0] = Math.max(not_take, take);
            if(take>= not_take){
                dp[i][1] = arr[i][1];
            }
            else dp[i][1] = dp[i-1][1];
        }

        io.print(dp[n-1][0]);

  /*
   * Make sure to include the line below, as it
   * flushes and closes the output stream.
   */
  io.close();
  }
 }
class Pair<K, V>{
 K first;
 V second;

 public Pair(K first, V second){
  this.first = first;
  this.second = second;
 }


}
class Pair1 implements Comparable<Pair1>{
 int first;
 int second;
 int third;
    int fourth;
 public Pair1(int first, int second){
  this.first = first;
  this.second = second;
 }
 public Pair1(int first, int second, int third){
  this.first = first;
  this.second = second;
  this.third = third;
 }
    public Pair1(int first, int second, int third, int fourth){
  this.first = first;
  this.second = second;
  this.third = third;
        this.fourth = fourth;
 }

 public int compareTo(Pair1 b){
  return Integer.compare(first, b.first);
 }

}

class Kattio extends PrintWriter {
 private BufferedReader r;
 private StringTokenizer st;
 // standard input
 public Kattio() { this(System.in, System.out); }
 public Kattio(InputStream i, OutputStream o) {
  super(o);
  r = new BufferedReader(new InputStreamReader(i));
 }
 // USACO-style file input
 public Kattio(String problemName) throws IOException {
  super(problemName + ".out");
  r = new BufferedReader(new FileReader(problemName + ".in"));
 }
 // returns null if no more input
 public String next() {
  try {
   while (st == null || !st.hasMoreTokens())
    st = new StringTokenizer(r.readLine());
   return st.nextToken();
  } catch (Exception e) {}
  return null;
 }
 public int nextInt() { return Integer.parseInt(next()); }
 public double nextDouble() { return Double.parseDouble(next()); }
 public long nextLong() { return Long.parseLong(next()); }
}
class FastIO extends PrintWriter {
 private InputStream stream;
 private byte[] buf = new byte[1 << 16];
 private int curChar, numChars;

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
  if (numChars == -1) throw new InputMismatchException();
  if (curChar >= numChars) {
   curChar = 0;
   try {
    numChars = stream.read(buf);
   } catch (IOException e) { throw new InputMismatchException(); }
   if (numChars == -1) return -1;  // end of file
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
   if (c < '0' || c > '9') throw new InputMismatchException();
   res = 10 * res + c - '0';
   c = nextByte();
  } while (c > ' ');
  return res * sgn;
 }
 public double nextDouble() { return Double.parseDouble(next()); }
}










// io.next() Reads the next token (up to a whitespace) and returns a String
// io.nextInt() Reads the next token (up to a whitespace) and returns as an int
// io.nextLong() Reads the next token (up to a whitespace) and returns as a long
// io.nextDouble() Reads the next token (up to a whitespace) and returns as a double
// io.print(arg) Prints arg to designated output stream
// io.println(arg) Prints arg to designated output stream and adds a newline
// io.close() Closes the output stream and flushes the output. 
// Make sure to call this (or io.flush()) at the end, or you won't see any output!