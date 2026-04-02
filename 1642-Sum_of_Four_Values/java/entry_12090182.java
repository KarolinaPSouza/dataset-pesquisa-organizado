import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
public class entry_12090182 {

    final static int MOD = (int)1e9 + 7;
    final static int[][] dir = { {1, 0}, {0, 1} };

    // ----predefined for taking inputs---------------------

    static int toInt(StringTokenizer st) 
    {
        return Integer.parseInt(st.nextToken());
    }

    static long toLong(StringTokenizer st) 
    {
        return Long.parseLong(st.nextToken());
    }

    static double toDouble(StringTokenizer st) 
    {
        return Double.parseDouble(st.nextToken());
    }

    static float toFloat(StringTokenizer st) 
    {
        return Float.parseFloat(st.nextToken());
    }

    static StringTokenizer tokens(BufferedReader in) throws IOException 
    {
        return new StringTokenizer(in.readLine().strip());
    }

    static int[] toIntArr(BufferedReader in, int n) throws IOException
    {
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        for (int i = 0; i < n; i++) arr[i] = toInt(st);
        return arr;
    }

    static long[] toLongArr(BufferedReader in, int n) throws IOException
    {
        long arr[] = new long[n];
        StringTokenizer st = new StringTokenizer(in.readLine().trim());
        for (int i = 0; i < n; i++) arr[i] = toLong(st);
        return arr;
    }

    // -----------------------------------------------------

    public static void main(String[] args) throws IOException 
    {

        // ----------for reading from stdin-----------------

        PrintWriter out = new PrintWriter(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // -------------------------------------------------

        // ----------for reading from a file----------------

        // in = new BufferedReader(new FileReader("test_input.txt"));
        // out = new PrintWriter("test_output.txt");

        // -------------------------------------------------

        StringTokenizer st;
        var result = new StringBuilder();

        // ----------------solution here--------------------

        int t = 1;
        // t = toInt(tokens(in));
        while (t-- > 0)
        {

            st = tokens(in);
            var n = toInt(st);
            var x = toInt(st);

            st = tokens(in);
            var arr = new int[n][2];
            for (var i = 0; i < n; i++) 
            {
                arr[i][0] = toInt(st);
                arr[i][1] = i+1;
            }

            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

            if (n < 4) result.append("IMPOSSIBLE");
            else
            {    
                var ans = solve(arr, x);
                if (ans[0] == -1) result.append("IMPOSSIBLE");
                else for (var y: ans) result.append(y).append(" ");
            }

        }

        // -------------------------------------------------

        in.close();
        out.print(result);
        out.close();

    }

    // -------------------functions here----------------

    private static int[] solve(int[][] arr, int x)
    {

        for (var i = 0; i < arr.length-3; i++)
        {

            if (i > 0 && arr[i][0] == arr[i-1][0]) continue;

            for (var j = i+1; j < arr.length-2; j++)
            {

                if (j > i+1 && arr[j][0] == arr[j-1][0]) continue;

                var target = x - arr[i][0] - arr[j][0];
                int l = j+1, r = arr.length-1;
                while (l < r)
                {
                    var curr = arr[l][0] + arr[r][0];
                    if (curr == target) return new int[]{arr[l][1], arr[r][1], arr[i][1], arr[j][1]};
                    else if (curr < target) l++;
                    else r--;
                }

            }
        }

        return new int[]{-1, -1, -1, -1};

    }

    // -------------------------------------------------


}