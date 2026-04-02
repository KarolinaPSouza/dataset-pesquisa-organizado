import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_13472733 {
    public static void sumOfTwoValues(int n, int x, int values[]) {
        int arr[][] = new int[n][2];
        for(int i=0; i<n; ++i) {
            arr[i][0] = values[i];
            arr[i][1] = i + 1;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int res[] = new int[2];
        int i = 0, j = n - 1;
        long targetSum = x, sum = 0;
        boolean isSolution = false;
        while(i < j) {
            int a = arr[i][0], b = arr[j][0];
            int aIdx = arr[i][1], bIdx = arr[j][1];
            sum = (long)a + (long)b;
            if(sum == targetSum) {
                res[0] = aIdx;
                res[1] = bIdx;
                isSolution = true;
                break;
            } else if(sum < targetSum) {
                ++i;
            } else {
                --j;
            }
        }

        if(!isSolution) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        System.out.println(res[0] + " " + res[1]);
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int values[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; ++i) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        sumOfTwoValues(n, x, values);
    }
}