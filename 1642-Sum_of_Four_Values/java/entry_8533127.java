import java.io.*;
import java.util.*;

public class entry_8533127 {
  public static void main(String[] args) throws Throwable {
    int n = readInt();
    int x = readInt();
    int[] nums = readInts(n);

    Map<Integer, List<int[]>> combos = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        int sum = nums[i] + nums[j];
        int need = x - sum;

        for (int[] other : combos.getOrDefault(need, Collections.emptyList())) {
          int k = other[0];
          int l = other[1];
          if (k != i && k != j && l != i && l != j) {
            System.out.printf("%d %d %d %d%n", i + 1, j + 1, k + 1, l + 1);
            return;
          }
        }

        combos.computeIfAbsent(sum, k -> new ArrayList<>())
          .add(new int[]{ i, j });
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