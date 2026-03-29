import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class entry_9925913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        int[] pages = new int[n];
        for(int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        int maxNumberOfPages = helper(n, x, price, pages);
        System.out.println(maxNumberOfPages);
    }

    public static int helper(int n, int x, int[] price, int[] pages) {
        int[] prevDP = new int[x+1];

        for ( int curr_book = 1; curr_book <= n; curr_book++ ) {
            int[] currDP = new int[x+1];
            int curr_book_price = price[curr_book-1];
            int curr_book_pages = pages[curr_book-1];
            for ( int curr_money = 0; curr_money <= x; curr_money++ ) {
                if ( curr_money < curr_book_price ) {
                    currDP[curr_money] = prevDP[curr_money];
                } else {
                    int pagesNotIncludingCurrentBook = prevDP[curr_money];
                    int pagesIncludingCurrentBook = ((curr_money - curr_book_price) >= 0) ? curr_book_pages + prevDP[curr_money-curr_book_price] : curr_book_pages;

                    currDP[curr_money] = Math.max(pagesNotIncludingCurrentBook, pagesIncludingCurrentBook);
                }
            }
            prevDP = currDP;
//            printDP(dp);
        }
        return prevDP[x];
    }

//    public static void printDP(int[][] dp) {
//        for (int i = 0; i < dp.length; i++) {
//            for(int j = 0; j < dp[i].length; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}