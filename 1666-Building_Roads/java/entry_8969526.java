// Rohit Bohra | 10/04/2024 : 01:05:25
import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class entry_8969526{

    static int find(int[] parent, int i)
    {
        if(parent[i]==i) return i;
        return parent[i] = find(parent, parent[i]);
    }

    public static void main(String args[])throws IOException{

        int n=sc.nextInt();
        int m=sc.nextInt();

        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++)
        parent[i]=i;

        for(int i=0;i<m;i++)
        {
            int[] road = sc.readArray(2);
            int p1 = find(parent,road[0]);
            int p2 = find(parent,road[1]);

            parent[p1]=p2;
        }

        Set<Integer> heads = new HashSet<>();
        for(int i=1;i<=n;i++)
        {
            heads.add(find(parent,i));
        }

        int roadsRequired = heads.size()-1;
        int start = find(parent,1);

        out.println(roadsRequired);

        for(int head : heads)
        {
            if(start==head) continue;
            out.println(start+" "+head);
        }

        out.close();
    }


    static int M=(int)Math.pow(10,9)+7;

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
