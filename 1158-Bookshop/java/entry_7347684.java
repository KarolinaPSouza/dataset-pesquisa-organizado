import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;


class Main{


    private static int MOD = 1000000007;

    public static void main(String args[]){
        PrintWriter write = new PrintWriter(System.out);
        FastReader read = new FastReader();

        int n, inHand;
        n = read.nextInt(); 
        inHand = read.nextInt(); 
        int[] prices = new int[n];
        int[] pages = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = read.nextInt();
        }

        for(int i = 0; i < n; i++){
            pages[i] = read.nextInt();
        }

        int[][] dp = new int[n + 1][inHand + 1];

        for(int book = 1; book <= n; book++){
             for(int value = 1; value <= inHand; value++ ){
                if(value >= prices[book - 1]){
                    dp[book][value] = Math.max(dp[book - 1][value], dp[book - 1][value - prices[book - 1]] + pages[book - 1]);
                }
                else{
                    dp[book][value] = dp[book - 1][value];
                }
            }
        }

        write.println(dp[n][inHand]);
        write.flush();
    }

    // private static int solve(int n, int inHand){
    //     int[] prices = new int[n];
    //     int[] pages = new int[n];
    //     for(int i = 0; i < n; i++){
    //         prices[i] = read.nextInt();
    //     }

    //     for(int i = 0; i < n; i++){
    //         pages[i] = read.nextInt();
    //     }

    //     int[][] dp = new int[n + 1][inHand + 1];

    //     for(int book = 1; book <= n; book++){
    //          for(int value = 1; value <= inHand; value++ ){
    //             if(value >= prices[book - 1]){
    //                 dp[book][value] = Math.max(dp[book - 1][value], dp[book - 1][value - prices[book - 1]] + pages[book - 1]);
    //             }
    //             else{
    //                 dp[book][value] = dp[book - 1][value];
    //             }
    //         }
    //     }

    //     return dp[n][inHand];
    // }

    // private static void printArray(int[] arr){
    //     int ncols = arr.length;    
    //     for(int col = 0; col < ncols; col++){
    //         out.print(arr[col] + "\t");
    //     }
    //     out.print("\n");
    // }

    // private static void print2DArray(int[][] arr){
    //     int nrows = arr.length;
    //     int ncols = arr[0].length;
    //     for(int row = 0; row < nrows; row++){
    //         for(int col = 0; col < ncols; col++){
    //             out.print(arr[row][col] + "\t");
    //         }
    //         out.print("\n");
    //     }

    // }

    static class FastReader { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next() {
   while (!st.hasMoreTokens())
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  int[] readArray(int n) {
   int[] a = new int[n];
   for (int i = 0; i < n; i++)
    a[i] = nextInt();
   return a;
  }

  long nextLong() {
   return Long.parseLong(next());
  }
    } 
}