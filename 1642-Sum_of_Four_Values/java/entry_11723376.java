// import java.io.*;
// import java.util.*;

// public class entry_11723376 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(reader.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int x = Integer.parseInt(st.nextToken());
//         List<int[]> arr = new ArrayList<>();
//         st = new StringTokenizer(reader.readLine());
//         for (int i = 0; i < n; i++) {
//             int value = Integer.parseInt(st.nextToken());
//             arr.add(new int[] { value, i + 1 });
//         }
//         arr.sort(Comparator.comparingInt(a -> a[0]));
//         for (int ptr1 = 0; ptr1 < n - 3; ptr1++) {
//             for (int ptr2 = ptr1 + 1; ptr2 < n - 2; ptr2++) {
//                 int ptr3 = ptr2 + 1;
//                 int ptr4 = n - 1;
//                 while (ptr3 < ptr4) {
//                     int currentSum = arr.get(ptr1)[0] + arr.get(ptr2)[0] + arr.get(ptr3)[0] + arr.get(ptr4)[0];

//                     if (currentSum == x) {
//                         System.out.println(arr.get(ptr1)[1] + " " + arr.get(ptr2)[1] + " " + arr.get(ptr3)[1] + " " + arr.get(ptr4)[1]);
//                         return;
//                     }
//                     else if (currentSum > x) {
//                         ptr4--;
//                     } else {
//                         ptr3++;
//                     }
//                 }
//             }
//         }
//         System.out.println("IMPOSSIBLE");
//     }
// }

import java.io.*;
import java.util.*;

public class entry_11723376 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<int[]> arr = new ArrayList<>();
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr.add(new int[] { value, i + 1 });
        }
        arr.sort(Comparator.comparingInt(a -> a[0]));
        Map<Integer, List<int[]>> sumMap = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr.get(i)[0] + arr.get(j)[0];
                if (sumMap.containsKey(x - sum)) {
                    for (int[] pair : sumMap.get(x - sum)) {
                        if (pair[1] < arr.get(i)[1] && pair[1] < arr.get(j)[1]) {
                            System.out.println(pair[0] + " " + pair[1] + " " + arr.get(i)[1] + " " + arr.get(j)[1]);
                            return;
                        }
                    }
                }
                sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(new int[]{arr.get(i)[1], arr.get(j)[1]});
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}