import java.util.*;
import java.lang.*;
import java.io.*;
public class entry_6150651 {
    static FastReader sc =new FastReader();
    static PrintWriter out=new PrintWriter(System.out);
    static long mod=(long)1e9+7;
    static StringBuilder sb = new StringBuilder();



    /* start */

    public static void main(String [] args)
    {
        int testcases = 1;
        // testcases = i();
        // calc();
        while(testcases-->0)
        {

            solve();
        }
        out.flush();
        out.close();
    }


    static void solve()
    { 
        int n = i(),m = i();
        int vis[] = new int[n],par[] = new int[n];
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<=n;i++) al.add(new ArrayList<>());

        for(int i=0;i<m;i++)
        {
            int u = i()-1,v = i()-1;
            al.get(u).add(v);
            al.get(v).add(u);
        }
        int ans[] = new int[n];

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(vis[i]==1) continue;
            q.clear();
            vis[i] = 1;
            q.add(i);
            ans[i] = 1;
            while(!q.isEmpty())
            {
                int x  = q.poll();
                for(int j : al.get(x))
                {
                    if(vis[j]==1)
                    {
                        if(ans[j]==ans[x]) {
                            pl("IMPOSSIBLE");
                            return;
                        }
                    } else {
                        vis[j] = 1;
                        q.add(j);
                        ans[j] = 1^ans[x];
                    }
                }
            }
        }

        for(int i : ans)p((i+1)+" ");
    }

    /* end */

    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 

        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 

        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 

        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 

        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    // print code start
    static void p(Object o)
    {
        out.print(o);
    }
    static void pl(Object o)
    {
        out.println(o);
    }
    static void pl()
    {
        out.println("");
    }
    // print code end //

    static int i() {
        return sc.nextInt();
    }

    static String s() {
        return sc.next();
    }

    static long l() {
        return sc.nextLong();
    }

    static char[] inputC()
    {
        String s = sc.nextLine();
        return s.toCharArray();
    }

    static int[] input(int n) {
        int A[]=new int[n];
           for(int i=0;i<n;i++) {
               A[i]=sc.nextInt();
           }
        return A;
    }

    static long[] inputL(int n) {
        long A[]=new long[n];
           for(int i=0;i<n;i++) {
               A[i]=sc.nextLong();
           }
           return A;
    }

    static int[][] input(int n,int m) {
        int a[][] = new int[n][m];
        for(int i=0;i<n;i++) a[i] = input(m);
        return a;
    }

    static long[][] inputL(int n,int m)
    {
        long a[][] = new long[n][m];
        for(int i=0;i<n;i++) a[i] = inputL(m);
        return a;
    }

    static long[] putL(long a[]) {
        long A[]=new long[a.length];
           for(int i=0;i<a.length;i++) {
               A[i]=a[i];
           }
           return A;
    }

    static String[] inputS(int n) {
        String A[]=new String[n];
           for(int i=0;i<n;i++) {
               A[i]=sc.next();
           }
           return A;
    }

    static int gcd(int a, int b) 
     { 
         if (a == 0) 
             return b; 
         return gcd(b % a, a); 
     } 

     static long gcd(long a, long b) 
     { 
         if (a == 0) 
             return b; 
         return gcd(b % a, a); 
     } 

     static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }

    static long lcm(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }
     static String reverse(String s) {
        StringBuffer p=new StringBuffer(s);
        p.reverse();
        return p.toString();
     }

     static int min(int a,int b) {
        return Math.min(a, b);
    }
    static int min(int a,int b,int c) {
        return Math.min(a, Math.min(b, c));
    }
    static int min(int a,int b,int c,int d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }

    static int max(int a,int b) {
        return Math.max(a, b);
    }
    static int max(int a,int b,int c) {
        return Math.max(a, Math.max(b, c));
    }
    static int max(int a,int b,int c,int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
    static long min(long a,long b) {
        return Math.min(a, b);
    }
    static long min(long a,long b,long c) {
        return Math.min(a, Math.min(b, c));
    }
    static long min(long a,long b,long c,long d) {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
    static long max(long a,long b) {
        return Math.max(a, b);
    }
    static long max(long a,long b,long c) {
        return Math.max(a, Math.max(b, c));
    }
    static long max(long a,long b,long c,long d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    static long sum(int A[]) {
        long sum=0;
        for(int i : A) {
            sum+=i;
        }
        return sum;
    }

    static long sum(long A[]) {
        long sum=0;
        for(long i : A) {
            sum+=i;
        }
        return sum;
    }

    static long mod(long x) {
          return ((x%mod + mod)%mod);
    }

    static long sum_mod(long x,long y)
    {
        return mod(mod(x)+mod(y));
    }

    public static long ncr_mod(long n,long r){
        if(n<r)  return 0;
        if(r==0) return 1;
        long top=fac_mod(n);
        long bottom=mul_mod(fac_mod(r),fac_mod(n-r));

        long ans=mul_mod(top,power_mod(bottom,mod-2));
        return ans;
    }
    public static long power_mod(long a,long b){
        if(b==0)return 1;
        if(b==1)return a;
        long res=1;
        while(b>0){
            if((b&1)==1) res=mul_mod(res,a);
            a=mul_mod(a,a);
            b/=2;
        }
        return res;
    }
    public static long fac_mod(long n){
        if(n==0)return 1;
        return mul_mod(fac_mod(n-1),n);
    }

    static long mul_mod(long x,long y)
    {
        return mod(mod(x)*mod(y));
    }
    static long power(long x, long y)
    {

 if(y==0)
  return 1;
 if(x==0)
  return 0;
    long res = 1;
    while (y > 0) {

        if (y % 2 == 1)
            res = (res * x) ;

        y = y >> 1; 
        x = (x * x);
    }

    return res;
    }

    static boolean prime(int n) 
     { 
         if (n <= 1) 
             return false; 
         if (n <= 3) 
             return true; 
         if (n % 2 == 0 || n % 3 == 0) 
             return false; 
         double sq=Math.sqrt(n);

         for (int i = 5; i <= sq; i = i + 6) 
             if (n % i == 0 || n % (i + 2) == 0) 
                 return false; 
         return true; 
     } 

     static boolean prime(long n) 
     { 
         if (n <= 1) 
             return false; 
         if (n <= 3) 
             return true; 
         if (n % 2 == 0 || n % 3 == 0) 
             return false; 
         double sq=Math.sqrt(n);

         for (int i = 5; i <= sq; i = i + 6) 
             if (n % i == 0 || n % (i + 2) == 0) 
                 return false; 
         return true; 
     } 

        static long[] sort(long a[]) {
            ArrayList<Long> arr = new ArrayList<>();
            for(long i : a) {
                arr.add(i);
            }
            Collections.sort(arr);
            for(int i = 0; i < arr.size(); i++) {
                a[i] = arr.get(i);
            }
            return a;
        }

        static int[] sort(int a[])
        {
            ArrayList<Integer> arr = new ArrayList<>();
            for(Integer i : a) {
                arr.add(i);
            }
            Collections.sort(arr);
            for(int i = 0; i < arr.size(); i++) {
                a[i] = arr.get(i);
            }
            return a;
        }

        static int[] sortInd(int a[])
        {
            int n = a.length;
            int ii[] = new int[n];
            for(int i=0;i<n;i++)ii[i] = i;

            ii = Arrays.stream(ii).boxed().sorted((i,j)->a[i]-a[j]).mapToInt($->$).toArray();

            return ii;
        }
        //pair class
        private static class Pair implements Comparable<Pair> {
            int first, second;
            public Pair(int f, int s) {
                first = f;
                second = s;
            }
            @Override
            public int compareTo(Pair p) {
                if (first < p.first)
                    return 1;
                else if (first > p.first)
                    return -1;
                else {
                    if (second > p.second)
                        return 1;
                    else if (second < p.second)
                        return -1;
                    else
                        return 0;
                }
            }

        }

}