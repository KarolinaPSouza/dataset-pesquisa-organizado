import java.io.*;
import java.util.*;

public class entry_3536667 { 
}

class primeMultiples { 

 static long count=0;
 public void backTrack(int i,ArrayList<Long> nums, long pro, int c, long n)
 {
  if(i==nums.size())
  {
   if((c&1) == 0)
    count=count-(n/pro);
   else
    count=count+(n/pro);
   return; 
  }
  if(nums.get(i)<=n/pro)
   backTrack(i+1,nums,pro*nums.get(i),c+1,n);

  backTrack(i+1,nums,pro,c,n);
  return;
 }
 public static void main(String[] args) throws IOException
 {
  primeMultiples ob=new primeMultiples();
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

  String q=br.readLine();
  String[] a=q.split(" ");
  long num=Long.parseLong(a[0]);
  int k=Integer.parseInt(a[1]);
  String q1=br.readLine();
  String[] b=q1.split(" ");
  ArrayList<Long> arr=new ArrayList<>();
  for(int i=0;i<k;i++)
   arr.add(Long.parseLong(b[i]));

  ob.backTrack(0,arr,1,0,num);

  System.out.print(count+num); 
 }
}
