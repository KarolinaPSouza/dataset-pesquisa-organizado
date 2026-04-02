import java.util.*;
import java.io.*;
public class entry_5316916 {

 public static void main(String[] args) throws Exception {
  // TODO Auto-generated method stub
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  int n=Integer.parseInt(bf.readLine());

  int[] ar=Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

  long maxans=ar[0];
  long tot=ar[0];
  for(int i=1;i<ar.length;i++) {
   if(tot<0) {
    tot=(long)ar[i];
    maxans=Math.max(maxans,tot);
   }else {
    tot+=(long)ar[i];
    maxans=Math.max(maxans,tot);
   }
  }

  System.out.println(maxans);


 }

}