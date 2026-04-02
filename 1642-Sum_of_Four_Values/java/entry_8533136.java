import java.io.*;
import java.util.*;

public class entry_8533136 {
  public static void main(String[] args) throws Throwable {
    int n = readInt();
    int x = readInt();
    int[] nums = readInts(n);

    Map<Integer, int[]> combos = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        int sum = nums[i] + nums[j];
        int[] need = combos.get(x - sum);
        if (need != null) {
          int k = need[0];
          int l = need[1];
          System.out.printf("%d %d %d %d%n", k + 1, l + 1, i + 1, j + 1);
          return;
        }
      }

      for (int j = 0; j < i; ++j) {
        int sum = nums[i] + nums[j];
        combos.put(sum, new int[] { j, i });
      }
    }

    System.out.println("IMPOSSIBLE");
  }

  static int[] readInts(int n) throws Throwable {
    int[] res = new int[n];
    for (int i = 0; i < n; ++i) {
      res[i] = readInt();
    }
    return res;
  }

  static int readInt() throws Throwable {
    int res = 0;
    while (true) {
      int d = System.in.read() - '0';
      if (d < 0 || d > 9) {
        return res;
      }
      res = res * 10 + d;
    }
  }
}