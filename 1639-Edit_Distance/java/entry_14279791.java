import java.io.*;
import java.util.*;

public class entry_14279791 {

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//  StringTokenizer st;
//  st = new StringTokenizer(br.readLine());
//  int N = Integer.parseInt(st.nextToken());
//  int maxWeight = Integer.parseInt(st.nextToken());
//  int[][] items = new int[N][2];
//  for(int i = 0; i < N; i++) {
//   st = new StringTokenizer(br.readLine());
//   items[i][0] = Integer.parseInt(st.nextToken());
//   items[i][1] = Integer.parseInt(st.nextToken());
//  }
  long ans = edit(br.readLine(), br.readLine());
  // Output result
  PrintWriter out = new PrintWriter(System.out);
  out.print(ans);
  out.flush();

 }

 private static int edit(String a, String b) {
  int[][] distance = new int[a.length() + 1][b.length() + 1];
  for(int i = 1; i < distance.length; i++) {
   Arrays.fill(distance[i], -1);
  }
  for(int i = 1; i < distance.length; i++) {
   distance[i][0] = i;
  }
  for(int i = 1; i < distance[0].length; i++) {
   distance[0][i] = i;
  }
  return findDistance(distance, a, b, a.length(), b.length());
 }

 private static int findDistance(int[][] distance, String a, String b, int posA, int posB) {
  if(distance[posA][posB] != -1) {
   return distance[posA][posB];
  }
  int match = findDistance(distance, a, b, posA - 1, posB - 1) + (a.charAt(posA - 1) == b.charAt(posB - 1) ? 0 : 1);
  int updown = 1 + Math.min(findDistance(distance, a, b, posA, posB - 1), findDistance(distance, a, b, posA - 1, posB));
  match = Math.min(match, updown);
  distance[posA][posB] = match;
  return match;
 }
}