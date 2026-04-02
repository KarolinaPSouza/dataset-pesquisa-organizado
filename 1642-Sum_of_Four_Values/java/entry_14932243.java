/*
 * * * * * * * * * 
 * Author: jroy  *
 * * * * * * * * *
 */
// import java.io.*;
// import java.util.*;

// public class entry_14932243 {
//     public static void main(String[] args)throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         // Scanner s = new Scanner(System.in);
//         StringBuilder sb = new StringBuilder();
//         // PrintWriter pw = new PrintWriter(System.out);
//         // int t = s.nextInt();
//         // while (t-- > 0) {

//         // }
//         int n = Integer.parseInt(st.nextToken());
//         long x = Long.parseLong(st.nextToken());

//         long[][] a = new long[n][2];
//         st = new StringTokenizer(br.readLine());
//         for(int i = 0; i < n; i++){
//             a[i][0] = Long.parseLong(st.nextToken()); // value
//             a[i][1] = i + 1; // original index
//         }

//         Arrays.sort(a, Comparator.comparingLong(o -> o[0]));

//         boolean found = false;

//         for(int i = 0; i < n && !found; i++){
//             for(int j = i + 1; j < n && !found; j++){
//                 int k = j + 1;
//                 int l = n - 1;
//                 while(k < l){
//                     long sum = a[i][0] + a[j][0] + a[k][0] + a[l][0];
//                     if(sum == x){
//                         sb.append(a[i][1]).append(" ")
//                           .append(a[j][1]).append(" ")
//                           .append(a[k][1]).append(" ")
//                           .append(a[l][1]);
//                         found = true;
//                         break;
//                     } else if(sum < x){
//                         k++;
//                     } else {
//                         l--;
//                     }
//                 }
//             }
//         }

//         if(!found) sb.append("IMPOSSIBLE");
//         // pw.flush();
//         // pw.close();
//         System.out.print(sb);
//         // s.close();
//     }
// }
import java.io.*;
import java.util.*;

public class entry_14932243 {
    static class Pair {
        int first, second;
        Pair(int f, int s) {
            first = f;
            second = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // Map from pair-sum to the pair of indices that make it
        Map<Long, Pair> map = new HashMap<>();
        boolean found = false;
        int[] result = new int[4];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long need = x - (arr[i] + arr[j]);
                if (map.containsKey(need)) {
                    Pair p = map.get(need);
                    // ensure all indices are distinct
                    if (p.first != i && p.second != i && p.first != j && p.second != j) {
                        result[0] = p.first + 1;
                        result[1] = p.second + 1;
                        result[2] = i + 1;
                        result[3] = j + 1;
                        found = true;
                        break;
                    }
                }
            }
            if (found) break;

            // only store pairs with smaller index first to avoid reuse
            for (int k = 0; k < i; k++) {
                long sum = arr[i] + arr[k];
                map.putIfAbsent(sum, new Pair(k, i));
            }
        }

        if (!found)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
    }
}