import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.imageio.plugins.tiff.FaxTIFFTagSet;

public class entry_3958566 {
    public static void main(String args[]){
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt(), m = in.nextInt(), k = in.nextInt();
        int a[] = new int[n], b[] = new int[m];

        for(int i=0; i<n; i++) a[i] = in.nextInt();
        for(int i=0; i<m; i++) b[i] = in.nextInt();

        sort(a); sort(b);

        int acnt = 0, bcnt = 0, ans = 0;
        while(acnt < n && bcnt < m){
            if(a[acnt]-k <= b[bcnt] && b[bcnt] <= a[acnt]+k){
                acnt++;
                bcnt++;
                ans++;
            }
            else if(b[bcnt] < a[acnt]-k) bcnt++;
            else if(a[acnt]+k < b[bcnt]) acnt++;
        }
        out.println(ans);
        out.close();
    }

    /**
     * Uses collections.sort to ensure nlogn runtime
     * as compared to arrays.sort's n^2 worst case runtime
     */
    static void sort(int[] a) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i : a)
            al.add(i);
        Collections.sort(al);
        for (int i = 0; i < a.length; i++)
            a[i] = al.get(i);
    }

    /**
     * This is a private template class for fast scanning. It has the same basic reading methods as Scanner
     * like nextInt(), nextLong(), etc.
     * It is recommended that you use this template for all the problems you solve.
     */
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        String next() {while (!st.hasMoreTokens())try {st = new StringTokenizer(br.readLine());} catch (IOException e) {}return st.nextToken();}
        int nextInt() {return Integer.parseInt(next());}
        long nextLong() {return Long.parseLong(next());}
        double nextDouble() {return Double.parseDouble(next());}
        int[] readArray(int n) { int[] a = new int[n]; for (int i = 0; i < n; i++) {a[i] = nextInt();} return a;}
    }
}