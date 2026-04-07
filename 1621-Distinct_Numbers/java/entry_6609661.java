import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class entry_6609661 {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  Set<Long> a = new HashSet<Long>();

  while(n>0) {
   a.add(sc.nextLong());
   n--;   
  }
  System.out.println(a.size());


 }
}