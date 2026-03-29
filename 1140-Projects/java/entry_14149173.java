import java.io.*;
import java.util.*;
public class entry_14149173 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = fr.nextInt();
        int[][] arr = new int[n][3];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i][0] = fr.nextInt();
            arr[i][1] = fr.nextInt();
            arr[i][2] = fr.nextInt();
        }
        Arrays.sort(arr,(a,b) -> a[1] - b[1]);
        long max = 0;
        List<long[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long rewardTillNow = 0;
            int st = 0, end = list.size() - 1;
            while (st <= end) {
                int mid = st + (end - st) / 2;
                if (list.get(mid)[0] < arr[i][0]) st = mid + 1;
                else end = mid - 1;
            }
            if (!list.isEmpty()) {
                //valid answer then it would be on end
                // end = -1
                if (end != -1) rewardTillNow = Math.max(rewardTillNow,list.get(end)[1]);
            }
            long currReward = rewardTillNow + arr[i][2];
            max = Math.max(currReward,max);
            list.add(new long[]{arr[i][1],max});
        }
        out.println(max);
        out.close();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}