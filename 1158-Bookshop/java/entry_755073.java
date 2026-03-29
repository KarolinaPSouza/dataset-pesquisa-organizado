import java.util.Scanner;

public class entry_755073 {

 public static void main(String[] args) {
  Scanner input = new Scanner(System.in);

  while (input.hasNext()) {
   int n = input.nextInt();
   int x = input.nextInt();
   int[] h = new int[n];
   int[] s = new int[n];

   for (int i = 0; i < h.length; ++i) {
    h[i] = input.nextInt();
   }

   for (int i = 0; i < s.length; ++i) {
    s[i] = input.nextInt();
   }

   int[] pages = new int[x + 1];

   for (int i = 0; i < n; ++i) {
    for (int j = pages.length - 1; j >= 0; --j) {
     if (j - h[i] >= 0) {
      pages[j] = Math.max(pages[j], pages[j - h[i]] + s[i]);
     }
    }
   }

   System.out.println(pages[x]);
  }
 }

}