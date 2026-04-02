import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.*;

public class entry_14281178 {
    static DecimalFormat df = new DecimalFormat("0.0000000000");
    static long mod = (long)1e9+7;
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        BufferInput in = new BufferInput();
//        int t=in.nextInt();
//        while(t-->0) {
//        }
        int n = in.nextInt();
        int m = in.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] visited = new boolean[n+1];
        solve(n, adj, visited);
        out.flush();
    }
    static void solve(int n, List<List<Integer>> adj, boolean[] visited ) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                ans.add(i);
                dfs(adj, visited, i);
            }
        }
        System.out.println(ans.size()-1);
        for(int i=0;i<ans.size()-1;i++) System.out.println(ans.get(i) + " " + ans.get(i+1));
    }
    static void dfs(List<List<Integer>> adj, boolean[] visited, int i){
        if(!visited[i]){
            visited[i] = true;
            for(int j:adj.get(i))
                dfs(adj, visited, j);
        }
    }

    private static int binarySearchEqual(ArrayList<Integer> arrayList, int a) {
        int left = 0;
        int right = arrayList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arrayList.get(mid) == a) {
                return mid;  // Element found
            } else if (arrayList.get(mid) < a) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;  // Element not found
    }

    private static int binarySearchLessThan(ArrayList<Integer> arrayList, int a) {
        int left = 0;
        int right = arrayList.size() - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arrayList.get(mid) < a) {
                resultIndex = mid;
                left = mid + 1;  // Look for a larger element
            } else {
                right = mid - 1;
            }
        }

        return resultIndex;
    }

    private static int binarySearchh(ArrayList<Integer> arrayList, int a, int b) {
        int left = 0;
        int right = arrayList.size() - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arrayList.get(mid) <= a && arrayList.get(mid) >= b) {
                resultIndex = mid;
                break;
            } else if (arrayList.get(mid) > a) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return resultIndex;
    }

    static long getFactorial(long n) {
        long ans = 1L;
        while(n>1){
            ans*=n;
            ans%=mod;
            n--;
        }
        return ans%mod;
    }
    static ArrayList<Integer> printDivisors(int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1;i<=n;i++)
            if (n%i==0)
                list.add(i);
        return list;
    }


    static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    static void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            sort(arr, l, m);
            sort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }
    static void revOrder(long[] arr) {
        long[] a = new long[arr.length];
        for(int i=0;i<arr.length;i++) {
            a[i] = arr[arr.length-i-1];
        }
        System.arraycopy(a, 0, arr, 0, arr.length);
    }
    static int next(long target, long[] arr) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (arr[mid] <=target) {
                start = mid + 1;
                ans = mid;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }

    int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // If we reach here, then element was
        // not present
        return -1;
    }

    static void pf(int n, ArrayList<Integer> al)
    {
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            if (n%i==0)
            {
                if (n/i == i) {
                    al.add(i);
                }

                else{
                    al.add(i);
                    al.add(n/i);
                }
            }
        }
    }
    static long power(long x, long y, long p)
    {
        long res = 1;
        x = x % p;

        if (x == 0) return 0;

        while (y > 0)
        {
            if((y & 1)==1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        int k;
        for (k = 0; ((a | b) & 1) == 0; ++k)
        {
            a >>= 1;
            b >>= 1;
        }
        while ((a & 1) == 0)
            a >>= 1;

        do {
            while ((b & 1) == 0)
                b >>= 1;

            if (a > b)
            {
                int temp = a;
                a = b;
                b = temp;
            }

            b = (b - a);
        } while (b != 0);
        return a << k;
    }
    static long inv(long a, long m){
        return power(a, m-2, m);
    }

    static int highestPowerof2(int n)
    {
        int res = 0;
        for(int i = n; i >= 1; i--)
        {

            // If i is a power of 2
            if ((i & (i-1)) == 0)
            {
                res = i;
                break;
            }
        }
        return res;
    }
    static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }


    static boolean isPalindrome(String s, int i, int j){
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    static class Pair implements Comparable<Pair>
    {
        int x;int y;

        Pair(int i,int o)
        {
            x=i;y=o;
        }
        public int compareTo(Pair n)
        {
            if(this.x!=n.x) return this.x-n.x;
            return this.y-n.y;
        }
    }
    static class BufferInput {

        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;

        private byte[] buffer;

        private int bufferPointer, bytesRead;

        public BufferInput() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public BufferInput(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public String nextString() throws IOException{

            byte c = read();
            while(Character.isWhitespace(c)){
                c = read();
            }

            StringBuilder builder = new StringBuilder();
            builder.append((char)c);
            c = read();
            while(!Character.isWhitespace(c)){
                builder.append((char)c);
                c = read();
            }

            return builder.toString();
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

        public int[] nextIntArray(int n) throws IOException {
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = nextInt();
            }
            return arr;
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

        public long[] nextLongArray(int n) throws IOException {
            long arr[] = new long[n];
            for(int i = 0; i < n; i++){
                arr[i] = nextLong();
            }
            return arr;
        }

        public char nextChar() throws IOException{
            byte c = read();
            while(Character.isWhitespace(c)){
                c = read();
            }
            return (char) c;
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
        public double[] nextDoubleArray(int n) throws IOException {
            double arr[] = new double[n];
            for(int i = 0; i < n; i++){
                arr[i] = nextDouble();
            }
            return arr;
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
}