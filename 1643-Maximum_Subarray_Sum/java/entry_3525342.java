import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_3525342 {
    private static class Result {
        public final long ans;
        public final long left;
        public final long right;
        public final long sum;

        public Result(long ans, long left, long right, long sum) {
            this.ans = ans;
            this.left = left;
            this.right = right;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] data = reader.readLine().split(" ");
        long[] arr = new long[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Long.parseLong(data[i]);
        }

        System.out.println(solve(arr, 0, n - 1).ans);
    }

    private static Result solve(long[] arr, int start, int end) {
        if (start == end)
            return new Result(arr[start], arr[start], arr[start], arr[start]);

        int mid = (start + end) / 2;
        Result a = solve(arr, start, mid);
        Result b = solve(arr, mid + 1, end);
        long ans = Math.max(a.ans, b.ans);
        ans = Math.max(ans, a.right + b.left);
        return new Result(ans, Math.max(a.left, a.sum + b.left), Math.max(b.right, a.right + b.sum), a.sum + b.sum);
    }
}