import java.io.*;
import java.util.*;

public class entry_4093476 {
    static boolean[] table = new boolean[10001];
    static StringBuilder sb = new StringBuilder();
    static TreeSet<String> sn = new TreeSet<>();
    static List<Long> sm = new ArrayList<>();
    static boolean[][] visited = new boolean[7][7];

    static int numberOfWays = 0;

    static class Point {
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;

        }
    }

    static int ways;

    static void dfs(int n, int m, int i, int j, boolean[][] visited, int steps) {

        System.out.println(i + "  " + j);
        boolean r, l, u, d = false;


        visited[i][j] = true;
        steps++;
        if (i < n - 1) if (!visited[i + 1][j]) {
            dfs(n, m, i + 1, j, visited, steps);
        }
        if (j < m - 1) if (!visited[i][j + 1]) dfs(n, m, i, j + 1, visited, steps);
        if (i > 0) if (!visited[i - 1][j]) dfs(n, m, i - 1, j, visited, steps);
        if (j > 0) if (!visited[i][j - 1]) dfs(n, m, i, j - 1, visited, steps);

        if (steps == 3 * 3) ways++;


    }

    static void sieveOfEratosthenes() {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.

        for (int i = 0; i <= 10000; i++) {
            table[i] = true;
        }

        for (int p = 2; p * p <= 100000000; p++) {
            // If prime[p] is not changed, then it is a prime
            if (table[p]) {
                // Update all multiples of p
                for (int i = p * p; i <= 100000000; i += p)
                    table[i] = false;
            }
        }

        // Print all prime numbers

    }

    public static void minDistance(int[] tab, long s, int index) {
        if (tab.length == index) {
            sm.add(s);
            return;
        }
        int go = tab[index];
        index++;
        minDistance(tab, s, index);
        minDistance(tab, s + go, index);

    }

    public static void steps(int n, int start, int end) {

        int mid = 0;
        if (n == 0) return;
        if (start + end == 3) mid = 3;
        if (start + end == 4) mid = 2;
        if (start + end == 5) mid = 1;
        steps(n - 1, start, mid);
        sb.append(start).append(" ").append(end).append(System.lineSeparator());
        steps(n - 1, mid, end);


    }

    public static void print_rec(LinkedList<String> strings, StringBuilder s) {
        if (strings.size() == 0) {
            sn.add(String.valueOf(s));
            return;
        }
        for (int i = 0; i < strings.size(); i++) {
            StringBuilder ss = new StringBuilder();
            LinkedList<String> subStrings = (LinkedList<String>) strings.clone();
            subStrings.remove(i);

            ss.append(s).append(strings.get(i));
            print_rec(subStrings, ss);


        }

    }

    static boolean[] ld = new boolean[15];
    static boolean[] rd = new boolean[15];
    static boolean[] col = new boolean[8];
    static boolean[][] reserved = new boolean[8][8];

    static void callNumberOfWays(int j) {
        if (j == 8) {
            numberOfWays++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!ld[i + j] && !rd[i - j + 7] && !col[i] && !reserved[j][i]) {

                ld[i + j] = rd[i - j + 7] = col[i] = true;

                callNumberOfWays(j + 1);
                ld[i + j] = rd[i - j + 7] = col[i] = false;
            }

        }


    }

    static int comp(String s1, String s2) {
        char[] tab1 = s1.toCharArray();
        char[] tab2 = s2.toCharArray();
        int res = 0;
        for (int i = 0; i < s1.length(); i++) {
            res += Math.abs(tab1[i] - tab2[i]);
        }
        return res;
    }

    static int binarySearch(ArrayList<Long> arr, int l, int r, long x) {


        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr.get(mid) == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr.get(mid) > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        } else return l;

        // We reach here when element is not present
        // in array

    }

    static int binarySearch2(ArrayList<Integer> arr, int l, int r, long x) {


        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr.get(mid) == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr.get(mid) > x)
                return binarySearch2(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch2(arr, mid + 1, r, x);
        } else return l;

        // We reach here when element is not present
        // in array

    }

    static public int findComplement(int num) {
        int MSB = (int) (Math.log(num) / Math.log(2)); // finding the Most Significant Bit position of num
        int mask = ((1 << MSB) | ((int) Math.pow(2, MSB) - 1)); // creating a mask like - 00..MSB..11111. So all zeroes till MSB and MSB and afterwards it is all ones.
        return num ^ mask; // now we can simply xor it - which is used as an inverter of bits
    }

    static public boolean checkswap(int[][] arr, int n, int m, int in, int io) {

        int[] aa1 = new int[n];
        int[] aa2 = new int[n];
        for (int i = 0; i < n; i++) {
            aa1[i] = arr[i][in];
            aa2[i] = arr[i][io];
        }
        for (int i = 0; i < n; i++) {
            arr[i][io] = aa1[i];
            arr[i][in] = aa2[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] < arr[i][j - 1]) return false;
            }
        }
        return true;
    }

    static boolean check(int a) {
        if (a == 0) return true;
        else {
            int b = a - 1;
            return ((a & b) == 0);
        }
    }

    ;


    static int findmin(int[] tab, int l, int r) {
        int min = tab[l];
        for (int i = l; i < r; i++) {
            if (tab[i] < min) min = tab[i];
        }
        return min;

    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    class Element implements Comparable<Element> {
        int id;
        int ti;
        int ram;

        public Element(int id, int ti, int ram) {
            this.ti = ti;
            this.id = id;
            this.ram = ram;
        }

        @Override
        public int compareTo(Element el) {
            if (el.ti == this.ti) {
                if (el.ram == this.ram) {
                    return el.id - this.id;

                } else return el.ram - this.ram;
            } else return el.ti - this.ti;
        }
    }
    // Java program to Find upper bound
// Using Binary Search Iteratively

// Importing Arrays utility class


    // Main class


    // Iterative approach to find upper bound
    // using binary search technique
    static void upper_bound(int arr[], int key) {
        int mid, N = arr.length;

        // Initialise starting index and
        // ending index
        int low = 0;
        int high = N;

        // Till low is less than high
        while (low < high && low != N) {
            // Find the index of the middle element
            mid = low + (high - low) / 2;

            // If key is greater than or equal
            // to arr[mid], then find in
            // right subarray
            if (key >= arr[mid]) {
                low = mid + 1;
            }

            // If key is less than arr[mid]
            // then find in left subarray
            else {
                high = mid;
            }
        }

        // If key is greater than last element which is
        // array[n-1] then upper bound
        // does not exists in the array
        if (low == N) {
            System.out.print("The upper bound of " + key + " does not exist.");
            return;
        }

        // Print the upper_bound index
        System.out.print("The upper bound of " + key + " is " + arr[low] + " at index " + low);
    }

    static int recursive_lower_bound(int array[], int low,
                                     int high, int key) {
        // Base Case
        if (low > high) {
            return low;
        }

        // Find the middle index
        int mid = low + (high - low) / 2;

        // If key is lesser than or equal to
        // array[mid] , then search
        // in left subarray
        if (key <= array[mid]) {

            return recursive_lower_bound(array, low,
                    mid - 1, key);
        }

        // If key is greater than array[mid],
        // then find in right subarray
        return recursive_lower_bound(array, mid + 1, high,
                key);
    }

    // Method 2
    // To compute the lower bound
    static int lower_bound(int array[], int key) {
        // Initialize starting index and
        // ending index
        int low = 0, high = array.length;

        // Call recursive lower bound method
        return recursive_lower_bound(array, low, high, key);
    }

    static class pair implements Comparable<pair> {
        int in;
        int out;


        public pair(int in, int out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public int compareTo(pair o) {
            return this.out > o.out ? 1 : this.out < o.out ? -1 : this.in - o.in;
        }
        public int hashCode(pair o) {
           return 31*Integer.hashCode(this.in)+Integer.hashCode(this.out);
        }

    }

    public static void add_map_occurance(HashMap<Integer, Integer> hashMap, int a) {

        if (hashMap.containsKey(a)) hashMap.put(a, hashMap.get(a) + 1);
        else hashMap.put(a, 1);

    }
    public static void rm_map_occurance(HashMap<Integer, Integer> hashMap, int a) {

        if (hashMap.containsKey(a)) {
            if(hashMap.get(a)==1)hashMap.remove(a);
            else hashMap.put(a,hashMap.get(a)-1);

        }
        }




    public static void main(String[] args) throws Exception {
        Reader s = new Reader();
        //BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

        int t = s.nextInt();
        int x = s.nextInt();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> hashMap1 = new HashMap<>();
        int[] tab = new int[t];
        for (int i = 0; i < t; i++) {
            int ele = s.nextInt();
            tab[i]=ele;
           add_map_occurance(hashMap, ele);
           if(hashMap1.containsKey(ele)){
               LinkedList<Integer> l = hashMap1.get(ele);
               l.addFirst(i+1);
               hashMap1.put(ele,l);
           }
           else {
               LinkedList<Integer> l = new LinkedList<>();
               l.addFirst(i+1);
               hashMap1.put(ele,l);

           }

        }
        Set<Map.Entry<Integer, Integer>> f = hashMap.entrySet();
       // System.out.println(hashMap.size());
        int a = -1,b=-1;
        for (int entry :


                tab) {



            int val = x-entry;
            rm_map_occurance(hashMap,entry);
            if(hashMap.containsKey(val)){
                a=val;
                b=entry;

                break;
            }
            add_map_occurance(hashMap,entry);
        }
        if(a!=-1) {
           LinkedList<Integer> l = hashMap1.get(a);
            int index1 = l.getFirst();
            l.removeFirst();
            hashMap1.put(a,l);
            LinkedList<Integer> l1 = hashMap1.get(b);
            int index2 = l1.getFirst();
            System.out.println(index1+"  "+index2);

        }
        else System.out.println("IMPOSSIBLE");


    }


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
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

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
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
/*
    public static void main(String[] args)
            throws IOException
    {
        Reader s = new Reader();
        int n = s.nextInt();
        int k = s.nextInt();
        int count = 0;
        while (n-- > 0) {
            int x = s.nextInt();
            if (x % k == 0)
                count++;
        }
        System.out.println(count);
    }*/
}