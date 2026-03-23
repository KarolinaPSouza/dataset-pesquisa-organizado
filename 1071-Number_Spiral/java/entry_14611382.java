//Number Spiral
/*
1 read n + pairs
2 for each pair x y
  2.1 start = max(x,y)-1)**2 + 1,  candidates = [start, start + 2*max-1]
  2.2 iterate = min or  2*max -1 - min
        max=even  r>col  order
      +         +       e
      +         -       b
      -         +       b
      -         -       e
*/

import java.util.*;
import java.io.*;

public class entry_14611382 {

 static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

 public static void main(String[] args) throws Exception {

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */
     int n = Integer.parseInt(reader.readLine());
  List<String> input = new ArrayList<>();
  for (int i = 0; i < n; i++) {
      input.add(reader.readLine());    
  }
        for (int i = 0; i < n; i++) {
            String s = input.get(i);   
   String[] tokens = s.split("\\s");
         int x = Integer.valueOf(tokens[0]);
   int y = Integer.valueOf(tokens[1]);
   printVal(x,y);
   if (i != n-1){
    writer.write("\n");
   }
  }

  reader.close();
  writer.close();
 } 

 static void  printVal(int x, int y) throws Exception{
  long max = Math.max(x,y);
  long min = Math.min(x,y);
     long start = (max-1)*(max-1);
  long dist = 0;
  if ( max%2 == 0){
      if (x > y){
       dist = 2*max - min; 
            } else {
                dist = min;
            }    
  } else {
   if (x > y){
    dist = min; 
            } else {
    dist = 2*max - min; 
            }   
        }  

  writer.write(String.valueOf(start + dist));
 } 
}

