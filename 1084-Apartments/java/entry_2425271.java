import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class entry_2425271 {
 public static void main (String[] args) throws java.lang.Exception
 {
  BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
  String str[] = br.readLine().split(" ");
  int n = Integer.parseInt(str[0]);
  int m = Integer.parseInt(str[1]);
  int k = Integer.parseInt(str[2]);
  List<Integer> apli = new ArrayList<>(),aprt = new ArrayList<>();
  String str1[] = br.readLine().split(" ");
  String str2[] = br.readLine().split(" ");
  for(int i=0;i<n;i++)
  {
   apli.add(Integer.parseInt(str1[i]));
  }
  for(int i=0;i<m;i++)
  {
   aprt.add(Integer.parseInt(str2[i]));
  }
  System.out.println(getAlocatedApartment(n,m,k,apli,aprt));
 }
 static int getAlocatedApartment(int n, int m,int k,List<Integer> arr1,List<Integer> arr2)
 {
  // System.out.println(n+"  "+m+" "+k+" "+apli+" "+aprt);
  Collections.sort(arr1);
  Collections.sort(arr2);
  int p1=0,p2=0,ans=0;
  while(p1<arr1.size() && p2 <arr2.size())
  {
   if( Math.abs(arr1.get(p1) - arr2.get(p2))  <=k)
   {
    //System.out.println(arr1.get(p1)+" "+arr2.get(p2) +" "+k);
    p1++;
    p2++;
    ans++;

   }
   else
   {
    if(arr1.get(p1) - arr2.get(p2) >0 )
    {
     //System.out.println(arr1.get(p1)+" "+arr2.get(p2) +"  p2++ "+k);
     p2++;
    }
    else
    {
     //System.out.println(arr1.get(p1)+" "+arr2.get(p2) +" p1++ "+k);
     p1++;
    }
   }

  }


 return ans;
 }


}