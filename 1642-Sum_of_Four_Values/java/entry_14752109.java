import java.util.*;
import java.io.*;

public class entry_14752109 {


    public static void main (String[] args) throws Exception {
        // your code goes here
        FastIO io=new FastIO();
        //while(t-->0) {
        int n=io.nextInt();
        long x=io.nextLong();
        long[] a=io.readArray1(n);
        HashMap<Long,int[]> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                map.put(x-a[i]-a[j],new int[]{i,j});
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long sum=a[i]+a[j];
                if (map.containsKey(sum)){
                    int idx1=map.get(sum)[0],idx2=map.get(sum)[1];
                    if (i!=idx1 && j!=idx2 && i!=idx2 && j!=idx1){
                        list.add(i+1);
                        list.add(idx1+1);
                        list.add(idx2+1);
                        list.add(j+1);
                        break;
                    } 
                }
            }
            if (list.size()>0) break;
        }
        Collections.sort(list);
        if (list.size()==0) io.println("IMPOSSIBLE");
        else{
            for(int i:list) io.print(i+" ");
        }
        //}
        io.close();
    }

    public static int f(int[][] a,int l,int h,int x){
        int res=a.length;
        while(l<=h){
            int mid=l+(h-l)/2;
            if (a[mid][0]>x){
                res=mid;
                h=mid-1;
            }else l=mid+1;
        }
        return res;
    }


    public static void swap(int[] a,int x,int y){
        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }




    static class pair implements Comparable < pair > {
        long x;
        long y;
        pair(long i, long j) {
            x = i;
            y = j;
        }
        public int compareTo(pair p) {
            if (this.x != p.x) {
                return Long.compare(this.x,p.x);
            } else {
                return Long.compare(this.y,p.y);
            }
        }
        public int hashCode() {
            return (x + " " + y).hashCode();
        }
        public String toString() {
            return x + " " + y;
        }
        public boolean equals(Object o) {
            pair x = (pair) o;
            return (x.x == this.x && x.y == this.y);
        }
    }





    public static boolean helper(int x, int y, int n){
        return x>=1 && x<=n && y>=1 && y<=n;
    }

    public static boolean isPrime(int n){
        if (n%2==0) return false;
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if (n%i==0) return false;
        }
        return true;
    }

    public static int sumOfDigits(long n){
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }

    public static long gcd(long a, long b){
        if (a==0) return b;
        return gcd(b%a,a);
    }
    public static boolean larger(ArrayList<Integer> list1, ArrayList<Integer> list2){
        if (list2.size()==0) return true;
        int x=list1.size(),y=list2.size(),i=0,j=0;
        while(i<x && j<y){
            int first=list1.get(i++),second=list2.get(j++);
            if (first>second) return true;
            else if (first<second) return false;
        }
        return false;
    }
    public static String minString(String s1, String s2){
        if (s1.compareTo(s2)<=0) return s1;
        return s2;
    }
    public static String maxString(String s1, String s2){
        if (s1.compareTo(s2)<0) return s2;
        return s1;
    }
    public static int uppperBound(ArrayList<Integer> a, long x){
        int lo=0,hi=a.size()-1,res=a.size();
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int curr=a.get(mid);
            if (curr>x){
                res=mid;
                hi=mid-1;
            }else lo=mid+1;
        }
        return res;
    }
    public static int lowerBound(ArrayList<Long> a, long x){
        int res=-1,lo=0,hi=a.size()-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            long curr=a.get(mid);
            if (curr<=x){
                res=mid;
                lo=mid+1;
            }else hi=mid-1;
        }
        return res;
    }
    public static int uppperBound(long[] a, long x){
        int lo=0,hi=a.length-1,res=a.length;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            long curr=a[mid];
            if (curr>x){
                res=mid;
                hi=mid-1;
            }else lo=mid+1;
        }
        return res;
    }
    public static long GCD(long a, long b){
        if (a==0) return b;
        return GCD(b%a,a);
    }

    public static long lcm_of_array(long[] arr)
    {
        long lcm = arr[0];
        for (int i = 1; i < arr.length; i++) {
            long num1 = lcm;
            long num2 = arr[i];
            long gcd_val = GCD(num1, num2);
            lcm = (lcm * arr[i]) / gcd_val;
        }
        return lcm;
    }
    static long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        if (x == 0)
            return 0;

        while (y > 0) {
            if ((y & 1) != 0)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        // standard input
        public FastIO() { this(System.in, System.out); }

        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }

        // file input
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1) { throw new InputMismatchException(); }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) { throw new InputMismatchException(); }
                if (numChars == -1) {
                    return -1;  // end of file
                }
            }
            return buf[curChar++];
        }

        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c;
            do { c = nextByte(); } while (c <= ' ');

            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }

        public int nextInt() {  // nextLong() would be implemented similarly
            int c;
            do { c = nextByte(); } while (c <= ' ');

            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9') { throw new InputMismatchException(); }
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public long nextLong(){
            long c;
            do { c = nextByte(); } while (c <= ' ');

            long sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }

            long res = 0;
            do {
                if (c < '0' || c > '9') { throw new InputMismatchException(); }
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public double nextDouble() { return Double.parseDouble(next()); }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] readArray1(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

    }

}