import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class entry_2506418 {
    static long check(long n) {
        for(int i=2;i*i<=n;i++) {
            if(n%i==0)return i;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        FastScanner s=new FastScanner();
        int mod = (int) 1e9+7;
//        int t = s.nextInt();
        int t = 1;
        while(t-->0) {
         int n =s.nextInt();
         int x = s.nextInt();
         int[] dp = new int[(int)1e7];
         int[] a = new int[n+1];
         for(int i=1;i<=n;i++)a[i] = s.nextInt();
         for(int i=1;i<=x;i++) {
          dp[i]=mod;
          for(int j=1;j<=n;j++) {
           if(a[j]<=i)dp[i] = Math.min(dp[i],dp[i-a[j]]+1);
          }
         }
         System.out.println(dp[x]==mod?-1:dp[x]);

        }
    }
    static int lower_bound(int[] arr, int x) {
        int low_limit = 0, high_limit = arr.length, mid = -1;
        while (low_limit < high_limit) {
            mid = (low_limit + high_limit) / 2;
            if (arr[mid] >= x){
                high_limit = mid;
            }else{
                low_limit = mid + 1;
            }
        }
        return low_limit+1;
    }
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}

    static void sortr(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l,Collections.reverseOrder());
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
    static void sort(long[] a) {
        ArrayList<Long> l=new ArrayList<>();
        for (long i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }
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
    }
}