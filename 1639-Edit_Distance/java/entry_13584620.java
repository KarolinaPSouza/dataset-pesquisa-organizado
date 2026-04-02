import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_13584620 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String a = nextLine();
        String b = nextLine();


        int[][] dp = new int[a.length()+1][b.length()+1];
//        dp[a.length()][any] = 0;
//        dp[any][b.length()] = 0;
        for (int i = 0; i <= b.length(); i++) {
            dp[a.length()][i] = b.length() -i;
        }

        for (int i = 0; i <=a.length() ; i++) {
            dp[i][b.length()] = a.length()-i;
        }

        for (int i = a.length()-1; i >=0; i--) {
            for (int j = b.length()-1; j >= 0; j--) {

                int replace = 1+dp[i+1][j+1];
                int insert = 1+dp[i][j+1];
                int delete = 1+dp[i+1][j];

                if(a.charAt(i) == b.charAt(j)) {
                    dp[i][j] =dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.min(replace,Math.min(insert,delete));
                }
            }
        }

        System.out.println(dp[0][0]);
    }



    static String next() throws IOException{
        while (st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static String nextLine() throws IOException{
        return br.readLine();
    }
}