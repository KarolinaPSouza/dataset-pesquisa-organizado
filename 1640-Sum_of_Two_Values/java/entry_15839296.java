import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_15839296
{
    public static void main(String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String[] t = br.readLine().split(" ");
        int n = Integer.parseInt(t[0]);
        int x = Integer.parseInt(t[1]);

        int arr[] = new int[n];
        Map < Integer, List < Integer >> mp = new HashMap < > ();
        t = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(t[i]);
            // Get or create the list for this key
            mp.putIfAbsent(arr[i], new ArrayList < > ());

            // Add the position (i+1) to the list
            mp.get(arr[i]).add(i + 1);
        }

        Arrays.sort(arr);

        int low = 0, high = n - 1;
        boolean flag = false;
        while (low < high) {
            if (arr[low] + arr[high] == x) {
                flag = true;
                List < Integer > list1 = mp.getOrDefault(arr[low], Collections.emptyList());
                List < Integer > list2 = mp.getOrDefault(arr[high], Collections.emptyList());
                out.print(list1.get(0) + " " + list2.get(list2.size() - 1));
                break;
            } else if (arr[low] + arr[high] < x) {
                low++;
            } else {
                high--;
            }
        }
        if (!flag) {
            out.print("IMPOSSIBLE");
        }
        out.flush();
        out.close();
    }
}
