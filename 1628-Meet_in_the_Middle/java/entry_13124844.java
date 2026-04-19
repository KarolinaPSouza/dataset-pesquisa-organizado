import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class entry_13124844 {
 
  public static void main(String[] args) {
 
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      StringTokenizer firstLine = new StringTokenizer(br.readLine());
      StringTokenizer secondLine = new StringTokenizer(br.readLine());
 
      int n = Integer.parseInt(firstLine.nextToken());
      int target = Integer.parseInt(firstLine.nextToken());
      int[] arr = new int[n];
 
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(secondLine.nextToken());
      }
 
      numberOfSums(arr, target, n);
 
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
 
  public static void numberOfSums(int[] arr, int target, int n) {
    int leftStart = 0;
    int leftEnd = (n >> 1) - 1;
    int leftSize = leftEnd - leftStart + 1;
 
    int rightStart = (n >> 1);
    int rightEnd = arr.length - 1;
    int rightSize = rightEnd - rightStart + 1;
 
    Arrays.sort(arr);
    HashMap<Integer, Integer> left = new HashMap<>(2 << ((n >> 1)+1));
 
    for (int i = 0; i < (1L << leftSize); i++) {
      long sum = 0;
 
      for (int j = 0; j < leftSize; j++) {
        if ((i & (1L << j)) != 0) {
          sum += arr[leftStart + j];
        }
      }
      if (sum <= target) {
        left.put((int) sum, left.getOrDefault((int) sum, 0) + 1);
      }
    }
 
    long count = 0;
 
    for (int i = 0; i < (1L << rightSize); i++) {
      long sum = 0;
 
      for (int j = 0; j < rightSize; j++) {
        if ((i & (1L << j)) != 0) {
          sum += arr[rightStart + j];
        }
      }
      if (sum <= target) {
        count += left.getOrDefault(target - (int) sum, 0);
      }
    }
 
    System.out.println(count);
  }
}
 
