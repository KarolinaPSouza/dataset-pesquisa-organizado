import java.util.Scanner;
import java.util.TreeSet;

public class entry_1239902 {
 public static void main(String [] args)
 {
  Scanner kb = new Scanner(System.in);
  int n = Integer.parseInt(kb.nextLine().trim());
  TreeSet<Integer> set = new TreeSet<Integer>();
  for(int i = 0;i<n;i++)
  {
   int c = Integer.parseInt(kb.next());
   set.add(c);
  }
  System.out.println(set.size());
 }
}