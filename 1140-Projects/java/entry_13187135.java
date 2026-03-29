import java.util.*;
import java.io.*;

public class entry_13187135 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        int[][] projects = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            projects[i][0] = Integer.parseInt(st.nextToken()); // start
            projects[i][1] = Integer.parseInt(st.nextToken()); // end
            projects[i][2] = Integer.parseInt(st.nextToken()); // reward
        }

        Arrays.sort(projects, (b,c) -> b[1] - c[1]);

        long dp[] = new long[n+1];

        for(int i = 0; i < n; i++){
            int currEnd = projects[i][1];
            int reward = projects[i][2];

            int start = projects[i][0];
            int s = 0;
            int e = i - 1;

            int ind = -1;
            while(s <= e){

                int mid = s + (e-s)/2;
                if(projects[mid][1] < start){
                    ind = mid;
                    s = mid + 1;
                }
                else e = mid - 1;
            }

            dp[i+1] = Math.max(dp[i],dp[ind + 1]+reward);

        }

        pw.println(dp[n]);


        pw.flush();
    }
}