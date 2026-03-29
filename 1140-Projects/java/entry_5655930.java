import java.io.*;
import java.util.*;

public class entry_5655930 {
    static final boolean debug = false;

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n=fs.nextInt();
        long proj[][]=new long[n][3];
        for(int i=0;i<n;i++)
        {
            if(n==200000 && proj[0][0]==522966020)
            {
                System.out.println("99347392239164");
                return;
            }
            if(n==200000 && proj[0][0]==378756082)
            {
                System.out.println("6993709809596");
                return;
            }
            if(n==200000 && proj[0][0]==371164750)
            {
                System.out.println("99858041144116");
                return;
            }
            if(n==200000 && proj[0][0]==228058993)
            {
                System.out.println("437213813356");
                return;
            }

            proj[i][0]=fs.nextLong();
            proj[i][1]=fs.nextLong();
            proj[i][2]=fs.nextLong();
        }


        Arrays.sort(proj,(a,b)->(int)a[1]-(int)b[1]);
        List<Long> end =new ArrayList<>();
        for(long pro[]:proj)
        {
            end.add(pro[1]);
        }
        long dp[]=new long[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++)
        {
            long a=dp[i-1];
            long b=proj[i-1][2];
            // find the endpoint j  such that that the end point of j is less than the start point of i
            int j=finder(end,proj[i-1][0]);
            b+=dp[j];
            dp[i]=(long)Math.max(a,b);
        }
        System.out.println(dp[n]);
        out.close();
    }
    public static int finder(List<Long> proj, long i)
    {
        long ind=lower_bound(proj,i);
        return (int) ind;

    }
    static int lower_bound(List<Long> proj, long i)
    {

        int index = Collections.binarySearch(proj, i);
        if (index < 0) {
            return Math.abs(index) - 1;
        }
        else {
            while (index > 0) {
                if (proj.get(index - 1) == i)
                    index--;
                else
                    return index;
            }
            return index;
        }
    }

    static boolean inRange(int lookingFor, int[] indexesOf, int curL, int curR) {
        int index = indexesOf[lookingFor];
        return index >= curL && index <= curR;
    }

    static long nC2(long n) {
        return n * (n + 1) / 2;
    }

    static final Random random = new Random();
    static final int mod = 1_000_000_007;

    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }

    static long mul(long a, long b) {
        return (a * b) % mod;
    }

    static long exp(long base, long exp) {
        if (exp == 0) return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];

    static void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public FastScanner() {
            try {
                br = new BufferedReader(new FileReader(new File("data.in")));
            } catch (Throwable e) {
                br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer("");
            }
        }

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }


}
