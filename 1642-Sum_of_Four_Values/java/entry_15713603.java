import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class entry_15713603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        ArrayList<int[]> vals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            vals.add(new int[] {Integer.parseInt(st.nextToken()), i+1});
        }

        vals.sort(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int partSum = vals.get(i)[0] + vals.get(j)[0];
                int l = j + 1, r = N - 1;
                while (l < r) {
                    long sum = partSum + vals.get(l)[0] + vals.get(r)[0];
                    if (sum == M) {
                        System.out.println(vals.get(i)[1] + " " + vals.get(j)[1] + " " + vals.get(l)[1] + " " + vals.get(r)[1]);
                        return;
                    }
                    else if (sum < M) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}