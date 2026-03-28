import java.io.*;
import java.util.*;

public class entry_14914278 {
    static int intmax=Integer.MAX_VALUE;
    static int intmin=Integer.MIN_VALUE;
    static long longmin=Long.MIN_VALUE;
    static long longmax=Long.MAX_VALUE;
    static int[]spf;

    // Writing your solution here. -------------------------------------
    // 1) FIRST READ QUESTION PROPERLY 2 TIMES
    // 2) CHECK FOR LONG 
    public static void solve(MyScanner sc){
        int n=sc.nextInt();
        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            list.get(u).add(v);
            list.get(v).add(u);
        }
        int[] dis=new int[n+1];
        int a = helper(list,dis,n,1);
        int b = helper(list,dis,n,a);
        helper(list,dis,n,b);
        for (int i = 1; i <=n; i++) {
            out.print(dis[i]);
            out.print(" ");
        }
        out.println();
        // print("------------------------");
    }
    public static int helper(List<List<Integer>> list,int[] dis,int n,int st){
        Queue<Integer> q=new LinkedList<>();
        boolean[] visi=new boolean[n+1];
        int d=0;
        int res=0;
        q.add(st);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int curr=q.poll();
                res=curr;
                dis[curr]=Math.max(dis[curr],d);
                visi[curr]=true;
                for(int neg:list.get(curr)){
                    if(!visi[neg]){
                        q.add(neg);
                    }
                }
            }
            d++;
        }
        return res;
    }
    public static void brute(MyScanner sc){
        int n=sc.nextInt();
        // print("------------------------");
    }
    public static void main(String[] args) throws java.lang.Exception {

        MyScanner sc = new MyScanner();

        // int test = sc.nextInt();
        // while (test-->0) {
        //     solve(sc);
        // }

        solve(sc);

        /* --- Bruteforce Testing --- */
        // brute(sc);

        out.flush();
        out.close();
    }

    // -------------- Required Functions ------------------------------------- //
    public static boolean isPrime(int n) {
        if (n <= 1)return false;
        if (n == 2 || n == 3)return true;
        if (n % 2 == 0 || n % 3 == 0)return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)return false;
        }
        return true;
    }
    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
    public static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    public static List<Integer> getPrime(int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] visi = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!visi[i]) {
                list.add(i);
                for (long j = (long) i * i; j <= n; j += i) visi[(int) j] = true;
            }
        }
        return list;
    }
    public static void buildSPF(int MAX) {
        spf=new int[MAX+1];
        for (int i = 2; i <= MAX; i++) spf[i] = i;
        for (int i = 2; i * i <= MAX; i++) {
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j <= MAX; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
    }
    public static List<Integer> getPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        while (num > 1) {
            int p = spf[num];
            factors.add(p);   
            num /= p;         // Multiple prime number
            // while(num % p == 0) num/=p;  // Unique prime number
        }
        return factors;
    }
    public static long powerMod(long base, long exponent, long mod) {
        long result = 1;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1)result = (result * base) % mod;
            base = (base * base) % mod;
            exponent >>= 1;  
        }
        return result;
    }
    public static boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
    public static int[] countFrequency(int[] arr) {
        int maxValue=0;
        for(int num:arr)maxValue = Math.max(maxValue,num);
        int[] freq = new int[maxValue + 1];  
        for (int num : arr) freq[num]++;
        return  freq;
    }
    public static <T> void swap(T[] arr,int i,int j){
        T temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static boolean isSqr(long val) {
        return ((double)Math.sqrt(val)) == ((long)Math.sqrt(val));
    }
    public static void print(Object... values) {for (Object value : values)out.print(value + " ");
        out.println();}
    public static void print(char val){out.println(val);}
    public static void print(long val){out.println(val);}
    public static void print(int val){out.println(val);}
    public static void print(String val){out.println(val);}
    public static void print(StringBuilder sb){out.println(sb);}
    public static void print(Long[] arr){for(Long num:arr){out.print(num);out.print(" ");}
        out.println();} 
    public static void print(int[] arr){for(int num:arr){out.print(num);out.print(" ");}
        out.println();}
    public static void print(long[] arr){for(long num:arr){out.print(num);out.print(" ");}
        out.println();}
    public static void print(int[][] arr){for(int[] A:arr){for(int num:A)out.print(num+" ");
        out.println();}}
    public static void print(long[][] arr){for(long[] A:arr){for(long num:A)out.print(num+" ");
        out.println();}}
    public static void print(char[][] arr){for(char[] A:arr){for(char num:A)out.print(num+" ");
        out.println();}}
    public static <T> void print(List<T> list){for(Object num:list){out.print(num);out.print(" ");}
        out.println();}
    public static <T> void print(PriorityQueue<T> pq) {PriorityQueue<T> copy = new PriorityQueue<>(pq);  
        out.print("PQ => ");while (!copy.isEmpty()) {out.print(copy.poll());out.print(" ");}
        out.println();}
    public static <T> void print(Queue<T> queue){for(Object num:queue){
        out.print(num);out.print(" ");}out.println();}
    public static <K, V> void print(HashMap<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet())
            out.println("  " + entry.getKey() + " => " + entry.getValue());}
    public static <T> void print(HashSet<T> set){for(Object num:set){
        out.print(num);out.print(" ");}out.println();}

    // -------------- Required Classes -------------------------------------//
    public static class TrieNodeW{
        TrieNodeW[] next=new TrieNodeW[26];
        String word;
    }
    public static class TrieNodeB{
        TrieNodeB[] next=new TrieNodeB[2];
        int num;
    }
    // -----------PrintWriter for faster output------------------------------cmd
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    // -----------MyScanner class for faster input----------
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
        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        double nextDouble() {return Double.parseDouble(next());}
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        int[] nextArray(int n){
            int[] arr=new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=this.nextInt();
            }
            return arr;
        }
        long[] nextArrayL(int n){
            long[] arr=new long[n];
            for (int i = 0; i < n; i++) {
                arr[i]=this.nextLong();
            }
            return arr;
        }
        char[] nextArrayC(int n){
            return nextLine().toCharArray();
        }
        int[][] nextArray2d(int n,int m){
            int[][] arr=new int[n][m];
            for (int i = 0; i < n; i++) {
                for(int j=0;j<m;j++){
                    arr[i][j]=this.nextInt();
                }
            }
            return arr;
        }
    }
}