import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * this is my template that I use in order to solve problems
 *
 * @author Ahmed Hussein
 */

public class entry_6572621 {
    static PrintWriter pw = new PrintWriter(System.out);
    static long mod = 1000000007;
    static long fac[];
    static long inv[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
        int t = 1;
        while (t-->0){
            long n = sc.nextLong();
            int k = sc.nextInt();
            long [] arr = sc.nextlongArray(k);
            long ans = 0L;
            int mask = 1;
            while (mask < (1<<k)){
                int count = Integer.bitCount(mask);
                long tmp = n;
                for(int i = 0 ; i < k ; i++){
                    if((mask & (1<<i)) != 0){
                        tmp /= arr[i];
                    }
                }
                if(count % 2 == 0) ans -= tmp ;
                else ans += tmp;
                mask ++;
            }
            pw.println(ans);
        }
        pw.close();
    }

    // calculate the result when raising a long to an integer value O(log e)
    static long pow(long a, long e, long mod) {
        long res = 1L;
        while (e > 0) {
            if ((e & 1) == 1) res = modMul(res , a , mod);
            a = modMul(a,a,mod);
            e >>= 1L;
        }
        return res;
    }

    private static long modMul (long x , long y , long m){
        BigInteger xb = new BigInteger(Long.toString(x));
        BigInteger yb = new BigInteger(Long.toString(y));
        BigInteger mb = new BigInteger(Long.toString(m));
        xb = (xb.mod(mb)).multiply(yb.mod(mb)).mod(mb);
        return xb.longValue();
    }

    private static boolean fastPrimeCheck(long num){
        long [] sprp = {2, 325, 9375, 28178, 450775, 9780504, 1795265022};
        if (num == 2) return true;
        if (num < 2 || num % 2 == 0) return false;
        long t = 0, u = num - 1;
        for (; u % 2 == 0; t++) u >>= 1;
        for (int i = 0; i < 7; i++) {
            long a = sprp[i] % num;
            if (a == 0 || a == 1 || a == num - 1) continue;
            long x = pow(a, u, num);
            if (x == 1 || x == num - 1) continue;
            for (int j = 1; j < t; j++) {
                x = modMul(x, x, num);
                if (x == 1) return false;
                if (x == num - 1) break;
            }
            if (x == num - 1) continue;
            return false;
        }
        return true;
    }

    private static long f (long x , long mod){
        return (modMul(x,x,mod) +1 )%mod ;
    }
    private static long pollard_rho(long n) {
        if ((n & 1) != 1) return 2;
        if(n == 1) return 1;
        while (true) {
            long y = 2, x = (new Random()).nextLong() % (n - 1) + 1, res = 1;
            for (int sz = 2; res == 1; sz *= 2) {
                for (int i = 0; i < sz && res <= 1; i++) {
                    x = f(x, n);
                    res = GCD(Math.abs(x - y), n);
                }
                y = x;
            }
            if (res != 0 && res != n) return res;
        }
    }
    private static void factorize(long n, ArrayList<Long> ans) {
        if (fastPrimeCheck(n))
            ans.add(n);
        else {
            long p = pollard_rho(n);
            if(p == 1) return;
            factorize(p, ans);
            factorize(n / p, ans);
        }
    }


    // gets the floor of log x base 2
    private static int bs_log(int x){
        int low = 0 , high = 20 , ans = -1 ;
        while(low<= high){
            int mid = low + (high - low) / 2 ;
            if((1<<mid) <= x){
                ans = mid ;
                low = mid +1 ;
            }
            else
                high = mid -1;
        }
        return ans ;
    }

    // gets the floor of the square root of a long
    private static long bs_sqrt(long x){
        long low = 0 , high = 2000000123 ;
        while (low  <= high){
            long mid = low + (high-low)/2 ;
            if(mid*mid > x){
                high = mid;
            }else
                low = mid+1;
        }
        return low-1;
    }

    public static long modinverse(long a, long mod) {
        return pow(a, mod - 2, mod);
    }

    public static pair<Long,Long> extendedEuclid(int a, int b) {
        if(b == 0) { return new pair<> (1L, 0L); }
        pair<Long,Long> z = extendedEuclid(b, a % b);
        long x1 = (long) z.y;
        long y1 = z.x - a / b * z.y;
        return new pair<> (x1, y1);
    }

    public static long GCD(long a, long b) {
        if (b == 0)
            return a;
        if (a == 0)
            return b;
        return (a > b) ? GCD(a % b, b) : GCD(a, b % a);
    }

    public static long LCM(long a, long b) {
        return a * b / GCD(a, b);
    }

    static void facc(int n) {
        fac = new long[n];
        inv = new long[n];
        fac[0] = 1;
        for (int i = 1; i < n; i++) {
            fac[i] = (fac[i - 1] * i) % mod;
        }
        inv[0]=1;
        inv[1] = 1;
        for(int i = 2; i < n; i++)
            inv[i] = mod - (mod/i) * inv[(int)(mod%i)] % mod;
        for(int i=2;i<n;i++) {
            inv[i]*=inv[i-1];
            inv[i]%=mod;
        }

    }
    static long nc(int n, int r) {
        if (n < r)
            return 0;

        return ((fac[n] * inv[n - r]) % mod * inv[r]) % mod;
    }

    static long np(int n, int r) {
        return (nc(n, r) * fac[r]) % mod;
    }

    static long catlan(int n) {
        nc(0, 1);
        return ((fac[2 * n] * inv[n]) % mod * inv[n + 1]) % mod;
    }

    static long strling(int n, int r) {
        long ret=0;
        for(int i=0;i<r;i++){
            ret+=nc(r,i)* pow(r-i,n,mod)*(i%2==0?1:-1);
            ret%=mod;
        }
        ret+=mod;
        return (ret*inv[r])%mod;
    }

    static class pair <T,V> {
        T x;
        V y;

        public pair(T x, V y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
        }

        public boolean equals(pair<T,V> p) {
            return p.x.equals(x) && p.y.equals(y) ;
        }
    }

    static class tuple<T,V,E> {
        T x ;
        V y ;
        E z ;
        public tuple(T x,V y,E z){
            this.x = x ;
            this.y = y ;
            this.z = z ;
        }
        public String toString(){
            return x.toString() + " " + y.toString() + " " + z.toString() ;
        }
        public boolean equals(tuple<T,V,E> t){
            return t.x.equals(x) && t.y.equals(y) && t.z.equals(z) ;
        }

    }

    static class Node <T> {
        T data ;
        Node<T> next ;
        Node<T> prev ;
        public Node (T data){
            this.data = data ;
        }
    }
    static class LinkList <T> {
        Node<T> head ;
        Node<T> tail ;
        int size ;

        public void addFront(T item){
            if(head == null){
                head = tail = new Node<>(item);
            }
            else{
                Node<T> tmp = new Node<>(item);
                tmp.next = head ;
                head.prev = tmp ;
                head = tmp ;
            }
            size++;
        }

        public void addLast(T item){
            if(head == null){
                head = tail = new Node<>(item);
            }
            else{
                Node<T> tmp = new Node<>(item);
                tail.next = tmp ;
                tmp.prev = tail ;
                tail = tmp ;
            }
            size++;
        }

        public T removeLast (){
            T tmp = tail.data ;
            if(head == tail){
                head = tail = null ;
            }
            else{
                tail = tail.prev ;
            }
            size--;
            return tmp ;
        }

        public T removeFirst (){
            T tmp = head.data ;
            if(head == tail){
                head = tail = null ;
            }
            else{
                head = head.next ;
            }
            size--;
            return tmp ;
        }

        public T getFront (){
            return head.data ;
        }

        public T getLast (){
            return tail.data ;
        }

        public void append (LinkList<T> listToBeAppended){
            if(listToBeAppended.isEmpty()){
                return;
            }
            if(this.isEmpty()){
                this.head = listToBeAppended.head;
                this.tail = listToBeAppended.tail;
            }
            this.tail.next = listToBeAppended.head;
            listToBeAppended.head.prev = this.tail;
            this.tail = listToBeAppended.tail;
            this.size += listToBeAppended.size ;
        }

        public boolean isEmpty(){
            return head == null ;
        }

    }
    static class Scanner {

        StringTokenizer st;
        BufferedReader br;
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }
        public Scanner(String file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }
        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }
        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String readAllLines(BufferedReader reader) throws IOException {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            return content.toString();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public String nextLine() throws IOException {
            return br.readLine();
        }
        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }
        public long[] nextlongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
        public Long[] nextLongArray(int n) throws IOException {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
        public boolean ready() throws IOException {
            return br.ready();
        }

    }

    //entry_6572621
}