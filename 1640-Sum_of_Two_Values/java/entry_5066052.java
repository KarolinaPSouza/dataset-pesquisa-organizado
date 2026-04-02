/*
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
 import java.util.*;
  public class entry_5066052 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int target = scan.nextInt();
        int[] arr = new int[len];
        List<Point> list = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            arr[i] = scan.nextInt();
            Point p = new Point();
            p.x = arr[i];
            p.y = i;
        }
        list.sort();
        int left = 0;
        int right = arr.length-1;
        boolean hasAnswer = false;
        while(left<right){
            if(arr[left] + arr[right] == target){
                hasAnswer = true;
                break;
            }
            if(arr[left] + arr[right] < target){
                left++;
            }
            else{
                right--;
            }
        }
        if(hasAnswer){
            System.out.println(left + " " + right);
        }
        else {
            System.out.println("IMPOSSIBLE");
        }
    }
}*/

import java.io.*;
import java.util.*;

public class entry_5066052 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int N = io.nextInt();
        int X = io.nextInt();

        List<Pair> a = new ArrayList<>();

        // append the element and its index
        for (int i = 0; i < N; i++) {
            int x = io.nextInt();
            a.add(new Pair(x, i + 1));
        }
        Collections.sort(a);
        int i = 0, j = (int) N - 1;
        while (i < j) {
            // adjust the left and right pointers.
            if (a.get(i).val + a.get(j).val > X)
                j--;
            else if (a.get(i).val + a.get(j).val < X)
                i++;
            else if (a.get(i).val + a.get(j).val == X) {
                io.println(a.get(i).index + " " + a.get(j).index);
                io.close();
                return;
            }
        }
        io.println("IMPOSSIBLE");
        io.close();
    }

    static class Pair implements Comparable<Pair> {
        int val, index;

        public Pair(int x, int y) {
            this.val = x;
            this.index = y;
        }

        public int compareTo(Pair o) {
            return -Integer.compare(o.val, val);
        }
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}