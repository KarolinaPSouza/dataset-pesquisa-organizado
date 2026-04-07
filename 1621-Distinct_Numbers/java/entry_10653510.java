import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class entry_10653510 {

    // static  long mod=998244353;
    static int mod = (int)(1e9 + 7);
    static boolean MULTI_CASE = false;
    static Integer dp[][][][];
    static boolean print = false;
    static int limit;
    static List<Integer> numbers;



   public static void solve() throws IOException {
        int n = sc.nextInt();
        HashSet<Long> set = new HashSet<>();
        for(int i = 0; i<n; i++) set.add(sc.nextLong());
        out.println(set.size());

    }

    public static Set<String> generatePermutations(String s) {
        Set<String> permutations = new TreeSet<>();
        permute(s.toCharArray(), 0, permutations);
        return permutations;
    }

    private static void permute(char[] chars, int index, Set<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            permute(chars, index + 1, result);
            swap(chars, i, index);  // backtrack
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static void reverse(long[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            long temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


    public static long naturalSum(long n) {
        return 1l * (n) * ( n + 1l) / 2l;
    }

    public static long firstOddSum(long n) {
        return 1l * (n) * (n) ;
    }
    public static long firstEvenSum(long n) {
        return 1l * (n) * ( n + 1l) ;
    }

    private static long arithmeticSum(long start, long length) {
        return length * (2 * start + (length - 1)) / 2;
    }


    public static boolean kSmallest(long val, int k, int[] res) {
        int cnt = 0;
        for(int i : res) {
            if(i <= val)
                cnt++;
        }

        return val >= k + cnt - 1;
    }



    public static void decrementCountMap(Map<Long, Integer> map, long key) {
        if (map.containsKey(key)) {
            int count = map.get(key);
            if (count == 1) {
                map.remove(key);
            } else {
                map.put(key, count - 1);
            }
        }
    }

    public static void updateCountMap(Map<Long, Integer> map, long key) {
        int count = 0;
        if (map.containsKey(key)) {
            count = map.get(key);
        }
        map.put(key, count + 1);
    }


    private static long median(long arr[]) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = arr.length;
        n = (n + 1) / 2;
        for(long i: arr) {
            pq.add(i);
            if(pq.size() > n) pq.remove();
        }
        return pq.size() > 0 ? pq.peek() : 0;
    } 


    public static String DecimalToBase(long number, int base) {

        StringBuilder conv = new StringBuilder();
        while (number > 0) {
            conv.append(number % base);
            number /= base;
        }
        return conv.reverse().toString();
    }

    //without a digit
    public static long BaseToDecimal(String base, int dig) {
        long result = 0;
        for (char digit : base.toCharArray()) {
            result *= 10;
            int baseDigit = digit - '0';
            result += (baseDigit >= dig) ? (baseDigit + 1) : baseDigit;
        }
        return result;
    }

    public static boolean isNonDecreasing(long[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }


    static long ncr(int n, int r) {
        long sum = 1l;
        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) / i;
        }
        return sum;
    }


    static long fact(int n) {
        return (n == 1 || n == 0) ? 1l : 1l * n * fact(n - 1);
    }

    static int mod_mul(int x, int y) {
        return (int)((long)((x % mod) * (y % mod)) % mod);
    }

    static int mod_add(int x, int y) {
        return (int)((long)((x % mod) + (y % mod)) % mod);
    }


    static long modinv(long x, long mod) {
        return fast_pow(x, mod - 2);
    }

    static long fast_pow(long a, long b) {
        if(b == 0)
            return 1L;

        long val = fast_pow(a, b / 2);

        if(b % 2 == 0)
            return val * val % mod;
        else 
            return val * val % mod * a % mod;
    }




    static boolean[] sieveOfEratosthenes(int n)
    {
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;

    }

    static List<Integer> generatePrimes(int n) {
        boolean sieve[] = sieveOfEratosthenes(n);
        List<Integer> primes = new ArrayList<>(); 
        for(int i = 2; i<=n ;i++) {
            if(sieve[i]) primes.add(i);
        }
        return primes;
    }

    static int[] singlePrimeFactor(int n) {
        int prime[] = new int[n + 1];
        for(int i = 0; i<=n ;i++) prime[i] = i;

        for(int i = 2; i * i<=n; i++) {
            if(prime[i] == i) {
                for(int j = i * i; j <= n; j += i) {
                    prime[j] = i;
                }
            }
        }

        return prime;
    }

    static List<Integer> primeFactor(int n)
    {
        List<Integer> fact = new ArrayList<>();
        List<Integer> prime = generatePrimes(n);

        for(int i = 0; prime.get(i) * prime.get(i) <= n && i < prime.size(); i++) {
            if(n % prime.get(i) == 0) {
                while(n % prime.get(i) == 0) {
                    n /= prime.get(i);
                    fact.add(prime.get(i));
                }
            }
        }

        if(n > 1) {
            fact.add(n);
        }

        Collections.sort(prime);

        return prime;

    }

    static long lcm_of_array(List<Long> arr)
    {
        long lcm = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            long num1 = lcm;
            long num2 = arr.get(i);
            long gcd_val = gcdl(num1, num2);
            lcm = (lcm * arr.get(i)) / gcd_val;
        }
        return lcm;
    }


    static int gcdi(int a,int b)
    {
        if(b==0) return a;

        return gcdi(b,a%b);
    }

    static long gcdl(long a,long b)
    {
        if(b==0) return a;

        return gcdl(b,a%b);
    }

    static boolean isPrime(int n)
    {
        if (n <= 1) 
            return false; 

        if (n == 2 || n == 3) 
            return true; 

        if (n % 2 == 0 || n % 3 == 0) 
            return false; 

        for (int i = 5; i < Math.sqrt(n); i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 

        return true; 

    }

    public static void main(String[] args) throws IOException {
        if (MULTI_CASE) {
          int T = sc.nextInt();
          for (int i = 0; i < T; ++i) {
            // if(i == 15) print = true;
            solve();
          }
        } 
        else {
          solve();
        }
        out.close();
    }

  static InputReader sc = new InputReader();
  static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  static class InputReader {
    private StringTokenizer st;
    private BufferedReader bf;

    public InputReader() {
      bf = new BufferedReader(new InputStreamReader(System.in));
      st = null;
    }

    public String next() throws IOException {
      while (st == null || !st.hasMoreTokens()) {
        st = new StringTokenizer(bf.readLine());
      }
      return st.nextToken();
    }

    public String nextLine() throws IOException {
      return bf.readLine();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
      return Double.parseDouble(next());
    }
  }
}
class Pair {
    int first;
    int second;
    Pair(int a, int b) {
        first = a;
        second = b;
    }
}
class Node {
    long val;
    List<Node> child;

    Node(long a) {
        val = a;
        child = new ArrayList<>();
    }
}