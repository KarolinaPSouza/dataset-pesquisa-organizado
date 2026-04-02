import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//لعمرك ما أمرى على بغمة  نهارى و لا ليلى على بسرمد

public class entry_5026263 {


    public static int GCD(int a, int b) {

        if (b == 0)
            return a;
        else
            return GCD(b, a % b);
    }



static int lcm(int a,int b){
        return a*b/GCD(a,b);
}
    public static ArrayList<Integer> getThePrimes(int n) {

        ArrayList<Integer> a = new ArrayList<>();
        boolean[] flags = new boolean[n + 1];
        flags[0] = true;
        flags[1] = true;

        for (int i = 2; i < n + 1; i++) {
            if (!flags[i]) {
                for (int j = i * i; j < n + 1; j += i) {
                    flags[j] = true;
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            if (!flags[i]) {
                a.add(i);
            }
        }

        return a;

    }

static class Pair implements Comparable<Pair> {
        Long a;
        int b;
        public Pair(Long a,int i){
            this.a=a;
            this.b=i;
        }

    @Override
    public int compareTo(Pair o) {
        return (int)(a-o.a);
    }
}
static String s1,s2;
    static int dp[][];
    static int solve(int a,int b){
        if(a<0 || b<0){
            return Math.abs(a-b);
        }
        if(dp[a][b]!=-1)return dp[a][b];
        int ans=10000000;
        return dp[a][b]=Math.min(solve(a-1,b-1)+((s1.charAt(a)==s2.charAt(b))?0:1) ,Math.min(solve(a-1,b)+1,solve(a,b-1)+1));
    }

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(new FileReader("feast.in"));
//        PrintWriter pw= new PrintWriter(new FileWriter("feast.out"));
        Scanner sc= new Scanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);

 s1=sc.next(); s2=sc.next();
 dp=new int[s1.length()][s2.length()];
 for(int []b:dp) Arrays.fill(b,-1);
            System.out.println(solve(s1.length()-1,s2.length()-1));



    pw.close();
    }
    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
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

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
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
}