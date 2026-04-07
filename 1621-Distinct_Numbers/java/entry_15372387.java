import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class distinct {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(input[i]));
        }

        System.out.println(set.size());
    }
}