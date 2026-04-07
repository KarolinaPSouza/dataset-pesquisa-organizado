import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_8777579 {
 public static void main (String[] args) throws java.lang.Exception
 {

     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     TreeSet<Long> hs=new TreeSet<>();
     try {
         long n = Long.parseLong(br.readLine());
      long[] arr = new long[(int)n];

      String[] line = br.readLine().split(" ");
      for (int i = 0; i < n; i++) {
         arr[i] = Long.parseLong(line[i]);
         hs.add(arr[i]);
      }
 } 
 catch (IOException e) {
     e.getStackTrace();
    }
  System.out.println(hs.size());

 }
}