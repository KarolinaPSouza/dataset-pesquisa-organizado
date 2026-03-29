import java.util.*;

public class entry_12002947 {
 static char[][] grid;
 static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

 public static void main(String args[]) {
  Scanner myScanner = new Scanner(System.in);
  grid = new char[myScanner.nextInt()][myScanner.nextInt()];
  myScanner.nextLine();
  for (int i = 0; i < grid.length; i++) {
   grid[i] = myScanner.nextLine().toCharArray();
  }
  int count = 0;
  for (int i = 0; i < grid.length; i++) {
   for (int j = 0; j < grid[0].length; j++) {
    if (grid[i][j] == '.') {
     traverseRoom(i, j);
     count++;
    }
   }
  }
  System.out.println(count);
 }

 public static void traverseRoom(int x, int y) {
  Queue<int[]> q = new LinkedList<>();
  q.offer(new int[] {x, y});
  grid[x][y] = '#';

  while(!q.isEmpty()) {
   int[] cur = q.poll();
   x = cur[0];
   y = cur[1];

   for (int i = 0; i < directions.length; i++) {
    int newX = x + directions[i][0];
    int newY = y + directions[i][1];

    if (valid(newX,newY)) {
     grid[newX][newY] = '#';
     q.offer(new int[] {newX, newY});
    }
   }
  }
 }

 public static boolean valid(int x, int y) {
  return x < grid.length && x >= 0 &&
    y < grid[0].length && y >= 0 && grid[x][y] == '.';
 }


}