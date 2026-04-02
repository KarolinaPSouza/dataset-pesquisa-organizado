import java.io.*;
import java.util.*;

public class entry_3506797 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] values = new int[n];
        int[] trueValues = new int[n];

        //Initialize the values then sort
        for (int k = 0; k < n; k++) {
            int value = Integer.parseInt(st2.nextToken());
            values[k] = value;
            trueValues[k] = value;

        }


        Arrays.sort(values);

        int left = 0, right = n - 1;
        boolean isPossible = false;
        while (left < right) {

            if (values[left] + values[right] == x) {
                isPossible = true;
                break;
            }
            else if (values[left] + values[right] < x) {

                left++;
            }
            else {

                right--;
            }
        }

        if (isPossible) {
            int trueLeft = 0;
            int trueRight = 0;
            boolean leftChanged = false;
            boolean rightChanged = false;
            for (int k = 0; k < n; k++) {
                if (values[left] == trueValues[k] && !leftChanged) {

                    trueLeft = k;
                    leftChanged = true;
                }
                else if (values[right] == trueValues[k] && !rightChanged){

                    trueRight = k;
                    rightChanged = true;
                }

                if (trueLeft != trueRight && leftChanged && rightChanged) {

                    break;
                }

            }
            out.printf("%s %s", trueLeft + 1, trueRight + 1);
        }
        else {
            out.println("IMPOSSIBLE");
        }

        br.close();
        out.close();

    }
}