import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class entry_9107686 {
    public static void solve(char [] [] arr, int i, int j){
        if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0 || arr[i][j] == '#'){
            return;
        }
        arr[i][j] = '#';
        solve(arr, i + 1, j);
        solve(arr, i - 1, j);
        solve(arr, i, j + 1);
        solve(arr, i, j - 1);
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char [] [] arr = new char[n][m];

        for (int i = 0; i < n; i++){
            String s = sc.nextLine();
            for (int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j);
            }
        }


        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (arr[i][j] == '.'){
                    count++;
                    solve(arr, i, j);
                }
            }
        }

        System.out.println(count);







    }
}




class FastScanner{  
    BufferedReader br;  
    StringTokenizer st;  

    public FastScanner(InputStream stream) {  
        br = new BufferedReader(new InputStreamReader(stream));  
    }  

    String next() {  
        while (st == null || !st.hasMoreTokens()) {  
            try {  
                st = new StringTokenizer(br.readLine());  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return st.nextToken();  
    }  

    int nextInt() {  
        return Integer.parseInt(next());  
    }  

    long nextLong() {  
        return Long.parseLong(next());  
    }  

    double nextDouble() {  
        return Double.parseDouble(next());  
    }  

    String nextLine() {  
        String str = "";  
        try {  
            str = br.readLine();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return str;  
    }  
} 