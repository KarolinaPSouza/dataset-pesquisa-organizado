import java.io.*;
import java.util.*;

public class entry_15747103 {
    static int SI = 1;
    static int[] parent; // DSU parent array

    // DSU find with path compression
    // Returns the index of the nearest available ticket to the left
    static int find(int i) {
        if (i < 0) return -1;
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    static void solve(int tc) {
        int n = io.nextInt();
        int m = io.nextInt();
        int[] tickets = io.nextIntArray(n);
        int[] customers = io.nextIntArray(m);

        // 1. Sort tickets to allow binary search
        Arrays.sort(tickets);

        // 2. Initialize DSU
        // Initially, every ticket index points to itself (meaning it's available)
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        io.printDelemeter = "\n"; // Ensure output is on new lines

        for (int maxPrice : customers) {
            // 3. Binary Search: Find the largest index where tickets[index] <= maxPrice
            int idx = -1;
            int low = 0, high = n - 1;

            // Standard binary search for upper bound
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (tickets[mid] <= maxPrice) {
                    idx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // 4. Use DSU to find the actual available ticket
            // idx is the "theoretical" best match, but it might be taken.
            // find(idx) jumps over taken tickets to the left.
            int availableIdx = find(idx);

            if (availableIdx == -1) {
                io.println("-1");
            } else {
                io.println(tickets[availableIdx]);
                // 5. Mark ticket as taken: point it to the neighbor on the left
                // effectively removing it from consideration
                parent[availableIdx] = availableIdx - 1;
            }
        }
    }

    public static void main(String[] args) {
        if(SI==1) solve(0);
        else{
            int t = io.nextInt();
            for(int i=1;i<=t;i++){
                solve(i);
                if(i%5==0) io.flush();
            }
        }
        io.flush();
    }
    static IO io = new IO();
}

class IO extends PrintWriter{
    BufferedReader bf;
    StringTokenizer st;
    String token;
    String printDelemeter = " ";
    public IO() {
        super(new BufferedOutputStream(System.out));
        bf = new BufferedReader(new InputStreamReader(System.in));
    }
    public IO(InputStream i) {
        super(new BufferedOutputStream(System.out));
        bf = new BufferedReader(new InputStreamReader(i));
    }
    public IO(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        bf = new BufferedReader(new InputStreamReader(i));
    }
    public boolean hasMoreTokens() {
        return peekToken() != null;
    }
    public int nextInt() {
        return Integer.parseInt(nextToken());
    }
    public int[] nextArray(int n) {
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=nextInt();
        return a;
    }
    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=nextInt();
        return a;
    }
    public void nextIntArray(int[] a) {
        for(int i=0;i<a.length;i++) a[i]=nextInt();
    }
    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }
    public long nextLong() {
        return Long.parseLong(nextToken());
    }
    public long[] nextLongArray(int n) {
        long[] a = new long[n];
        for(int i=0;i<n;i++)
            a[i]=nextLong();
        return a;
    }
    public String nextString() {
        return nextToken();
    }
    public String next() {
        return nextToken();
    }
    public String peekToken(){
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    String line = bf.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }
    public String nextToken(){
        String ans = peekToken(); token = null;
        return ans;
    }
    public <T> void print(T[] a){
        for(T i:a) print(i+printDelemeter);
        flush();
    }
    public <T> void println(T[] a){
        for(T i:a) print(i+printDelemeter);
        println();
        flush();
    }
    public <T> void print(Collection<T> a){
        for(T i:a) print(i+printDelemeter);
        flush();
    }
    public <T> void println(Collection<T> a){
        for(T i:a) print(i+printDelemeter);
        println();
        flush();
    }
    // Primitives
    public void print(int[] a){
        for(int i:a) print(i+printDelemeter);
        flush();
    }
    public void println(int[] a){
        for(int i:a) print(i+printDelemeter);
        println();
        flush();
    }
    public void print(long[] a){
        for(long i:a) print(i+printDelemeter);
        flush();
    }
    public void println(long[] a){
        for(long i:a) print(i+printDelemeter);
        println();
        flush();
    }
    public void print(String[] a){
        for(String i:a) print(i+printDelemeter);
        flush();
    }
    public void println(String[] a){
        for(String i:a) print(i+printDelemeter);
        println();
        flush();
    }
    public void println(Object o) {
        super.println(o);
    }
}