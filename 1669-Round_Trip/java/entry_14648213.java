import java.io.*;
import java.util.*;

public class entry_14648213 {
    static int SI=1;
    static List<Integer> ans;
    static int len;
    static void solve(int tc) {
        HashMap<Integer, Integer> visited = new HashMap<>();
        ans = null;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = io.nextInt();
        int m = io.nextInt();
        for(int i=0;i<m;i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            List<Integer> l = map.getOrDefault(a, new ArrayList<>());
            l.add(b);
            map.put(a, l);
            l = map.getOrDefault(b, new ArrayList<>());
            l.add(a);
            map.put(b, l);
        }
        for(int i=1;i<=n;i++) {
            List<Integer> path = new ArrayList<>();
            path.add(i);
            if(!visited.containsKey(i)) dfs(i, 0, map, visited, path);
        }
        if(ans==null){
            io.println("IMPOSSIBLE");
        } else {
            io.println(len);
            io.println(ans);
        }
    }

    public static void dfs(int curr, int level, HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> visited, List<Integer> path) {
        if(ans!=null) return;
        if(visited.containsKey(curr)) {
            if(level-visited.get(curr) > 2) {
                len = level-visited.get(curr) + 1;
                int first = path.indexOf(curr);
                ans = new ArrayList<>(path.subList(first, path.size()));
            }
            return;
        }
        visited.put(curr, level);
        for(int nei: map.getOrDefault(curr, new ArrayList<>())) {
            path.add(nei);
            dfs(nei, level+1, map, visited, path);
            path.remove(path.size()-1);
        }
    }



    /* ********************************** */

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
        for(T i:a) print(i+" ");
        flush();
    }
    public <T> void println(T[] a){
        for(T i:a) print(i+" ");
        println();
        flush();
    }
    public <T> void print(List<T> a){
        for(T i:a) print(i+" ");
        flush();
    }
    public <T> void println(List<T> a){
        for(T i:a) print(i+" ");
        println();
        flush();
    }
    // Primitives
    public void print(int[] a){
        for(int i:a) print(i+" ");
        flush();
    }
    public void println(int[] a){
        for(int i:a) print(i+" ");
        println();
        flush();
    }
    public void print(long[] a){
        for(long i:a) print(i+" ");
        flush();
    }
    public void println(long[] a){
        for(long i:a) print(i+" ");
        println();
        flush();
    }
    public void print(String[] a){
        for(String i:a) print(i+" ");
        flush();
    }
    public void println(String[] a){
        for(String i:a) print(i+" ");
        println();
        flush();
    }

    /* **********Util Methods********* */
    public long sum(int[] a){
        long r = 0;
        for(long i:a) r+=i;
        return r;
    }
    public boolean[] getIsPrimeSieve(){
        int n = 1001000;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<=Math.sqrt(n);i++){
            int j=2*i;
            while(j<n){
                prime[j]=false;
                j+=i;
            }
        }
        return prime;
    }
    public boolean[] getIsPrimeSieve(int n){
        n++;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<=Math.sqrt(n);i++){
            int j=2*i;
            while(j<n){
                prime[j]=false;
                j+=i;
            }
        }
        return prime;
    }
    public boolean checkPallen(String s){
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
        return true;
    }
    public HashMap<Integer, Integer> getOccuranceCountMap(int[] arr){
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i:arr) count.put(i, count.getOrDefault(i, 0)+1);
        return count;
    }
    public int[] getFrequencyArray(String s){
        int n = 26;
        for(char c:s.toCharArray())
            if(!Character.isLowerCase(c)){
                System.out.println("Util.getFrequencyArray(String s) : String is not in all lowercase.");
                throw new Error("Util.getFrequencyArray(String s) : String is not in all lowercase.");
            }
        int[] freq = new int[26];
        for(char c:s.toCharArray()) freq[c-'a']++;
        return freq;
    }
    public boolean check(int i, int j, int n, int m) {
        return i>=0 && j>=0 && i<n && j<m;
    }
}

class Pair<T1,T2> implements Comparable<Pair>{
    public T1 a;
    public T2 b;
    public Pair(){}
    public Pair(T1 a, T2 b){
        this.a=a;
        this.b=b;
    }
    public int compareTo(Pair ob){
        String s1 = this+"";
        String s2 = ob+"";
        return s1.compareTo(s2);
    }
    public String toString(){
        return ("{"+this.a+", "+this.b+"}");
    }
}