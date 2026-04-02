import java.util.*;
import java.io.*;
public class entry_5775177 {
 public static void main(String[] args) throws IOException{
  BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
  String[] str = in.readLine().split(" ");
  int n = Integer.parseInt(str[0]);
  int x = Integer.parseInt(str[1]);
  //System.out.println(n + " " + x);
  HashMap<Integer, Integer> list = new HashMap<>();
  ArrayList<Integer> list2 = new ArrayList<>();

  String[] str2 = in.readLine().split(" ");


  for(int i = 0 ; i < n;i++) {
   list2.add(Integer.parseInt(str2[i]));
  }
  boolean bad = true;

  for(int i = 0 ; i < list2.size();i++) {
   int a =list2.get(i);


   if(list.containsKey(x-a)) {
    System.out.print(i+1+" ");
    System.out.print(list.get(x-a)+1);
    bad=false;
    break;

   }else {
    list.put(a, i);
   }
  }
  if(bad) {
   System.out.print("IMPOSSIBLE");
  }
 }
}