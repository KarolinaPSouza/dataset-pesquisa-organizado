import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class entry_11008528 {
    static long dp[];
    public static int bs(int events[][],int x) {
        int s = 0;
        int e = events.length-1;
        int ans = events.length;
        while(s<=e) {
            int mid = (s+e)/2;
            if(events[mid][0]>=x) {
                ans = mid;
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return ans;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int arr[][] = new int[n][3];
        for(int i=0; i<n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            arr[i][0] = Integer.parseInt(tokenizer.nextToken());
            arr[i][1] = Integer.parseInt(tokenizer.nextToken());
            arr[i][2] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(arr,(a,b) -> a[0]-b[0]);
        int x[] = new int[n];
        dp = new long[n+1];
        for(int i=0; i<arr.length; i++) {
            int end = arr[i][1];
            x[i] = bs(arr,end+1);
        }
        for(int i=arr.length-1; i>=0; i--) {
            dp[i] = Math.max((long)arr[i][2]+dp[x[i]],dp[i+1]);
        }
        System.out.println(dp[0]);
    }
}