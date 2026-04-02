import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class entry_14888498 {

 static int[] head;
 static int[] to;
 static int[] next;

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int length = Integer.parseInt(br.readLine());
  PrintWriter out = new PrintWriter(System.out);
  StringTokenizer st = new StringTokenizer(br.readLine());
  head = new int[length + 1];
  Arrays.fill(head, -1);
  to = new int[length];
  next = new int[length];
  int edge = 1;

  for (int i = 2; i <= length; i++) {
   int boss = Integer.parseInt(st.nextToken());
   addEdge(edge++, boss, i);
  }
  long[] ans = new long[length + 2];

  int[] stack = new int[length];
  int[] back = new int[length];
  stack[0] = 1;
  int stackPt = 1;
  int expand = 0;

  while(stackPt != expand) {
   int e = head[stack[expand]];
   while(e != -1) {
    back[stackPt] = stack[expand];
    stack[stackPt++] = to[e];
    e = next[e];
   }
   expand++;
  }

  for(int i = --stackPt; i > 0; i--) {
   ans[back[i]] += 1 + ans[stack[i]];
  }

  StringBuilder print = new StringBuilder();
  for (int i = 1; i <= length; i++) {
   print.append(ans[i]);
   print.append(" ");
  }
  out.println(print.toString());
  out.flush();
 }
 public static void addEdge(int edge, int source, int target) {
  to[edge] = target; 
  next[edge] = head[source]; 
  head[source] = edge;
 }
}