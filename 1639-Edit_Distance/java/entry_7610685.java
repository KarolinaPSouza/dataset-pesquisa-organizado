import java.io.*;
import java.util.*;
public class entry_7610685 {   
    // main method  
    public static void main(String argvs[])  
    {  

        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        int n = word1.length();
        int m = word2.length();

        sc.close();
        /*
        System.out.println("numb=" + numb + " value=" + value );
        for (int i = 0; i<numb+1; i++)
            System.out.print(price[i] + " ");
        System.out.println("");
        for (int i = 0; i<numb+1; i++)
            System.out.print(page[i] + " ");       
        System.out.println("");
        */
        int ans = solve(n, m, word1, word2);
        System.out.println(ans);  

    }  

    static int solve(int n, int m, String x, String y) {
        if (n <= 0)
            return 0;
        if (m <= 0)
            return 0;        

        //char x[] = new char[n];
        //char y[] = new char[m];

        int [][] table = new int[n+1][m+1];
        for (int i = 0; i <= m; i++) 
             table[0][i] = i;
        for (int i = 0; i <= n; i++) 
             table[i][0] = i;


        for (int i = 1; i <= n; i++) {
            //System.out.println("i=" + i);
            for (int j = 1; j <= m; j++) { 
                int cost = 1;
                if (x.charAt(i-1) == y.charAt(j-1))
                    cost = 0;

                table[i][j] = Math.min(table[i][j-1]+1,
                                Math.min(table[i-1][j]+1, table[i-1][j-1]+ cost));
                //System.out.print("j=" + j + "-" + x.charAt(i-1) + y.charAt(j-1)+ "-" + table[i][j] + "  ");
            }
            System.out.println();
        }
        return table[n][m];

    }


}  