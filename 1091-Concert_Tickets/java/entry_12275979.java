// हर हर महादेव
//जय श्री राम
/************************************************************
 *                                                          *
 *                   Created by Ayush Raghuvanshi          *
 *                                                          *
 ************************************************************/

 import java.io.*;
 import java.util.*;

 public class entry_12275979 {

     // Constants
     static final int INTIFI = Integer.MAX_VALUE;
     static final int MOD = 1000000007;
     static final int MOD1 = 998244353;
     static final long INF = (long) 1e18;

     // Flag to determine if the code is running locally
     static boolean isLocal = System.getProperty("ONLINE_JUDGE") == null;

     public static void main(String[] args) {
         try {
             // if (isLocal) {
             //     // Redirect input and output for local testing
             //     System.setIn(new FileInputStream("input.txt"));
             //     System.setOut(new PrintStream(new FileOutputStream("output.txt")));
             // }
             FastReader in = new FastReader();
             FastWriter out = new FastWriter();

             int t = 1;

             // Uncomment the next line if multiple test cases are present
             // t = in.nextInt();

             while (t-- > 0) {
                 solve(in, out);
             }

             out.flush();
             out.close();
         } catch (Exception e) {
             if (isLocal) {
                 e.printStackTrace();
             }
             // On online judges, it's better not to print stack traces
         }
     }

     // Debug method: prints only when running locally
     static void debug(Object... o) {
         if (isLocal) {
             StringBuilder sb = new StringBuilder();
             for (Object obj : o) {
                 sb.append(deepToString(obj)).append(" ");
             }
             System.err.println(sb.toString().trim());
         }
     }

     static String deepToString(Object obj) {
         if (obj == null) {
             return "null";
         }

         Class<?> objClass = obj.getClass();

         if (objClass.isArray()) {
             if (obj instanceof Object[]) {
                 return Arrays.deepToString((Object[]) obj);
             } else if (obj instanceof int[]) {
                 return Arrays.toString((int[]) obj);
             } else if (obj instanceof long[]) {
                 return Arrays.toString((long[]) obj);
             } else if (obj instanceof double[]) {
                 return Arrays.toString((double[]) obj);
             } else if (obj instanceof float[]) {
                 return Arrays.toString((float[]) obj);
             } else if (obj instanceof boolean[]) {
                 return Arrays.toString((boolean[]) obj);
             } else if (obj instanceof char[]) {
                 return Arrays.toString((char[]) obj);
             } else if (obj instanceof byte[]) {
                 return Arrays.toString((byte[]) obj);
             } else if (obj instanceof short[]) {
                 return Arrays.toString((short[]) obj);
             } else {
                 return "Unknown array type";
             }
         }

         // For non-array objects, use their toString method
         return obj.toString();
     }

     static int check(long val, long x, long y) {
         if ((val >= x) && (val <= y)) {
             return 1;
         } else {
             return 0;
         }
     }

     static long calsum(int i, int a[], int n) {
         int maxi = a[i];
         int mini = a[i];
         long ans = 0;
         for (int j = i; j < i + n; j++) {
             maxi = Math.max(maxi, a[j]);
             mini = Math.min(mini, a[j]);
             ans += (maxi - mini);
         }
         debug(ans);

         return ans;
     }

     static class Pair {
         int x, y;

         Pair(int x, int y) {
             this.x = x;
             this.y = y;
         }

     }

     static int upperbound(ArrayList<Long> list, long target) {
         int left = 0;
         int right = list.size() - 1;
         int ans = -1;
         while (left <= right) {
             int mid = left + (right - left) / 2;
             if (list.get(mid) <= target) {
                 ans = mid;
                 right = mid - 1;
             } else {
                 right = mid - 1;
             }
         }
         return ans;
     }

     static void solve(FastReader in, FastWriter out) throws IOException {
         int n = in.nextInt();
         int m = in.nextInt();
         TreeMap<Integer, Integer> tickets = new TreeMap<>();

         for (int i = 0; i < n; i++) {
             int price = in.nextInt();
             tickets.merge(price, 1, Integer::sum);
         }

         for (int i = 0; i < m; i++) {
             int maxPrice = in.nextInt();
             Map.Entry<Integer, Integer> entry = tickets.floorEntry(maxPrice);

             if (entry == null) {
                 out.println("-1");
             } else {
                 out.println(entry.getKey());
                 if (entry.getValue() == 1) {
                     tickets.remove(entry.getKey());
                 } else {
                     tickets.put(entry.getKey(), entry.getValue() - 1);
                 }
             }
         }
     }

     static long abs(long a) {
         if (a < 0) {
             return -a;
         }
         return a;
     }

     static long getmin(long[] a) {
         long min = a[0];
         for (int i = 1; i < a.length; i++) {
             if (a[i] < min) {
                 min = a[i];
             }
         }
         return min;
     }

     static void reverse(int arr[]) {
         // reverse the array
         int n = arr.length;
         for (int i = 0; i < n / 2; i++) {
             int temp = arr[i];
             arr[i] = arr[n - i - 1];
             arr[n - i - 1] = temp;
         }
     }

     // -------------------- Utility Functions --------------------

     // FastReader Class for Fast Input
     static class FastReader {
         private final int BUFFER_SIZE = 1 << 16;
         private DataInputStream din;
         private byte[] buffer;
         private int bufferPointer, bytesRead;

         public FastReader() {
             din = new DataInputStream(System.in);
             buffer = new byte[BUFFER_SIZE];
             bufferPointer = bytesRead = 0;
         }

         public FastReader(String file_name) throws IOException {
             din = new DataInputStream(new FileInputStream(file_name));
             buffer = new byte[BUFFER_SIZE];
             bufferPointer = bytesRead = 0;
         }

         public String readLine() throws IOException {
             byte[] buf = new byte[64]; // line length
             int cnt = 0, c;
             while ((c = read()) != -1) {
                 if (c == '\n')
                     break;
                 buf[cnt++] = (byte) c;
             }
             return new String(buf, 0, cnt);
         }

         public int nextInt() throws IOException {
             int ret = 0;
             byte c = read();
             while (c <= ' ')
                 c = read();
             boolean neg = (c == '-');
             if (neg)
                 c = read();
             do {
                 ret = ret * 10 + c - '0';
             } while ((c = read()) >= '0' && c <= '9');
             if (neg)
                 return -ret;
             return ret;
         }

         public long nextLong() throws IOException {
             long ret = 0;
             byte c = read();
             while (c <= ' ')
                 c = read();
             boolean neg = (c == '-');
             if (neg)
                 c = read();
             do {
                 ret = ret * 10 + c - '0';
             } while ((c = read()) >= '0' && c <= '9');
             if (neg)
                 return -ret;
             return ret;
         }

         public double nextDouble() throws IOException {
             double ret = 0, div = 1;
             byte c = read();
             while (c <= ' ')
                 c = read();
             boolean neg = (c == '-');
             if (neg)
                 c = read();
             do {
                 ret = ret * 10 + c - '0';
             } while ((c = read()) >= '0' && c <= '9');
             if (c == '.') {
                 while ((c = read()) >= '0' && c <= '9') {
                     ret += (c - '0') / (div *= 10);
                 }
             }
             if (neg)
                 return -ret;
             return ret;
         }

         public String next() throws IOException {
             StringBuilder sb = new StringBuilder();
             byte c;
             while ((c = read()) <= ' ') {
                 if (c == -1)
                     throw new IOException();
             }
             do {
                 sb.append((char) c);
             } while ((c = read()) > ' ');
             return sb.toString();
         }

         private void fillBuffer() throws IOException {
             bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
             if (bytesRead == -1)
                 buffer[0] = -1;
         }

         private byte read() throws IOException {
             if (bufferPointer == bytesRead)
                 fillBuffer();
             return buffer[bufferPointer++];
         }

         public void close() throws IOException {
             if (din == null)
                 return;
             din.close();
         }
     }

     // FastWriter Class for Fast Output
     static class FastWriter {
         private final BufferedOutputStream out;

         public FastWriter() {
             out = new BufferedOutputStream(System.out);
         }

         public void print(String s) throws IOException {
             out.write(s.getBytes());
         }

         public void println(String s) throws IOException {
             print(s);
             out.write('\n');
         }

         public void println(int x) throws IOException {
             println(String.valueOf(x));
         }

         public void println(long x) throws IOException {
             println(String.valueOf(x));
         }

         public void flush() throws IOException {
             out.flush();
         }

         public void close() throws IOException {
             out.close();
         }
     }

     // Exponentiation: (a^b) % mod
     static long expo(long a, long b, long mod) {
         long res = 1;
         a %= mod;
         while (b > 0) {
             if ((b & 1) == 1)
                 res = (res * a) % mod;
             a = (a * a) % mod;
             b >>= 1;
         }
         return res;
     }

     // Extended GCD: returns array [x, y, gcd(a,b)] such that ax + by = gcd(a,b)
     static long[] extendGCD(long a, long b) {
         if (b == 0)
             return new long[] { 1, 0, a };
         long[] vals = extendGCD(b, a % b);
         long x = vals[1];
         long y = vals[0] - vals[1] * (a / b);
         return new long[] { x, y, vals[2] };
     }

     // Modular Inverse (for non-prime modulus)
     static long mminv(long a, long b) {
         long[] vals = extendGCD(a, b);
         return vals[0];
     }

     // Modular Inverse (for prime modulus)
     static long mminvprime(long a, long mod) {
         return expo(a, mod - 2, mod);
     }

     // Sieve of Eratosthenes: returns list of primes up to n
     static List<Long> sieve(int n) {
         boolean[] isPrime = new boolean[n + 1];
         Arrays.fill(isPrime, true);
         isPrime[0] = isPrime[1] = false;
         for (int i = 2; i * i <= n; i++) {
             if (isPrime[i]) {
                 for (int j = i * 2; j <= n; j += i)
                     isPrime[j] = false;
             }
         }
         List<Long> primes = new ArrayList<>();
         for (int i = 2; i <= n; i++) {
             if (isPrime[i])
                 primes.add((long) i);
         }
         return primes;
     }

     // Modular Operations
     static long modAdd(long a, long b, long mod) {
         a %= mod;
         b %= mod;
         return (a + b + mod) % mod;
     }

     static long modMul(long a, long b, long mod) {
         a %= mod;
         b %= mod;
         return (a * b) % mod;
     }

     static long modSub(long a, long b, long mod) {
         a %= mod;
         b %= mod;
         return (a - b + mod) % mod;
     }

     static long modDiv(long a, long b, long mod) {
         a %= mod;
         b %= mod;
         return (modMul(a, mminvprime(b, mod), mod)) % mod;
     }

     // Binary Search: returns index of target in sorted list, or -1 if not found
     static int binarySearch(List<Long> list, long target) {
         int left = 0;
         int right = list.size() - 1;

         while (left <= right) {
             int mid = left + (right - left) / 2;
             long midVal = list.get(mid);

             if (midVal == target)
                 return mid;
             if (midVal < target)
                 left = mid + 1;
             else
                 right = mid - 1;
         }

         return -1;
     }

     // Decimal to Binary Conversion
     static String decimalToBinary(long decimal) {
         return Long.toBinaryString(decimal);
     }

     // Binary to Decimal Conversion
     static long binaryToDecimal(String binary) {
         return Long.parseLong(binary, 2);
     }

     // Sort and Rearrange two lists based on the sorting of the first list
     static void sortAndRearrange(List<Long> a, List<Long> b) {
         List<Integer> indices = new ArrayList<>();
         for (int i = 0; i < a.size(); i++)
             indices.add(i);

         indices.sort(Comparator.comparingLong(a::get));

         List<Long> a_sorted = new ArrayList<>();
         List<Long> b_sorted = new ArrayList<>();

         for (int idx : indices) {
             a_sorted.add(a.get(idx));
             b_sorted.add(b.get(idx));
         }

         a.clear();
         a.addAll(a_sorted);
         b.clear();
         b.addAll(b_sorted);
     }

     // Compute GCD using Stein's Algorithm (Binary GCD)
     static long gcd(long a, long b) {
         if (a == 0)
             return b;
         if (b == 0)
             return a;

         // Find common factors of 2
         int shift;
         for (shift = 0; ((a | b) & 1) == 0; ++shift) {
             a >>= 1;
             b >>= 1;
         }

         // Make 'a' odd
         while ((a & 1) == 0)
             a >>= 1;

         while (b != 0) {
             // Make 'b' odd
             while ((b & 1) == 0)
                 b >>= 1;

             // Now both 'a' and 'b' are odd. Swap if necessary so a <= b,
             // then set b = b - a (which is even)
             if (a > b) {
                 long temp = a;
                 a = b;
                 b = temp;
             }

             b = b - a;
         }

         // Restore common factors of 2
         return a << shift;
     }

     // Check if a number is prime
     static boolean isPrime(long n) {
         if (n <= 1)
             return false;
         if (n <= 3)
             return true;
         if (n % 2 == 0 || n % 3 == 0)
             return false;

         for (long i = 5; i * i <= n; i += 6) {
             if (n % i == 0 || n % (i + 2) == 0)
                 return false;
         }

         return true;
     }
 }