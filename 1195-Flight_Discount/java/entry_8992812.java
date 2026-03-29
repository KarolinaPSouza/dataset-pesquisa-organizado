// Rohit Bohra | 12/04/2024 : 13:56:23
import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
class FlightDiscount{

    static class City
    {
        int idx, coupon;
        long cost;

        City(int idx, int coupon, long cost)
        {
            this.idx=idx;
            this.coupon=coupon;
            this.cost=cost;
        }
    } 

    public static void main(String args[])throws IOException{

        int n=sc.nextInt();
        int m=sc.nextInt();

        List<Pair>[] adj = new ArrayList[n+1];
        for(int i=0;i<=n;i++) adj[i] = new ArrayList<>();

        for(int i=0;i<m;i++)
        {
            int[] f = sc.readArray(3);
            adj[f[0]].add(new Pair(f[1],f[2]));
        }

        PriorityQueue<City> cities = new PriorityQueue<>((a,b)->a.cost>b.cost ? 1 : -1);
        cities.offer(new City(1,1,0));

        long[][] dp = new long[n+1][2];
        for(long[] d: dp) Arrays.fill(d,Long.MAX_VALUE);

        dp[1][0]=dp[1][1]=0;

        while(!cities.isEmpty())
        {
            City city = cities.poll();
            if(dp[city.idx][city.coupon]<city.cost) continue;

            if(city.idx==n)
            break;

            for(var flight : adj[city.idx])
            {
                int nextDes = flight.x;
                int flightCost = flight.y;
                // use discount or not
                if(city.coupon==1 && dp[nextDes][0] > flightCost/2 + city.cost)
                {
                    dp[nextDes][0] = flightCost/2 + city.cost;
                    cities.offer(new City(nextDes, 0, flightCost/2 + city.cost));
                }

                if(dp[nextDes][city.coupon] > flightCost + city.cost)
                {
                    dp[nextDes][city.coupon] = flightCost + city.cost;
                    cities.offer(new City(nextDes, city.coupon, flightCost + city.cost));
                }
            }
        }

        out.println(dp[n][0]);
        out.close();
    }


    static int M=(int)Math.pow(10,9)+7;

    static int find(int[] parent, int i)
    {
        if(parent[i]==i)
            return i;
        return parent[i]=i;
    }

    public static void sort(int[] arr,boolean reverse){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n =arr.length;
        for(int i=0;i<n;i++){
            list.add(arr[i]);
        }

        if(reverse)
        Collections.sort(list,Collections.reverseOrder());
        else
        Collections.sort(list);

        for(int i=0;i<n;i++){
            arr[i] = list.get(i);
        }
    }

    public static double min(double ...a){
        double min=Double.MAX_VALUE;
        for(double i : a)
        min =Math.min(i,min);
        return min;
    }

    public static long min(long ...a){
        long min=Long.MAX_VALUE;
        for(long i : a)
        min =Math.min(i,min);
        return min;
    }

    public static int min(int ...a){
        int min=Integer.MAX_VALUE;
        for(int i : a)
        min =Math.min(i,min);
        return min;
    }

    public static double max(double ...a){
        double max=Double.MIN_VALUE;
        for(double i : a)
        max =Math.max(i,max);
        return max;
    }

    public static long max(long ...a){
        long max=Long.MIN_VALUE;
        for(long i : a)
        max =Math.max(i,max);
        return max;
    }

    public static int max(int ...a){
        int max=Integer.MIN_VALUE;
        for(int i : a)
        max =Math.max(i,max);
        return max;
    }

    public static long pow(long a,long b){
        long res=1;
        while(b>0){
            if((b&1)==1)
                res = res*a;
            a=a*a;
            b >>= 1;
        }
        return res;
    }

    public static long pow(long a,long b,long m){
        a%=m;
        long res=1;
        while(b>0){
            if((b&1)==1)
                res = (res*a)%m;
            a=(a*a)%m;
            b >>= 1;
        }
        return res;
    }

    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    static class Pair{

        // Implementing equals() and hashCode()
        // Map<Pair, V> map = //...

        private final int x;
        private final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    static FastScanner sc = new FastScanner();
    static PrintWriter out =new PrintWriter(System.out);

    static class FastScanner {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st=new StringTokenizer("");
            String next() {
                while (!st.hasMoreTokens())
                    try {
                        st=new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                return st.nextToken();
            }

            int nextInt() {
                return Integer.parseInt(next());
            }
            int[] readArray(int n) {
                int[] a=new int[n];
                for (int i=0; i<n; i++) a[i]=nextInt();
                return a;
            }
            long nextLong() {
                return Long.parseLong(next());
            }
            float nextFloat() {
                return Float.parseFloat(next());
            }
            double nextDouble() {
                return Double.parseDouble(next());
            }
            public long[] readLongArray(int n) {
                long[] a=new long[n];
                for (int i=0; i<n; i++) a[i]=nextLong();
                return a;
            }
            public double[] readDoubleArray(int n) {
                double[] a=new double[n];
                for (int i=0; i<n; i++) a[i]=nextDouble();
                return a;
            }
    }
}

/*
4 4
1 2 4
2 3 4
3 4 4
1 4 13
 */