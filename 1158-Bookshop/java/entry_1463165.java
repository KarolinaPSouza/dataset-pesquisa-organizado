import java.io.*;
import java.util.*;

class Solution {
    private static StreamTokenizer in;
    private static PrintWriter out;

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        in = new StreamTokenizer(new BufferedReader(new FileReader("src\\main\\resources\\test_input.txt")));
        out = new PrintWriter(System.out);
//        long l = System.currentTimeMillis();
        int n = nextInt();
        int x = nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = nextInt();
        }

        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            pages[i] = nextInt();
        }

        int[] dp = new int[x + 1];

        for (int i = 0; i < n; i++) {
            for (int j = x - prices[i]; j >= 0; j--) {
                dp[j + prices[i]] = Math.max(dp[j + prices[i]], dp[j] + pages[i]);
            }
        }


        int max = 0;
        for (int i = 0; i < x + 1; i++) {
            max = Math.max(max, dp[i]);
        }
        out.println(max);
        out.flush();
    }

    private static void calc(int[] dp, int price, int min, int[] prices, int[] pages) {
        if (min == prices.length) return;
        if (price >= dp.length) return;
        calc(dp, price, min + 1, prices, pages);
        if (price + prices[min] >= dp.length) return;
        if (dp[price] + pages[min] > dp[price + prices[min]]) {
            dp[price + prices[min]] = dp[price] + pages[min];
        }
        calc(dp, price + prices[min], min + 1, prices, pages);
    }

    private static void shuffle(int n, int[] a, Random rand) {
        int tmp;
        int next;
        for (int i = 0; i < n / 4; i++) {
            tmp = a[i];
            next = rand.nextInt(n);
            a[i] = a[next];
            a[next] = tmp;
        }
    }

}