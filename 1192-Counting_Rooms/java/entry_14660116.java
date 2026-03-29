import java.util.*;
import java.io.*;

public class entry_14660116 {
    public static void main(String[] args){
        FastReader sc = new FastReader();
        PrintWriter o = new PrintWriter(System.out); // Fast outputs
        int a = sc.ni();
        int b = sc.ni();
        int ans = 0; 
        char[][]ch = new char[a][b];
        for(int i=0;i<a;i++){
         String st = sc.n();
         for(int j=0;j<st.length();j++){
          ch[i][j]= st.charAt(j);
         }
        }
        for(int i=0;i<a;i++)
         for(int j=0;j<b;j++){
          if(ch[i][j]=='.'){
           dfs(ch,i,j);
           ans++;
          }
         }

         o.println(ans);


                 o.flush(); // Make sure everything is printed
    }
    public static void dfs(char[][]ch, int i, int j){
     if(i<0 ||i>=ch.length||j<0 ||j>=ch[0].length||ch[i][j]=='#'){
      return;
     }
     ch[i][j]='#';
     dfs(ch,i+1,j);
     dfs(ch,i-1,j);
     dfs(ch,i,j+1);
     dfs(ch,i,j-1);
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String n() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int ni() {
            return Integer.parseInt(n());
        }

        long nl() {
            return Long.parseLong(n());
        }
    }}