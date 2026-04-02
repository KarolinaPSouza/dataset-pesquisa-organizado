//package CSES.Sorting_Searching;

import java.io.*;
import java.util.*;

public class entry_4322265 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> used_values = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (used_values.containsKey(target - nums[i])) {
                pw.println((i + 1) + " " + used_values.get(target - nums[i]));
                pw.close();
                System.exit(0);
            }
            used_values.put(nums[i], i + 1);
        }
        pw.println("IMPOSSIBLE");
        pw.close();
    }
}