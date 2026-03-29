import java.util.*;
import java.io.*;
import java.lang.*;



public class entry_9125731 {
    static long[] fac;
    static int m = (int)1e9+7;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        PrintWriter writer = new PrintWriter(System.out);
/*
Number of primes:
1) <=1e2: 26
2) <=1e3: 168
3) <=1e4: 1229
4) <=1e5: 9592
5) <=1e6: 78498
6) <=1e7: 664579
7) <=1e8: 5761455
  */
// Do not delete this //
//Uncomment this before using nCrModPFermat
//        fac = new long[200000 + 1];
//        fac[0] = 1;
//
//        for (int i = 1; i <= 200000; i++)
//            fac[i] = (fac[i - 1] * i % m);


//        int te = Reader.nextInt();
        int te = 1;
        int mod = (int)1e9+7;
        while(te-->0){
            int n = Reader.nextInt();
            int x = Reader.nextInt();
            int[] price = new int[n];
            int[] pages = new int[n];

            for(int i = 0;i<n;i++){
                price[i] = Reader.nextInt();
            }
            for(int i = 0;i<n;i++){
                pages[i] = Reader.nextInt();
            }
            long[] dp = new long[x+1];

            for(int i = 0;i<n;i++){
                for(int j = x;j>0;j--){
                    if(price[i]<=j){
                        dp[j] = Math.max(dp[j],pages[i]+dp[j-price[i]]);
                    }
                }
            }
            output.write(dp[x]+"\n");






            output.flush();
        }
        output.close();
    }


    public static long[] sum_of_factors(int n){
        long[] a = new long[n+1];
        Arrays.fill(a,1);
        for(int i = 2;i<=n;i++){
            for(int j = i;j<=n;j+=i){
                a[j] += i;
            }
        }
        return a;
    }
    // Return an array, where a[i] contains the number of factors of i.
    // nlogn
    public static int[] num_of_factors(int n){
        int[] a = new int[n+1];
        for(int i = 1;i<=n;i++){
            for(int j = i;j<=n;j+=i){
                a[j]++;
            }
        }
        return a;
    }
    public static void num_of_smaller_el_on_left(int[][] a, int l, int r, int[] smaller){
        if(l>=r) return;

        int mid = l + (r-l)/2;
        num_of_smaller_el_on_left(a,l,mid,smaller);
        num_of_smaller_el_on_left(a,mid+1,r,smaller);
        conquer1(a,l,mid,r,smaller);
    }
    public static void conquer1(int[][] a, int l, int mid, int r, int[] smaller){
        int[][] left = new int[mid-l+1][2];
        int[][] right = new int[r-mid][2];
        for(int i = l;i<=mid;i++){
            left[i-l] = a[i];
        }
        for(int i = mid+1;i<=r;i++){
            right[i-mid-1] = a[i];
        }
        int i = 0, j = 0;
        int n = left.length, m = right.length;

        int idx = l;
        while(i<n && j<m){
            if(left[i][0]<right[j][0]){
                a[idx++] = left[i++];
            }
            else{
                smaller[right[j][1]] += i;
                a[idx++] = right[j++];
            }
        }
        while(i<n){
            a[idx++] = left[i++];
        }
        while(j<m){
            smaller[right[j][1]] += i;
            a[idx++] = right[j++];
        }
    }
    public static void num_of_smaller_el_on_right(int[][] a, int l, int r, int[] smaller){
        if(l>=r) return;

        int mid = l + (r-l)/2;
        num_of_smaller_el_on_right(a,l,mid,smaller);
        num_of_smaller_el_on_right(a,mid+1,r,smaller);
        conquer3(a,l,mid,r,smaller);
    }
    public static void conquer3(int[][] a, int l, int mid, int r, int[] smaller){
        int[][] left = new int[mid-l+1][2];
        int[][] right = new int[r-mid][2];

        for(int i = l;i<=mid;i++){
            left[i-l] = a[i];
        }
        for(int i = mid+1;i<=r;i++){
            right[i-mid-1] = a[i];
        }
        int i = 0, j = 0;
        int n = left.length, m = right.length;

        int idx = l;
        while(i<n && j<m){
            if(left[i][0]<=right[j][0]){
                smaller[left[i][1]] += j;
                a[idx++] = left[i++];
            }
            else{
//                greater[right[j][1]] += n-i;
                a[idx++] = right[j++];
            }
        }
        while(i<n){
            smaller[left[i][1]] += j;
            a[idx++] = left[i++];
        }
        while(j<m){
//            greater[right[j][1]] += n-i;
            a[idx++] = right[j++];
        }
    }
    public static void num_of_greater_el_left(int[][] a, int l, int r, int[] greater){
        if(l>=r) return;

        int mid = l + (r-l)/2;
        num_of_greater_el_left(a,l,mid,greater);
        num_of_greater_el_left(a,mid+1,r,greater);
        conquer2(a,l,mid,r,greater);
    }

    public static void conquer2(int[][] a, int l, int mid, int r, int[] greater){
        int[][] left = new int[mid-l+1][2];
        int[][] right = new int[r-mid][2];

        for(int i = l;i<=mid;i++){
            left[i-l] = a[i];
        }
        for(int i = mid+1;i<=r;i++){
            right[i-mid-1] = a[i];
        }
        int i = 0, j = 0;
        int n = left.length, m = right.length;

        int idx = l;
        while(i<n && j<m){
            if(left[i][0]<=right[j][0]){
                a[idx++] = left[i++];
            }
            else{
//                smaller[right[j][1]] += i;
                greater[right[j][1]] += n-i;
                a[idx++] = right[j++];
            }
        }
        while(i<n){
            a[idx++] = left[i++];
        }
        while(j<m){
//            smaller[right[j][1]] += i;
            greater[right[j][1]] += n-i;
            a[idx++] = right[j++];
        }
    }

    // This is square of distance b/w two points
    public static long distancebwPoints(int[] p1, int[] p2){
        return (long)(Math.pow(p1[0]-p2[0],2) + Math.pow(p1[1]-p2[1],2));
    }

    // Returns true if three points (p1,p2,p3) form a 90 degree at p1.
    public static boolean Form90Degrees(int[] p1, int[] p2, int[] p3){
        int y1 = p1[1]-p2[1];
        int y2 = p1[1]-p3[1];
        int x1 = p1[0]-p2[0];
        int x2 = p1[0]-p3[0];

        boolean f1 = true;
        if(x1==0 && x2==0){
            f1 = false;
        }
        else if(x1==0){
            if(y2!=0){
                f1 = false;
            }
        }
        else if(x2==0){
            if(y1!=0){
                f1 = false;
            }
        }
        else{
            if(x1*x2*y1*y2>=0){
                f1 = false;
            }
            else if(x1*x2+y1*y2!=0){
                f1 = false;
            }
        }
        return f1;
    }

    // returns true if p1,p2,p3,p4 form a square
    public static boolean canFormSquare(int[] p1, int[] p2, int[] p3, int[] p4){
        boolean ok = false;

        long p1p2 = distancebwPoints(p1,p2);
        long p1p3 = distancebwPoints(p1,p3);
        long p1p4 = distancebwPoints(p1,p4);
        long p2p3 = distancebwPoints(p2,p3);
        long p2p4 = distancebwPoints(p2,p4);
        long p3p4 = distancebwPoints(p3,p4);

        // 0 area square rejected
        if(p1p2==0 || p1p3==0 || p1p4==0 || p2p3==0 || p2p4==0 || p3p4==0) return false;

        // if p1,p2 opposites
        if(p1p3==p1p4 && p1p3==p2p3 && p1p3==p2p4){
            if(Form90Degrees(p1,p3,p4) && Form90Degrees(p2,p3,p4)){
                return true;
            }
        }
        // if p1,p3 opposites
        if(p1p2==p2p3 && p1p2==p3p4 && p1p2==p1p4){
            if(Form90Degrees(p1,p2,p4) && Form90Degrees(p3,p2,p4)){
                return true;
            }
        }

        // if p1,p4 opposites
        if(p1p2==p2p4 && p1p2==p3p4 && p1p2==p1p3){
            if(Form90Degrees(p1,p2,p3) && Form90Degrees(p4,p2,p3)){
                return true;
            }
        }
        return false;
    }
    // Rotating Anticlockwise
    // count = 0, no rotation
    // count > 0, rotate once
    public static int[] rotate90degreesAroundPivot(int[] c, int[] p, int count){
        if(count==0){
            return c;
        }
        if(c[0]==p[0] && c[1]==p[1]) return c;

        int x_dist = c[0]-p[0];
        int y_dist = c[1]-p[1];


        int new_x = p[0]-y_dist;
        int new_y = p[1]+x_dist;

        return new int[]{new_x,new_y};


    }
    public static int sumOfDigits(long n){
        int ans = 0;

        while(n>0){
            ans += n%10;
            n/=10;
        }
        return ans;
    }
    public static boolean isSquare(long n){
        long l = 0, r = 3*(long)1e9;
        while(l<=r){
            long mid = l + (r-l)/2;
            if(mid*mid==n) return true;
            else if(mid*mid<n) l = mid+1;
            else r = mid-1;
        }
        return false;
    }
    public static long sqrt(long n){
        long l = 0, r = 3*(long)1e9;
        long ans = -1;
        while(l<=r){
            long mid = l + (r-l)/2;
            if(mid*mid==n) return mid;
            else if(mid*mid<n) {
                ans = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return ans;
    }
    public static int numOfPrimeNoLargerThanN(int n,ArrayList<Integer> primes){
        int l = 0, r = primes.size()-1;
        int idx = -1;
        while(l<=r){
            int mid = l + (r-l)/2;

            if(primes.get(mid)<=n){
                idx = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return idx+1;
    }
    public static int numOfPalindromeNoLargerThanN(int n){
        String s = n+"";
        int ans = 0;
        for(int i = 1;i<s.length();i++){
            int x = (i+1)/2;
            ans += 9*Math.pow(10,x-1);
        }
        StringBuilder f = new StringBuilder();
        StringBuilder l = new StringBuilder();
        int tot = s.length();
        for(int i = 0;i<s.length()/2;i++){
            int x = (tot+1)/2;
            if(i==0){
                int curr = (s.charAt(i)-'1')*(int)Math.pow(10,x-1);
                ans += curr;
            }
            else{
                int curr = (s.charAt(i)-'0')*(int)Math.pow(10,x-1);
                ans += curr;
            }
            tot -= 2;
            f.append(s.charAt(i));
            l.append(s.charAt(i));
        }
        if(s.length()%2==1){
            char ch = s.charAt(s.length()/2);
            int curr = (ch-'0') - (s.length()/2==0 ? 1 : 0);
            ans += curr;
            f.append(ch);
        }
        l.reverse();
        f.append(l);
        int newn = Integer.parseInt(f.toString());
        if(n>=newn){
            ans++;
        }
        return ans;

    }
    // Recursive function to return (x ^ n) % m
    static long modexp(long x, long n)
    {
        if (n == 0) {
            return 1;
        }
        else if (n % 2 == 0) {
            return modexp((x * x) % m, n / 2);
        }
        else {
            return (x * modexp((x * x) % m, (n - 1) / 2) % m);
        }
    }

    // Function to return the fraction modulo mod
    static long getFractionModulo(long a, long b)
    {
        long c = gcd(a, b);

        a = a / c;
        b = b / c;

        // (b ^ m-2) % m
        long  d = modexp(b, m - 2);

        // Final answer
        long ans = ((a % m) * (d % m)) % m;

        return ans;
    }
    public static boolean isP(String n){
        StringBuilder s1 = new StringBuilder(n);
        StringBuilder s2 = new StringBuilder(n);
        s2.reverse();

        for(int i = 0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) return false;
        }
        return true;
    }
    public static long[] factorial(int n){
        long[] factorials = new long[n+1];
        factorials[0] = 1;
        factorials[1] = 1;
        for(int i = 2;i<=n;i++){
            factorials[i] = (factorials[i-1]*i)%1000000007;
        }
        return factorials;
    }
    public static long numOfBits(long n){
        long ans = 0;

        while(n>0){
            n = n & (n-1);
            ans++;
        }
        return ans;
    }
    public static long ceilOfFraction(long x, long y){
        // ceil using integer division: ceil(x/y) = (x+y-1)/y
        // using double may go out of range.
        return (x+y-1)/y;
    }
    public static long power(long x, long y, long p) {

        long res = 1;

        x = x % p;

        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    public static long modInverse(long n, long p) {
        return power(n, p - 2, p);
    }

    public static long nCrModPFermat(int n, int r, int p) {

        if (n<r) return 0;
        if (r == 0) return 1;

        return (((fac[n] * modInverse(fac[r], p)) % p) * modInverse(fac[n - r], p) % p) % p;
    }
    public static long ncr(long n, long r) {
        long p = 1, k = 1;
        if (n - r < r) {
            r = n - r;
        }
        while (r > 0) {
            p *= n;
            k *= r;
            long m = gcd(p, k);
            p /= m;
            k /= m;
            n--;
            r--;
        }
        return p;
    }
    public static boolean isPrime(long n){
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; (long) i * i <= n; i = i + 6){
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public static int powOf2JustSmallerThanN(int n) {
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;

        return n ^ (n >> 1);
    }

    public static long divide(int[] arr, int[] aux, int low, int mid, int high)
    {
        int k = low, i = low, j = mid + 1;
        long inversionCount = 0;


        // while there are elements in the left and right runs
        while (i <= mid && j <= high)
        {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            }
            else {
                aux[k++] = arr[j++];
                inversionCount += (mid - i + 1);    // NOTE
            }
        }

        // copy remaining elements
        while (i <= mid) {
            aux[k++] = arr[i++];
        }

        /* no need to copy the second half (since the remaining items
           are already in their correct position in the temporary array) */

        // copy back to the original array to reflect sorted order
        for (i = low; i <= high; i++) {
            arr[i] = aux[i];
        }

        return inversionCount;
    }


    public static long mergesort(int[] arr, int[] aux, int low, int high)
    {

        if (high <= low) {        // if run size <= 1
            return 0;
        }

        int mid = (low + ((high - low) >> 1));
        long inversionCount = 0;

        // recursively split runs into two halves until run size <= 1,
        // then merges them and return up the call chain

        // split/divide left half
        inversionCount += mergesort(arr, aux, low, mid);

        // split/divide right half
        inversionCount += mergesort(arr, aux, mid + 1, high);

        // divide the two half runs
        inversionCount += divide(arr, aux, low, mid, high);

        return inversionCount;
    }

    public static void reverseArray(int[] arr,int start, int end) {
        int temp;

        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static long gcd(long a, long b){
        if(a==0){
            return b;
        }

        return gcd(b%a,a);
    }

    public static long lcm(long a, long b){
        if(a>b) return a/gcd(b,a) * b;
        return b/gcd(a,b) * a;
    }

    public static long largeExponentMod(long x,long y,long mod){
        // computing (x^y) % mod
        x%=mod;
        long ans = 1;
        while(y>0){
            if((y&1)==1){
                ans = (ans*x)%mod;
            }
            x = (x*x)%mod;
            y = y >> 1;
        }
        return ans;
    }

    public static ArrayList<Integer> primes_less_than_n(int n){
        ArrayList<Integer> p = new ArrayList<>();
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        for(int i = 2;i<=n;i++){
            if(isPrime[i]){
                p.add(i);
                if((long)i*i<=n){
                    for(int j = i*i;j<=n;j+=i){
                        isPrime[j] = false;
                    }
                }
            }
        }
        return p;
    }

    public static ArrayList<Long> primeFactors(long n){
        ArrayList<Long> factorization = new ArrayList<>();
        if(n%2==0){
            factorization.add(2L);
        }
        while(n%2==0){
            n/=2;
        }
        if(n%3==0){
            factorization.add(3L);
        }
        while(n%3==0){
            n/=3;
        }
        if(n%5==0){
            factorization.add(5L);
        }
        while(n%5==0){
//            factorization.add(5L);
            n/=5;
        }

        int[] increments = {4, 2, 4, 2, 4, 6, 2, 6};
        int i = 0;
        for (long d = 7; d * d <= n; d += increments[i++]) {
            if(n%d==0){
                factorization.add(d);
            }
            while (n % d == 0) {
//                factorization.add(d);
                n /= d;
            }
            if (i == 8)
                i = 0;
        }

        if (n > 1)
            factorization.add(n);
        return factorization;
    }
}

class DSU {
    int[] size, parent;
    int n;

    public DSU(int n){
        this.n = n;
        size = new int[n];
        parent = new int[n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u){
        if(parent[u]==u){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    public void merge(int u, int v){
        u = find(u);
        v = find(v);
        if(u!=v){
            if(size[u]>size[v]){
                parent[v] = u;
                size[u] += size[v];
            }
            else{
                parent[u] = v;
                size[v] += size[u];
            }
        }
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static String nextLine() throws IOException {
        return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException{
        return Long.parseLong(next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

class SegTree{
    int n;
    int[] tree;
    public SegTree(int n, int[] arr){
        this.n = n;
        tree = new int[4*n];
        build(arr,0,0,n-1);
    }

    public void build(int[] arr, int idx,int l, int r){
        if(l>r){
            return;
        }
        else if(l==r){
            tree[idx] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        build(arr,2*idx+1,l,mid);
        build(arr,2*idx+2,mid+1,r);
        tree[idx] = Math.max(tree[2*idx+1],tree[2*idx+2]);

    }

    public void update(int i,int idx, int l, int r, int val){
        // update in [left,right]
        // current range -> [l,r]
        if(i>r || i<l) return;
        else if(l==r){
            tree[idx] = val;
            return;
        }
        int mid = l + (r-l)/2;
        update(i,2*idx+1,l,mid,val);
        update(i,2*idx+2,mid+1,r,val);
        tree[idx] = Math.max(tree[2*idx+1],tree[2*idx+2]);
    }

    public int query(int i, int j, int idx, int l, int r){
        if(i>r || j<l) return -(int)1e9;
        else if(i<=l && j>=r) return tree[idx];

        int mid = l + (r-l)/2;
        int left = query(i,j,2*idx+1,l,mid);
        int right = query(i,j,2*idx+2,mid+1,r);

        return Math.max(left,right);
    }
}

class TrieNode{
    TrieNode[] arr;
    boolean flag;

    public TrieNode(){
        arr = new TrieNode[26];
        flag = false;
    }
    public boolean contains(char ch){
        return arr[ch-'a']!=null;
    }
    public void addNode(char ch){
        arr[ch-'a'] = new TrieNode();
    }
    public TrieNode get(char ch){
        return arr[ch-'a'];
    }
}
class Trie {
    TrieNode root;
    int totNodes;
    public Trie() {
        root = new TrieNode();
        totNodes = 0;
    }

    public void add(String s,boolean f) {
        TrieNode t = root;

        for(int i = 0;i<s.length();i++){
            if(!t.contains(s.charAt(i))){
                t.addNode(s.charAt(i));
                totNodes++;
            }
            t = t.get(s.charAt(i));
            if(f && i==s.length()-2){
                t.flag = true;
            }
        }
        t.flag = true;
    }
    public int getTotalNodes(){
        return totNodes;
    }

    public boolean exists(String word) {
        TrieNode t = root;

        for(int i = 0;i<word.length();i++){
            if(!t.contains(word.charAt(i))) return false;
            t = t.get(word.charAt(i));
        }
        return t.flag;
    }

    public boolean startswith(String p) {
        TrieNode t = root;

        for(int i = 0;i<p.length();i++){
            if(!t.contains(p.charAt(i))) return false;
            t = t.get(p.charAt(i));
        }
        return true;
    }
}