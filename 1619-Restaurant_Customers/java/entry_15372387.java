import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class entry_15372387 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (String num : input) {
                set.add(Integer.parseInt(num));
            }
        }

        System.out.println(set.size());
    }
}