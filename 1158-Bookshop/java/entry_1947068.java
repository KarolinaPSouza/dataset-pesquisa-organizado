import java.util.*;
import java.io.*;
import java.lang.*;


public class entry_1947068 {
    public static int book_Shop(int x,int[] prices,int[] pages){
        int[] prev = new int[x + 1];
        int[] curr = new int[x + 1];

        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j <= x; j++){
                if(i == 0){
                    curr[j] = 0;
                }else if(j == 0){
                    curr[j] = 0;
                }else{
                    curr[j] = prev[j];
                    if(prices[i] <= j){
                        curr[j] = Math.max(curr[j], prev[j - prices[i]] + pages[i]);
                    }
                }
            }
            prev = curr;
            curr = new int[x + 1];
        }

        return prev[x];
    }
    public static void main(String args[]) throws java.lang.Exception{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String[] line = br.readLine().split(" ");
     int n = Integer.parseInt(line[0]);
     int x = Integer.parseInt(line[1]);

     int[] prices = new int[n + 1];
     int[] pages = new int[n + 1];

     String[] parts1 = br.readLine().split(" ");
     for(int i = 1; i <= n; i++){
         prices[i] = Integer.parseInt(parts1[i - 1]);
     }

     String[] parts2 = br.readLine().split(" ");
     for(int i = 1; i <= n; i++){
         pages[i] = Integer.parseInt(parts2[i - 1]);
     }

     System.out.println(book_Shop(x,prices,pages));
    }
}