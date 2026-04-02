import java.util.*;
import java.io.*;
public class entry_1726827 {

 public static void main(String[] args) throws IOException {
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(in.readLine());
  int n = Integer.parseInt(st.nextToken());
  int x = Integer.parseInt(st.nextToken());
  ArrayList<Integer> list = new ArrayList<Integer>();
  st = new StringTokenizer(in.readLine());
  for(int i = 0; i < n; i++) {
   list.add(Integer.parseInt(st.nextToken()));
  }
  ArrayList<Integer> listCopy = (ArrayList<Integer>) list.clone();
  Collections.sort(list);
  int upper = n-1;
  int lower = 0;
  int uVal = list.get(upper);
  int lVal = list.get(lower);
  while(uVal+lVal!=x&&upper>lower) {
   if(uVal+lVal>x) {
    upper--;
    uVal = list.get(upper);
   }else {
    lower++;
    lVal = list.get(lower);
   }
  }
  //System.out.println(upper+" "+lower);
  if(upper>lower&&uVal+lVal==x) {
   int highIndex = Math.max(listCopy.indexOf(lVal)+1, 1+listCopy.lastIndexOf(uVal));
   int lowIndex = Math.min(listCopy.indexOf(lVal)+1, 1+listCopy.lastIndexOf(uVal));
   System.out.println(lowIndex+" "+highIndex);
  }else {
   System.out.println("IMPOSSIBLE");
  }
 }

}