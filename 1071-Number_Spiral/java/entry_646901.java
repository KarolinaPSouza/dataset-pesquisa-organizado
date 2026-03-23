import java.util.*;
import java.io.*;
import java.lang.Math;
public class entry_646901 {
 public static void main(String[] args) throws IOException {
  Scanner input = new Scanner(System.in);
  int N = input.nextInt();
  BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
  for (int i = 0;i < N; i++)
  {
   long num = 0;
   int which = 0;
   long row = input.nextLong();
   long col = input.nextLong();
   long max = Math.max(row, col);
   if (row > col)
   {
    which = 1;
   }
   if (col >= row)
   {
    which = 2;
   }
   int direc = (int) (max&1);
   if (which == 1)
   {
    if (direc == 0)
    {
     num = (long) max*max;
     num-=col;
     num++;
     log.write(Long.toString(num));
     log.newLine();
     continue;
    }
    if (direc == 1)
    {
     num = (long) (max-1) * (max-1);
     num += col;
     log.write(Long.toString(num));
     log.newLine();
     continue;
    }
   }
   else 
   {
    if (direc == 1)
    {
     num = (long) max*max;
     num-=row;
     num++;
     log.write(Long.toString(num));
     log.newLine();
     continue;
    }
    if (direc == 0)
    {
     num = (long)  (max-1) * (max-1);
     num += row;
     log.write(Long.toString(num));
     log.newLine();
     continue;
    }
   }  
  }
  log.flush();
 }
}