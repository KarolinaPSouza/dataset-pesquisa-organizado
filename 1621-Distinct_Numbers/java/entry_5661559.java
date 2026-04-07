import java.util.HashSet;
import java.util.Scanner;

public class entry_5661559 {
 public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  int n = in.nextInt();
  HashSet<Integer> h = new HashSet<Integer>(n);
  for(int i =0;i<n;i++) {
   h.add(in.nextInt());
  }
  System.out.println(h.size());
 }
}