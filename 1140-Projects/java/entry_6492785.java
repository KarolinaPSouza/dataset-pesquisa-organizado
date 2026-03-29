import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import static java.util.Collections.*; 

public class entry_6492785 {
    static FastInput sc;
    static PrintWriter out;
    final static int MOD = (int)(1e9+7);
    final static int MAX = Integer.MAX_VALUE;
    final static int MIN = Integer.MIN_VALUE;

    // MAIN
    public static void main(String[] args) throws IOException {
        sc = new FastInput();
        out = new PrintWriter(System.out);
        int t = 1;
        // t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    static Set<Long> set = new HashSet<>();
    private static void solve() throws IOException {
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

 int n = sc.nextInt();
    int end[]= new int[n];
    int arr[][] = new int[n][3];
    for(int i=0 ; i< n ; i++){
     for(int j =0 ; j<3; j++){
      arr[i][j] = sc.nextInt();
      if(j==1){
       end[i]= arr[i][j];
      }
     }
    }

   Arrays.sort(end);
   Arrays.sort(arr, (a, b) -> Integer.compare(a[1],b[1]));

    long dp[]= new long[n];
    dp[0]= arr[0][2];
    for(int i=1; i< n ; i++){
     int st = arr[i][0];

     int lb =0; 
   int ub = i;
     while(lb<=ub){
      int m =(lb+ub)/2;
      if(end[m] == st){
       ub = m-1;
       break;
      }else if(end[m] > st){
       ub =m-1;
      }else{
       lb =m+1;
      }
     }
     long opt1 = (long)arr[i][2];
     long opt2= dp[i-1];

     if(ub!=-1){
      opt1 +=dp[ub];
     }
     dp[i]= Math.max(opt1,opt2);

    }

    // out.println(Arrays.toString(dp))                                                                                                    ;
    out.println(dp[n-1]);

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }
    private static long sqrt(long x) {
        long left = 0, right = Long.MAX_VALUE;
        while (right > left) {
            long mid = (left + right) / 2;

            if (mid * mid > x)
                right = mid;
            else
                left = mid + 1;
        }
        return left - 1;
    }
    private static long pow(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
          if ((exponent & 1) == 1) {
            result *= base;
          }
          base *= base;
          exponent >>= 1;
        }
        return result;
    }
    private static void sort(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list);
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }

    private static void sort(char[] arr) {
        int n = arr.length;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list);
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }
    private static void rsort(char[] arr) {
        int n = arr.length;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }

    private static void rsort(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < n; i++)
        arr[i] = list.get(i);
    }

    private static void sort(long[] arr) {
        int n = arr.length;
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list);
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }

    private static void rsort(long[] arr) {
        int n = arr.length;
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }

    static long nCr(long n, long r) {
        long answer = 1;
        long k = min(r, n - r);
        for (long i = 0; i < k; i++) {
            answer = (answer % MOD * (n - i) % MOD) % MOD;
            answer = divide(answer, i + 1);
        }
        return answer % MOD;
    }

    static long divide(long a, long b) {
        return (a % MOD * (power(b, MOD - 2) % MOD)) % MOD;
    }

    static int LowerBound(int a[], int x) {
        int l=-1,r=a.length;
        while(l<r) {
            int m=(l+r)>>>1;
            if(a[m]>=x) r=m-1;
            else l=m+1;
        }
        return r;
    }
    static int UpperBound(int a[], int x) {
        int l=-1,r=a.length;
        while(l+1<r) {
            int m=(l+r)>>>1;
            if(a[m]<=x) l=m;
            else r=m;
        }
        return l+1;
    }
    private static void swap(int[] a,int i,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void swap(long[] a,int i,int j){
        long t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void swap(char[] a,int i,int j){
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void reverse(int[] a){
        int i = 0, j = a.length-1;
        while(i < j) swap(a, i++, j--);
    }
    private static void reverse(long[] a){
        int i = 0, j = a.length-1;
        while(i < j) swap(a, i++, j--);
    }
    private static void reverse(char[] a){
        int i = 0, j = a.length-1;
        while(i < j) swap(a, i++, j--);
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    private static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    private static long power(long a, long b) {
        if (b == 0)
            return 1L;
        long ans = power(a, b / 2);
        ans *= ans;
        if ((b & 1) == 1)
            ans *= a;
        return ans;
    }

    private static int mod_power(int a, int b) {
        if (b == 0)
            return 1;
        int temp = mod_power(a, b / 2);
        temp %= MOD;
        temp = (int) ((1L * temp * temp) % MOD);
        if ((b & 1) == 1)
            temp = (int) ((1L * temp * a) % MOD);
        return temp;
    }

    private static int multiply(int a, int b) {
        return (int) ((((1L * a) % MOD) * ((1L * b) % MOD)) % MOD);
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    private static boolean isPrime(long n) {
        for (long i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    // STRING FUNCTIONS
    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j)
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        return true;
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    private static String sortString(String str) {
        int[] arr = new int[256];
        for (char ch : str.toCharArray())
            arr[ch]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++)
            while (arr[i]-- > 0)
                sb.append((char) i);
        return sb.toString();
    }
    // INPUT
    static class FastInput {
        BufferedReader br;
        StringTokenizer st;

        FastInput() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(nextLine());
            return st.nextToken();
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextCharacter() throws IOException {
            return next().charAt(0);
        }

        String nextLine() throws IOException {
            return br.readLine().trim();
        }

        int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }

        int[][] next2DIntArray(int n, int m) throws IOException {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                arr[i] = nextIntArray(m);
            return arr;
        }

        long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextLong();
            return arr;
        }

        long[][] next2DLongArray(int n, int m) throws IOException {
            long[][] arr = new long[n][m];
            for (int i = 0; i < n; i++)
                arr[i] = nextLongArray(m);
            return arr;
        }

        List<Integer> nextIntList(int n) throws IOException {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++)
                list.add(nextInt());
            return list;
        }

        List<Long> nextLongList(int n) throws IOException {
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < n; i++)
                list.add(nextLong());
            return list;
        }

        char[] nextCharArray(int n) throws IOException {
            return next().toCharArray();
        }

        char[][] next2DCharArray(int n, int m) throws IOException {
            char[][] mat = new char[n][m];
            for (int i = 0; i < n; i++)
                mat[i] = nextCharArray(m);
            return mat;
        }
    }

    // OUTPUT
    private static void printIntList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            out.print(list.get(i) + " ");
        out.println(" ");
    }

    private static void printLongList(List<Long> list) {
        for (int i = 0; i < list.size(); i++)
            out.print(list.get(i) + " ");
        out.println(" ");
    }

    private static void printIntArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            out.print(arr[i] + " ");
        out.println(" ");
    }

    private static void print2DIntArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            printIntArray(arr[i]);
    }

    private static void printLongArray(long[] arr) {
        for (int i = 0; i < arr.length; i++)
            out.print(arr[i] + " ");
        out.println(" ");
    }

    private static void print2DLongArray(long[][] arr) {
        for (int i = 0; i < arr.length; i++)
            printLongArray(arr[i]);
    }
}  