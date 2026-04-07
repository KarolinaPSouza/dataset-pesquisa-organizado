import java.util.*;
import java.io.*;

/**
 * Made by egor https://github.com/chermehdi/egor.
 * 
 * @author Azuz
 * 
 */
public class entry_1099026 {

    void solve(Scanner in, PrintWriter out) {
      HashSet<Integer> set = new HashSet<>();
      int n = in.nextInt();
      for (int i = 0; i < n; ++i) {
        set.add(in.nextInt());
      }
      out.println(set.size());
    }

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out)) {
            new entry_1099026().solve(in, out);
        }
    }
}