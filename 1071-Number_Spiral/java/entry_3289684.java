import java.io.*;
import java.util.*;


// Correct solution and algrothim, java being slow
public class entry_3289684 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    // check to see if role is bigger or column is bigger
    // mod the bigger number
    // find the value by subtracting or adding

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
        long y = Integer.parseInt(st.nextToken());
        long x = Integer.parseInt(st.nextToken());
        if (x > y) {
            if (x % 2 == 1) System.out.println(x*x - y + 1);
            else System.out.println((x-1)*(x-1) + y);
        }
        else {
            if (y % 2 == 1) System.out.println((y-1)*(y-1) + x);
            else System.out.println(y*y - x + 1);
        }
    }
  }
}