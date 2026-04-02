import java.util.*;
import java.io.*;
public class entry_14150216 {
    public static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String a=br.readLine();
        String b=br.readLine();

        int n=a.length();
        int m=b.length();

        dp=new int[n+1][m+1];
        for (int[] i : dp) Arrays.fill(i,-1);

        int val=rec(n,m,a,b);
        System.out.println(val);

    }

    public static int rec(int index1,int index2, String a,String b) {
        if (index1 == 0) return index2;
        if (index2 == 0) return index1;

        if (dp[index1][index2] != -1) return dp[index1][index2];

        if (a.charAt(index1-1) == b.charAt(index2-1)) {
            return dp[index1][index2]=rec(index1-1,index2-1,a,b);
        }
        int insert=rec(index1-1,index2,a,b);
        int delete=rec(index1,index2-1,a,b);
        int replace=rec(index1-1,index2-1,a,b);

        return dp[index1][index2]=1+Math.min(insert,Math.min(replace,delete));
    }
}