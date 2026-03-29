import java.util.*;
import java.io.*;
public class entry_8431813 {

 static BufferedReader in;
 static StringTokenizer st;
 //static Scanner in;
 static int n, m, ans;
 static char a[][];
 static int dr[] = {0, 0, -1, 1};
 static int dc[] = {-1, 1, 0, 0};


 public static void main(String[] args) throws IOException {

  in = new BufferedReader(new InputStreamReader(System.in));
  //in = new Scanner(System.in);
  init();
  solve();
  in.close();
  // TODO Auto-generated method stub

 }
 static void init() throws IOException {
  st = new StringTokenizer(in.readLine());
  n = Integer.parseInt(st.nextToken());
  m = Integer.parseInt(st.nextToken());
  a = new char[n][];

  for(int i = 0; i < n; i++) {
   a[i] = in.readLine().toCharArray();
  }

 }
 static void solve() {
  ans = 0;
  for(int i = 0; i < n; i++) {
   for(int j = 0; j < m; j++) {
    if(a[i][j] == '.') {
     dfs(i, j);

     ans++;

    }
   }
  }
  System.out.println(ans);
 }



 static void dfs(int r, int c) { 
  if(r < 0 || r>=n || c < 0 || c >= m || a[r][c] == '#') return;
        a[r][c] = '#';

        dfs(r,c-1);
        dfs(r,c+1);
        dfs(r-1,c);
        dfs(r+1,c); 

 }

}