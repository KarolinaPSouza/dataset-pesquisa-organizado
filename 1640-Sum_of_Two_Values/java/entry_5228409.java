import java.io.*;
import java.util.*;

public class entry_5228409 {
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  int x = Integer.parseInt(st.nextToken());
  int[] nums = new int[n];
  Integer[] ind = new Integer[n];

  st = new StringTokenizer(br.readLine());
  for (int i = 0; i < n; i++) {
   nums[i] = Integer.parseInt(st.nextToken());
   ind[i] = i;
  }
  br.close();

  Arrays.sort(ind, Comparator.comparingInt(j -> nums[j]));
  Arrays.sort(nums);

  int l = 0;
  int r = n-1;

  while (r>l) {
   /*
   while (nums[l] + nums[r] > x && r > l) r--;
   if (nums[l] + nums[r] == x && r != l) {
    System.out.println((ind[l]+1) + " " + (ind[r]+1));
    break;
   }
   l++;
   */
   if (nums[l] + nums[r] == x) {
    System.out.println((ind[l]+1) + " " + (ind[r]+1));
    break;
   } else if (nums[l] + nums[r] > x) {
    r--;
   } else {
    l++;
   }
  }

  if (l >= r) System.out.println("IMPOSSIBLE");
 }
}