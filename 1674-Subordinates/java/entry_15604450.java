import java.io.*;
import java.util.*;

public class entry_15604450 {

 static class FastScanner {
  private final byte[] buffer = new byte[1 << 16];
  private int ptr = 0, len = 0;

  private int read() throws IOException {
   if (ptr >= len) {
    len = System.in.read(buffer);
    ptr = 0;
    if (len <= 0)
     return -1;
   }
   return buffer[ptr++];
  }

  int nextInt() throws IOException {
   int c, sign = 1, val = 0;
   do
    c = read();
   while (c <= ' ');
   if (c == '-') {
    sign = -1;
    c = read();
   }
   while (c > ' ') {
    val = val * 10 + (c - '0');
    c = read();
   }
   return val * sign;
  }
 }

 public static void main(String[] args) throws Exception {
  FastScanner fs = new FastScanner();
  int n = fs.nextInt();

  List<List<Integer>> adj = new ArrayList<>();
  for (int i = 0; i <= n; i++)
   adj.add(new ArrayList<>());

  for (int u = 2; u <= n; u++) {
   int v = fs.nextInt();
   adj.get(v).add(u);
  }

  int[] ans = new int[n + 1];

  Stack<Integer> stack = new Stack<>();
  List<Integer> order = new ArrayList<>();

  stack.push(1);

  while (!stack.isEmpty()) {
   int node = stack.pop();
   order.add(node);
   for (int ch : adj.get(node)) {
    stack.push(ch);
   }
  }

  for (int i = order.size() - 1; i >= 0; i--) {
   int node = order.get(i);
   for (int ch : adj.get(node)) {
    ans[node] += ans[ch] + 1;
   }
  }

  StringBuilder sb = new StringBuilder();
  for (int i = 1; i <= n; i++) {
   sb.append(ans[i]).append(" ");
  }
  System.out.println(sb);
 }
}