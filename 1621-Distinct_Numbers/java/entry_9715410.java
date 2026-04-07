// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.*;
public class entry_9715410 {

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      //int[] arr = new int[n];
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        int x = Integer.parseInt(st.nextToken());
        map.put(x, map.getOrDefault(x, 0)+1);
      }

      System.out.println(map.size());
  }

}