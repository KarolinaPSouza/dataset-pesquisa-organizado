import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class entry_13782898 {
    static int[] arr;
    static BufferedReader bufferedReader = new BufferedReader(new java.io.InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int target = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            int complement = target - arr[i];
            if(map.containsKey(complement)) {
                System.out.println((map.get(complement)) + " " + (i + 1));
                return;
            }
            map.put(arr[i],i+1);
        }
        System.out.println("IMPOSSIBLE");

    }
}