import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class entry_13893385 {
    public static int INF = Integer.MAX_VALUE;
    public static BufferedReader f;
    public static PrintWriter o;
    public static void main(String[] args) throws IOException{
        File file = new File("input.txt");

        if (file.exists()) {
            f = new BufferedReader(new FileReader("input.txt"));
            o = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        } else {
            f = new BufferedReader(new InputStreamReader(System.in));
            o = new PrintWriter(System.out);
        }

        //int t=inp(1)[0];
        int t = 1;
        while(t-->0){
            solve();
            out();
        }
        o.flush();
        o.close();
    }
    public static void solve() throws IOException{
        int n = inp(1)[0];
        var a = inp(n);
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(var i:a){
            set.add(i);
        }
        out(set.size());
    }
    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        else if(a==0)
            return b;
        else
            return gcd(b, a % b);
    }
    public static long lcm(long a, long b) {
        long gcd = gcd(a, b);
        return (a * b) / gcd;
    }

    public static int[] inp(int n) throws IOException {
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        return a;
    }

    public static long[] inpl(int n) throws IOException {
        StringTokenizer st = new StringTokenizer(f.readLine());
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());
        return a;
    }

    public static String inp() throws IOException {
        return f.readLine();
    }

    public static void out(String s, boolean newline) {
        if (newline) o.println(s);
        else o.print(s);
    }

    public static void out(int n) {
            o.println(n);
    }

    public static void out(long n) {
        o.println(n);
    }

    public static void out(int[] a) {
        for (int x : a) o.print(x + " ");
        o.println();
    }

    public static void out(long[] a) {
        for (long x : a) o.print(x + " ");
        o.println();
    }

    public static void out() {
        o.println();
    }
}