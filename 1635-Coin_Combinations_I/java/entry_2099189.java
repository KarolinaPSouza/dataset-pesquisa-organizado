import java.util.*;
import java.lang.*;
import java.io.*;


public class entry_2099189 {
    class Pair<S extends Comparable<S>, T extends Comparable<T>> implements Comparable<Pair<S, T>> {
        S first;
        T second;

        Pair(S f, T s) {
            first = f;
            second = s;
        }

        @Override
        public int compareTo(Pair<S, T> o) {
            int t = first.compareTo(o.first);
            if (t == 0) return second.compareTo(o.second);
            return t;
        }

        @Override
        public int hashCode() {
            return (31 + first.hashCode()) * 31 + second.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            if (o == this) return true;
            Pair p = (Pair) o;
            return first.equals(p.first) && second.equals(p.second);
        }

        @Override
        public String toString() {
            return "Pair{" + first + ", " + second + "}";
        }
    }
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
    public static void main (String[] args) throws java.lang.Exception
    {
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }
        FastReader sc = new FastReader();
        int t =1;
        PrintWriter out=new PrintWriter(System.out);
        while(t-->0){
            solve(sc,out);
        }
         out.close();
    }
    static void solve(FastReader sc,PrintWriter out) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int arr[] =  new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        long dp[] = new long[x+1];
        long  mod=(long)1e9+7;
        dp[0]=1;
        for(int i=1;i<=x;i++){
            for(int j=0;j<n;j++){
                if(i-arr[j]>=0){
                    if(dp[i-arr[j]]!=0){
                        dp[i]+=dp[i-arr[j]];

                    }
                }
            }
            dp[i]%=mod;

        }

        out.println(dp[x]);




    }
}