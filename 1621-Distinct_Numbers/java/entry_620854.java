import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class entry_620854 {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Reader reader = new Reader();
  long nbrs = reader.nextInt();
  // a hashset can only contain distinct numbers, so its just to add every distinct number to the set.
  HashSet<Integer> set = new HashSet<Integer>();
  for(int i=0;i<nbrs;i++) {
   set.add((reader.nextInt()));
  }
  System.out.println(set.size());

 }
 static class Reader 
 { 
  BufferedReader br; 
  StringTokenizer st; 

  public Reader() 
  { 
   br = new BufferedReader(new
     InputStreamReader(System.in)); 
  } 

  String next() 
  { 
   while (st == null || !st.hasMoreElements()) 
   { 
    try
    { 
     st = new StringTokenizer(br.readLine()); 
    } 
    catch (IOException e) 
    { 
     e.printStackTrace(); 
    } 
   } 
   return st.nextToken(); 
  } 

  int nextInt() 
  { 
   return Integer.parseInt(next()); 
  } 
 }
}