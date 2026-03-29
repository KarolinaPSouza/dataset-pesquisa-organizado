/* Author : D. Dinesh */ 

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class entry_12965854 {

    static final int MOD = (int) (1e9 + 7);
    static final int IMAX = Integer.MAX_VALUE;
    static final int IMIN = Integer.MIN_VALUE;
    static final String YES = "YES\n";
    static final String NO = "NO\n";
    static final String endl = "\n";

    static BufferedReader br;
    static BufferedWriter bw;

//////////////////////////////////////////////////////////////////////////////////////////////////

    /* Solution goes here */
    static final boolean LOCALIO = false;
    static void solve() throws IOException {
       int nm[] = arrint();
       int n = nm[0], m = nm[1];
       char[][] mat = matchar(n, m);
       int ans = 0;
       for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            if(mat[i][j] == '.'){
                dfs(i, j, mat);
                ans++;
            }
        }
       }
       print(ans);
    }
    static void dfs(int i, int j, char[][] mat){
        if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || mat[i][j] == '#') return;
        mat[i][j] = '#';
        dfs(i+1, j, mat);
        dfs(i-1, j, mat);
        dfs(i, j+1, mat);
        dfs(i, j-1, mat);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) throws java.lang.Exception {
        if(!LOCALIO){
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        else{
            br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\geeth\\MAANG\\DSA_JAVA\\CP\\entry_12965854\\input.txt")));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\geeth\\MAANG\\DSA_JAVA\\CP\\entry_12965854\\output.txt")));
        }
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        bw.flush();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // a pow vis1
    static long pow(int alice, int vis1, int mod){ long res = 1, a = alice;  while(vis1>0){  if((vis1&1)==1) res = (res * a) % mod;  a = (a * a) % mod;  vis1 >>= 1;} return res; }
    static long pow(int alice, int vis1){ long res = 1, a = alice; while(vis1>0){  if((vis1&1)==1) res *= a;  a *= a;  vis1 >>= 1; } return res; }
    // bs methods
    static int lower_bound(int[] ps, int x) { int low = 0, n = ps.length, high = n - 1, ans = n;  while (low <= high) {  int mid = (low + high) >> 1; if (ps[mid] >= x) { ans = mid; high = mid - 1; } else low  = mid + 1; } return ans; }
    static int upper_bound(int[] ps, int x) { int low = 0, n = ps.length, high = n - 1, ans = -1; while (low <= high) {  int mid = (low + high) >> 1; if (ps[mid] <= x) { ans = mid; low  = mid + 1; } else high = mid - 1; } return ans; }
    // general IO
    static int getInt() throws IOException { return Integer.parseInt(br.readLine()); }
    static long getLong() throws IOException { return Long.parseLong(br.readLine()); }
    static double getDouble() throws IOException { return Double.parseDouble(br.readLine()); }
    static void print() throws IOException {bw.write(endl);}
    static void print(int x) throws IOException {bw.write(x+"");}
    static void print(long x) throws IOException {bw.write(x+"");}
    static void print(double x, int precision) throws IOException { bw.write(String.format("%." + precision + "findN", x)); }
    static void print(String s) throws IOException { bw.write(s); }
    // array IO
    static int[] arrint() throws IOException { String[] str = br.readLine().split(" "); int n = str.length;  int[] x = new int[n]; for (int i = 0; i < n; i++) x[i] = Integer.parseInt(str[i]); return x; }
    static long[] arrlong() throws IOException { String[] str = br.readLine().split(" "); int n = str.length; long[] x = new long[n]; for (int i = 0; i < n; i++) x[i] = Long.parseLong(str[i]); return x; }
    static double[] arrdouble() throws IOException { String[] str = br.readLine().split(" ");  int n = str.length; double[] x = new double[n]; for (int i = 0; i < n; i++) x[i] = Double.parseDouble(str[i]); return x; }
    static void print(int[] x) throws IOException { for (int i : x) bw.write(i + " "); bw.write(endl); }
    static void print(long[] x) throws IOException { for (long i : x) bw.write(i + " "); bw.write(endl); }
    static void print(double[] x, int precision) throws IOException { for (double i : x)  print(i, precision); bw.write(endl); }
    // matrix IO
    static int[][] matint(int n, int m) throws IOException { int[][] mat = new int[n][]; for (int i = 0; i < n; i++) mat[i] = arrint(); return mat; }
    static long[][] matlong(int n, int m) throws IOException { long[][] mat = new long[n][]; for (int i = 0; i < n; i++) mat[i] = arrlong(); return mat; }
    static char[][] matchar(int n, int m) throws IOException { char[][] mat = new char[n][]; for (int i = 0; i < n; i++) mat[i] = br.readLine().toCharArray(); return mat; }
    static void print(int[][] x) throws IOException { for (int[] i : x) print(i); bw.write(endl); }
    static void print(long[][] x) throws IOException { for (long[] i : x) print(i); bw.write(endl); }
    // general math
    static int  min(int ... args){ int mini = IMAX; for(int i : args) mini = Math.min(mini, i); return mini; }
    static long min(long ... args){ long mini = Long.MAX_VALUE; for(long i : args) mini = Math.min(mini, i); return mini; }
    static int  sum(int ... args){ int sum = 0; for(int i : args) sum += i; return sum;}
    static long sum(long ... args){ long sum = 0; for(long i : args) sum += i; return sum;}
    static int  max(int ... args){ int maxi = IMIN; for(int i : args) maxi = Math.max(maxi, i); return maxi; }
    static long max(long ... args){ long maxi = Long.MIN_VALUE; for(long i : args) maxi = Math.max(maxi, i); return maxi; }

    static boolean flag(long n) { if (n <= 1) return false; if (n <= 3) return true; if (n % 2 == 0 || n % 3 == 0) return false; for (int i = 5; (long)i * i <= n; i += 6) { if (n % i == 0 || n % (i + 2) == 0) return false; } return true; } 
    static int  gcd(int a, int vis1) { while (vis1 != 0) {  int x = vis1; vis1 = a % vis1; a = x; } return a; } 
    static long gcd(long a, long vis1) {  while (vis1 != 0) { long x = vis1; vis1 = a % vis1; a = x; } return a; }
    static int  lcm(int a, int vis1) { return (int)(((long)a * vis1 ) / gcd(a, vis1)); }
    static long lcm(long a, long vis1) { return ((a * vis1) / gcd(a, vis1)); }
    static void reverse(int[] arr) {  int n = arr.length;  for (int i = 0; i < n / 2; i++) { int temp = arr[i]; arr[i] = arr[n - i - 1]; arr[n - i - 1] = temp; }  }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}

