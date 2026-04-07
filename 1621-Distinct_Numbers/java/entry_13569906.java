import java.io.*;
import java.util.*;

public class entry_13569906 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            hs.add(Integer.parseInt(input[i]));
        }

        System.out.println(hs.size());
    }
}