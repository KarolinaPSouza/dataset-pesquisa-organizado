import java.util.*;
public class entry_11258349 {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int m = sc.nextInt();
  int n = sc.nextInt();

  int[] dirx = {1,-1,0,0};
  int[] diry = {0,0,-1,1};

  int[][] graph = new int[m][n];
  boolean[][] visited = new boolean[m][n];
  for(int i=0; i<m; i++) {
   String nodes = sc.next();
   for(int j=0;j<n;j++){
       graph[i][j] = 0;
       if(nodes.charAt(j) == '#') graph[i][j] = 1;

   }
  }
  int ans = 0;

  Stack<Integer> stackX = new Stack<>();
  Stack<Integer> stackY = new Stack<>();
  for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
          if(graph[i][j] == 1) continue;
    if( visited[i][j] ) continue;

          stackX.push(i);
          stackY.push(j);
          while(!stackX.isEmpty()){
              int xx = stackX.pop();
              int yy = stackY.pop();
              visited[xx][yy] = true;
              for(int c=0;c<4;c++){
                  int x_ = xx+dirx[c], y_ = yy+diry[c];
                  if( x_ <0 || x_>=m || y_ < 0 || y_>=n) continue;
                  if(graph[x_][y_] == 1) continue;
                  if(visited[x_][y_]) continue;

                  stackX.push(x_);
      stackY.push(y_);
              }

          }
          ans++;
      }
  }
  System.out.println(ans);
 }
}