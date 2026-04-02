import java.util.*;
import java.io.*;
public class entry_11670614 {
    public static void main(String args[]) throws Exception {
        //Scanner input = new Scanner(System.in);
        //int n  = input.nextInt();
        //int x = input.nextInt();
        //long[] nums = new long[n];
        //long[] current = new long[n];
        //for (int i = 0; i < n; i++) {
            //nums[i] = input.nextLong();
            //current[i] = nums[i];
        //}
        //input.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  //PrintWriter pw = new PrintWriter(System.out);
  StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  int x = Integer.parseInt(st.nextToken());
        long[] nums = new long[n];
        long[] current = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st1.nextToken());
            current[i] = nums[i];
        }
        Arrays.sort(current);

        int i = 0;
        int j = n-1;
        boolean found = false;
        while (i < j) {
            if (current[i] + current[j] > x) {
                j--;
            } else if (current[i] + current[j] < x) {
                i++;
            } else if (i != j && current[i] + current[j] == x) {
                found = true;
                break;
            }
        }

        if (found == false) {
            System.out.print("IMPOSSIBLE");
        } else {
            int first =  -1;
            int second = -1;
            for (int k = 0; k < n; k++) {
                if (first == -1 && nums[k] == current[i]) {
                    first = k+1;
                    System.out.print(first + " ");
                    continue;
                }
                if (second == -1 && nums[k] == current[j]) {
                    second = k+1;
                    System.out.print(second + " ");
                    continue;
                }
            }
            //System.out.println(first + " " + second);
            //pw.close();
        }
    }
}