import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class entry_11366096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        System.out.println(map.size());

    }
}