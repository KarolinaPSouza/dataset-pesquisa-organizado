/*
     ॐ त्र्यम्बकं यजामहे सुगन्धिं पुष्टिवर्धनम् |
     उर्वारुकमिव बन्धनान्मृत्योर्मुक्षीय माऽमृतात् ||
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "entry_6074288" only if the class is public. */
public class entry_6074288 {
    static FastReader scan = new FastReader();
    static final Random random = new Random();
    static long mod = 1000000007L;
    //static HashMap<String,Integer> map=new HashMap<>();

    //=======================entry_6074288 Program==========================

    public static void main(String args[]) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();

        }
    }

    public static void solve() {
        int n = scan.nextInt();
        long k = scan.nextLong();
        long[][] arr = new long[n][2];
        for(int i = 0; i < n; i++){
            long num = scan.nextLong();
            arr[i][0] = num;
            arr[i][1] = i+1;
        }
        Arrays.sort(arr, Comparator.comparing(o->o[0]));
        // println(Arrays.deepToString(arr));
        int i = 0;
        int j = n-1;
        boolean flag = false;
        while(i < j){
            long sum = arr[i][0]+arr[j][0];
            if(sum == k){
                flag = true;
                break;
            } else if(sum > k){
                j--;
            } else {
                i++;
            }
        }
        if(flag){
            if(arr[i][1] < arr[j][1]){
                println(arr[i][1] + " " + arr[j][1]);
            } else {
                println(arr[j][1] + " " + arr[i][1]);
            }

        } else {
            println("IMPOSSIBLE");
        }


    }

    static long binExpo(long a, long b) {
        if (b == 0) return 1;
        long res = binExpo(a, b / 2) % mod;
        if ((b & 1) == 1) {
            return a * res * res % mod;
        } else {
            return res * res % mod;
        }
    }

    //=======================Useful Functions======================
    static <E> void println(E res) {
        System.out.println(res);
    }

    static void println() {
        System.out.println();
    }

    static <E> void print(E res) {
        System.out.print(res);
    }

    static int[] intArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        return arr;

    }

    static long[] longArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLong();
        }
        return arr;

    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] readintarray(int n) {
            int res[] = new int[n];
            for (int i = 0; i < n; i++) res[i] = nextInt();
            return res;
        }

        long[] readlongarray(int n) {
            long res[] = new long[n];
            for (int i = 0; i < n; i++) res[i] = nextLong();
            return res;
        }
    }


}