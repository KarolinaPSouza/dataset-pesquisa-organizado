import java.io.*;
import java.util.*;

public class entry_14967864 {
 public static class Book{
  public int pages;
  public int cost;

  public Book(int cost, int pages){
   this.cost = cost;
   this.pages = pages;
  }
 }
 public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken()); // rows
  int budget = Integer.parseInt(st.nextToken());

        int[][] grid = new int[2][n];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

            }
        }
  Book[] books = new Book[n + 1];
  for(int i = 1; i <= n; i++){
   books[i] = new Book(grid[0][i - 1], grid[1 ][i - 1]);
  }

  System.out.println(solve(books, budget, n));

    }

 public static int solve(Book[] books, int budget, int n){
  int[][] dp = new int[n + 1][budget + 1];

  Arrays.fill(dp[0], 0);


  for (int i = 1; i <= n; i++){
   Book current = books[i];
   for (int j = 0; j <= budget; j++){

    //can fit
    if(j >= current.cost){

     //should fit
     if(dp[i-1][j - current.cost] + current.pages > dp[i-1][j]){


      dp[i][j] = dp[i-1][j - current.cost] + current.pages;

     }
     else {
      dp[i][j] = dp[i-1][j];
     }

    }
    else{
     dp[i][j] = dp[i-1][j];
    }
   }
  }

  return dp[n][budget];

 }
}