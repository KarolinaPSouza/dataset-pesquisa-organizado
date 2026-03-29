import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_10327454 {
 static int n,m;
 static char[][] map;
 static boolean[][] visited;

 static int[] dx = {-1,1,0,0};
 static int[] dy = {0,0,-1,1};

 public static void main (String[] args) throws IOException
 {
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter writer = new PrintWriter(System.out);

  String[] dimentions = reader.readLine().split(" ");
  n=Integer.parseInt(dimentions[0]);
  m=Integer.parseInt(dimentions[1]);

  map=new char[n][m];
  visited=new boolean[n][m];

  for(int i=0; i<n; i++){
      map[i]=reader.readLine().toCharArray();
  }
  int roomCount=0;
  for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
          if(map[i][j]=='.' && !visited[i][j]){
              roomCount++;
              iterativeDFS(i,j);
          }
      }
  }

  writer.println(roomCount);
  writer.flush();

  //reader.colse();
  //writer.colse();
 }
 static void iterativeDFS(int startX, int startY){
     Stack<int[]> stack = new Stack<>();
     stack.push(new int[]{startX,startY});
     while(!stack.isEmpty()){
         int[] position = stack.pop();
         int x = position[0];
         int y = position[1];
         if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || map[x][y]=='#'){
             continue;
         }
         visited[x][y]=true;
         for(int i=0; i<4; i++){
             int nx = x+dx[i];
             int ny = y+dy[i];
             stack.push(new int[]{nx,ny});
         }
     }
 }
}