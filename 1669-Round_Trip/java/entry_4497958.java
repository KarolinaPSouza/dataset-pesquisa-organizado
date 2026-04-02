// Created on: 11:03:10 am | 14-Jun-2022

import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.lang.*;

public class entry_4497958 {
      static InputStream is;
      static PrintWriter out;
      static String INPUT = "";
      static boolean cases = false;

      static void solve() {
     int caseNo = 1;
     for (int T = cases ? sc.nextInt() : 1; T > 0; T--, caseNo++) { solveIt(caseNo); }
      }

      // Solution
      static void solveIt(int t) {
     int n = sc.nextInt();
     int m = sc.nextInt();
     List<Integer>[] al = new ArrayList[n + 1];
     for (int i = 0; i <= n; i++) al[i] = new ArrayList<>();
     for (int i = 0; i < m; i++) {
    int x = sc.nextInt();
    int y = sc.nextInt();
    al[x].add(y);
    al[y].add(x);
     }
     boolean[] vis = new boolean[n + 1];
     int par[] = new int[n + 1];
     for (int i = 1; i <= n; i++) {
    if (!vis[i]) {
   Queue<Integer> q = new LinkedList<>();
   q.add(i);
   vis[i] = true;
   while (!q.isEmpty()) {
         int size = q.size();
         while (size-- > 0) {
        int curr = q.remove();
        for (int next : al[curr]) {
       if (vis[next]) {
      if (par[curr] == next) continue;
      List<Integer> ans1 = new ArrayList<>();
      List<Integer> ans2 = new ArrayList<>();

      Set<Integer> set = new HashSet<>();
      int j = curr;
      while (j > 0) {
            set.add(j);
            j = par[j];
      }
      int p = 0;
      j = next;
      while (j > 0) {
            if (set.contains(j)) {
           p = j;
           break;
            }
            j = par[j];
      }
      ans1.add(next);
      j = curr;
      while (j != p) {
            ans1.add(j);
            j = par[j];
      }
      ans1.add(p);
      j = next;
      while (j != p) {
            ans2.add(j);
            j = par[j];
      }
      out.println(ans1.size() + ans2.size());
      for (int x : ans1) out.print(x + " ");
      for (j = ans2.size() - 1; j >= 0; j--) out.print(ans2.get(j) + " ");
      return;
       } else {
      q.add(next);
      vis[next] = true;
      par[next] = curr;
       }
        }
         }
   }
    }
     }
     out.println("IMPOSSIBLE");
      }

      public static void main(String[] args) throws Exception {
     long S = System.currentTimeMillis();
     is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
     out = new PrintWriter(System.out);

     solve();
     out.flush();
     long G = System.currentTimeMillis();
     sc.tr(G - S + "ms");
      }

      static class sc {
     private static boolean endOfFile() {
    if (bufferLength == -1) return true;
    int lptr = ptrbuf;
    while (lptr < bufferLength) if (!isThisTheSpaceCharacter(inputBufffferBigBoi[lptr++])) return false;

    try {
   is.mark(1000);
   while (true) {
         int b = is.read();
         if (b == -1) {
        is.reset();
        return true;
         } else if (!isThisTheSpaceCharacter(b)) {
        is.reset();
        return false;
         }
   }
    } catch (IOException e) {
   return true;
    }
     }

     private static byte[] inputBufffferBigBoi = new byte[1024];
     static int bufferLength = 0, ptrbuf = 0;

     private static int justReadTheByte() {
    if (bufferLength == -1) throw new InputMismatchException();
    if (ptrbuf >= bufferLength) {
   ptrbuf = 0;
   try {
         bufferLength = is.read(inputBufffferBigBoi);
   } catch (IOException e) {
         throw new InputMismatchException();
   }
   if (bufferLength <= 0) return -1;
    }
    return inputBufffferBigBoi[ptrbuf++];
     }

     private static boolean isThisTheSpaceCharacter(int c) { return !(c >= 33 && c <= 126); }

     private static int skipItBishhhhhhh() {
    int b;
    while ((b = justReadTheByte()) != -1 && isThisTheSpaceCharacter(b));
    return b;
     }

     private static double nextDouble() { return Double.parseDouble(next()); }

     private static char nextChar() { return (char) skipItBishhhhhhh(); }

     private static String next() {
    int b = skipItBishhhhhhh();
    StringBuilder sb = new StringBuilder();
    while (!(isThisTheSpaceCharacter(b))) {
   sb.appendCodePoint(b);
   b = justReadTheByte();
    }
    return sb.toString();
     }

     private static char[] readCharArray(int n) {
    char[] buf = new char[n];
    int b = skipItBishhhhhhh(), p = 0;
    while (p < n && !(isThisTheSpaceCharacter(b))) {
   buf[p++] = (char) b;
   b = justReadTheByte();
    }
    return n == p ? buf : Arrays.copyOf(buf, p);
     }

     private static char[][] readCharMatrix(int n, int m) {
    char[][] map = new char[n][];
    for (int i = 0; i < n; i++) map[i] = readCharArray(m);
    return map;
     }

     private static int[] readIntArray(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = nextInt();
    return a;
     }

     private static long[] readLongArray(int n) {
    long[] a = new long[n];
    for (int i = 0; i < n; i++) a[i] = nextLong();
    return a;
     }

     private static int nextInt() {
    int num = 0, b;
    boolean minus = false;
    while ((b = justReadTheByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
    if (b == '-') {
   minus = true;
   b = justReadTheByte();
    }

    while (true) {
   if (b >= '0' && b <= '9') {
         num = num * 10 + (b - '0');
   } else {
         return minus ? -num : num;
   }
   b = justReadTheByte();
    }
     }

     private static long nextLong() {
    long num = 0;
    int b;
    boolean minus = false;
    while ((b = justReadTheByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
    if (b == '-') {
   minus = true;
   b = justReadTheByte();
    }

    while (true) {
   if (b >= '0' && b <= '9') {
         num = num * 10 + (b - '0');
   } else {
         return minus ? -num : num;
   }
   b = justReadTheByte();
    }
     }

     private static void tr(Object... o) { if (INPUT.length() != 0) System.out.println(Arrays.deepToString(o)); }
      }
}