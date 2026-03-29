import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;




public class entry_10904189 {

    public static  void main(String[] args) throws Exception{
        int n,m;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        //System.out.println(n+" "+m);
        char[][] walls = new char[n][m];
        for(int i = 0; i < n ; i++){
            walls[i] = reader.readLine().toCharArray();
        }
        boolean[][] vis = new boolean[n][m];

        class Pair{
            int a; int b;
            public  Pair(int a,int  b){
                this.a = a;
                this.b = b;
            }
        }

        int count = 0;
        for(int i = 0; i < n ; i++ )
            for(int j = 0; j < m; j++){
                if(vis[i][j] || walls[i][j]=='#')continue;
                //System.out.println(count);
                count++;
                Stack<Pair> dfs = new Stack<>();
                dfs.push(new Pair(i, j));
                while(!dfs.empty()) {
                    Pair top = dfs.peek();
                    dfs.pop();
                    int a = top.a;
                    int b = top.b;
                    if (a == n || b == m || a < 0 || b < 0) continue;
                    if (walls[a][b] == '#') continue;
                    if (vis[a][b]) continue;
                    vis[a][b] = true;
                    dfs.push(new Pair(a + 1, b));
                    dfs.push(new Pair(a - 1, b));
                    dfs.push(new Pair(a, b + 1));
                    dfs.push(new Pair(a, b - 1));

                }

            }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(Integer.toString(count));
        writer.flush();
        writer.close();
    }

}