import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;

public class entry_10503891 {

 public static void main(String[] args) throws Exception {
  new entry_10503891().run();
 }

 public void run() throws Exception {
  //Scanner f = new Scanner(new File(".dat"));
  Scanner f = new Scanner(System.in);
  int r = f.nextInt(), c = f.nextInt();
  f.nextLine();
  char[][] mat = new char[r][c];
  for(int x = 0; x < r; x++) {
   mat[x] = f.nextLine().toCharArray();
  }

  int count = 0;
  for(int x = 0; x < r; x++) {
   for(int y = 0; y < mat[x].length; y++) {
    Queue<Integer> go = new LinkedList<>();

    if(mat[x][y]=='.') {
     count++;
     go.add(x);
     go.add(y);
    }

    while(!go.isEmpty()) {
     int row = go.poll();
     int col = go.poll();
     if(row < 0 || col < 0 || row >= mat.length || col >= mat[0].length || mat[row][col] == '#') {
      continue;
     }
     mat[row][col] = '#';
     go.add(row + 1);
     go.add(col);

     go.add(row);
     go.add(col + 1);

     go.add(row - 1);
     go.add(col);

     go.add(row);
     go.add(col - 1);
    }
   }
  }
  System.out.println(count);


  f.close();
 }
}