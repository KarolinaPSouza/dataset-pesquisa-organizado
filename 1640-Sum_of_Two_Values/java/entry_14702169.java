import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_14702169 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter written = new PrintWriter(System.out);

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int x = Integer.parseInt(line[1]);

        int arr[] = new int[n];
        Map<Integer, List<Integer>> loc = new HashMap<>();
        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line2[i]);
            List<Integer> lst = loc.get(arr[i]);
            if (lst == null) {
                lst = new ArrayList<>();
            }
            lst.add(i+1);
            loc.put(arr[i], lst);
        }


        Arrays.sort(arr);
        int l = 0;
        int r = n-1;
        while(r>=1 && l<=n-1 && r>l) {
            int sum = arr[l] + arr[r];
            if (sum == x) {
                // resolve value;
                int val1;
                int val2;
                if (arr[l] == arr[r]) {
                    List<Integer> lst = loc.get(arr[l]);
                    val1 = lst.get(0);
                    val2 = lst.get(1);
                } else {
                    val1 = loc.get(arr[l]).get(0);
                    val2 = loc.get(arr[r]).get(0);
                }
                written.println(String.format("%d %d", val1, val2));
                written.close();
                return;
            } else if (sum > x) {
                r--;
            } else {
                l++;
            }
        }
        written.println("IMPOSSIBLE");
        written.close();
    }
}