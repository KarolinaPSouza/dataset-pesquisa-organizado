import java.io.*;
import java.util.*;

public class entry_11618912 {
    static class Pair implements Comparable<Pair> {
        int elem;
        int initorend;

        Pair(int e, int p) {
            this.elem = e;
            this.initorend = p;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.elem != o.elem)
                return this.elem - o.elem;
            return this.initorend - o.initorend;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pair> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] interval = br.readLine().split(" ");
            int a = Integer.parseInt(interval[0]), b = Integer.parseInt(interval[1]);
            arr.add(new Pair(a, 1)); // Start of interval
            arr.add(new Pair(b + 1, -1)); // End of interval (b + 1 to exclude)
        }

        // Sort using Comparable
        Collections.sort(arr);

        // Calculate maximum overlap
        int max = 1, cur = 0;
        for (Pair pr : arr) {
            cur += pr.initorend;
            max = Math.max(max, cur);
        }

        System.out.println(max);
    }
}

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Scanner;

// public class entry_11618912 {
// static class Pair implements Comparable<Pair> {
// int elem;
// int initorend;

// Pair(int e, int p) {
// elem = e;
// initorend = p;
// }

// @Override
// public int compareTo(entry_11618912.Pair o) {
// if (this.elem != o.elem)
// return this.elem - o.elem;
// return this.initorend - o.initorend;
// }
// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int n = sc.nextInt();
// ArrayList<Pair> arr = new ArrayList<>();

// for (int i = 0; i < n; i++) {
// int a = sc.nextInt(), b = sc.nextInt();
// arr.add(new Pair(a, 1));
// arr.add(new Pair(b + 1, -1));
// }
// Collections.sort(arr);
// int max = 1;
// int cur = 0;
// for (Pair pr : arr) {
// cur += pr.initorend;
// max = Math.max(max, cur);
// }
// System.out.println(max);

// }
// }