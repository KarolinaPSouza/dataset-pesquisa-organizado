import java.util.*;

public class entry_5154871 {
  public static void main (String[]args)
  {
    Scanner in = new Scanner (System.in);
    StringBuilder ans = new StringBuilder ();
    for (int t = in.nextInt (); t > 0; t--)
      {
 long x = in.nextInt (), y = in.nextInt ();
 long row = Math.max (x, y);
    ans.append (row*row - ((row%2 == 0 ? y : x) - 1) - (row - (row%2 == 0 ? x : y))).append ("\n");
      }
    System.out.println (ans);
  }
}