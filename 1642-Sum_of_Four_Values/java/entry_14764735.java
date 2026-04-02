//package Basics.TwoPointers;

import java.io.*;
import java.util.*;

// Problem: https://cses.fi/problemset/task/1642
public class entry_14764735 {
    static class Pair {
        int ind;
        int val;

        public Pair(int ind, int val) {
            this.ind = ind;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int target = in.nextInt();

        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair(i + 1, in.nextInt());
        }

        int[] ans = solve(a, n, target);

        if (ans[0] == -1) out.println("IMPOSSIBLE");
        else {
            Arrays.sort(ans);
            for (int e : ans) out.print(e + " ");
        }

        out.close();
    }

    static int[] solve(Pair[] a, int n, int target) {
        Map<Integer, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = a[i].val + a[j].val;

                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }

                map.get(sum).add(new Pair(a[i].ind, a[j].ind));
            }
        }

        for (int key : map.keySet()) {
            int remSum = target - key;
            Pair firstPair = map.get(key).get(0);

            if (map.containsKey(remSum)) {
                for (Pair p : map.get(remSum)) {
                    if (!haveCommon(p, firstPair)) {
                        return new int[]{firstPair.ind, firstPair.val, p.ind, p.val};
                    }
                }
            }
        }

        return new int[]{-1, -1, -1, -1};
    }

    static boolean haveCommon(Pair a, Pair b) {
        if (a.ind == b.ind || a.ind == b.val || a.val == b.ind || a.val == b.val) {
            return true;
        }
        return false;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}