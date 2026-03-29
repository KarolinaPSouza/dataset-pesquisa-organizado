import java.util.*;

class file1{
 public static boolean[][] visited;
 public static char[][] grid;
 public static int n,m;
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  n = sc.nextInt();
  m = sc.nextInt();

  visited = new boolean[n][m];
  grid = new char[n][m];

  for(int i = 0;i<n;i++) {
   String s = sc.next();
   grid[i] = s.toCharArray();
  }

  int ct = 0;

  for(int i = 0;i<n;i++) {
   for(int j = 0;j<m;j++) {
    if(!visited[i][j] && grid[i][j]=='.') {
     dfs(i,j);
     ct++;
    }
   }
  }

  System.out.println(ct);
 }
 public static void dfs(int i,int j) {
  if(i<0 || i>=n || j<0 || j>=m ||visited[i][j] || grid[i][j]=='#') return;

  visited[i][j] = true;

  dfs(i,j+1); // right
  dfs(i,j-1); // left
  dfs(i-1,j); // up
  dfs(i+1,j); // down;
 }
}