import java.io.*;
import java.util.*;

public class entry_13344402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int x = 0, y = 0, count = 0, max = 0;
        while (x < n && y < n) {
            if (arr1[x] <= arr2[y]) {
                count++;
                max = Math.max(max, count);
                x++;
            } else {
                count--;
                y++;
            }
        }

        System.out.println(max);
    }
}