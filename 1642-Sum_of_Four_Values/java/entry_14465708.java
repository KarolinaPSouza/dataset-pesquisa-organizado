import java.util.*;
import java.io.*;
public class entry_14465708 {
 public static void main(String[] args) throws Exception {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  long x = sc.nextLong();
  long[] arr = new long[n];
  for (int i = 0; i < n; i++) {
      long a = sc.nextLong();
      arr[i] = a;
  }
  HashMap<Long, int[]> map = new HashMap<>();
  for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
          map.put(arr[j] + arr[i], new int[]{j, i});
      }
  }
  //System.out.println(map);
  for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
          long sum = arr[i] + arr[j];
          long need = x - sum;
          if (map.containsKey(need)) {
              int[] pair = map.get(need);
              if (pair[0] != i && pair[0] != j && pair[1] != i && pair[1] != j) {
                  System.out.println((pair[0]+1) + " " + (pair[1]+1) + " " + (i+1) + " " + (j+1));
                  return;
              }
          }
      }
      /*
      for (int j = 0; j < i; j++) {
          map.put(arr[j] + arr[i], new int[]{j, i});
      }
      */
  }
  System.out.println("IMPOSSIBLE");
  /*
  Input:
                8 15
        3 2 5 8 1 3 2 3
        Output:
                2 4 6 7
                hashmap = {(5, (0, 1)), (8, (0, 2)), ... (7, (1, 2)), ..., (5, (6, 7))}
        note: check that all indices are distinct
  */

 }
}