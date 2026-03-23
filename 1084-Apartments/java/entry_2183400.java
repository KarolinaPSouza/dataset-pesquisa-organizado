import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class Apartments{
 public static void main(String args[]) throws IOException{
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 String[] i1=br.readLine().split(" ");
 String[] i2=br.readLine().split(" ");
 String[] i3=br.readLine().split(" ");

 int n=Integer.parseInt(i1[0]);
 int m=Integer.parseInt(i1[1]);
 int k=Integer.parseInt(i1[2]);
 Integer[] ap=new Integer[n];
 int count=0;
 int[] apSize=new int[m];

 for(int i=0;i<n;i++){
  ap[i]=Integer.parseInt(i2[i]);
 }

 for(int i=0;i<m;i++){
  apSize[i]=Integer.parseInt(i3[i]);
 }
 Arrays.sort(ap);
 Arrays.sort(apSize);
 int j=0;
 int i=0;
 while(i<n && j<m){
  if(Math.abs(ap[i]-apSize[j])<=k)
  {
  count++;
  i++;
  j++;
  }

  else if(ap[i]-apSize[j]>k)
   j++;
  else
   i++;
 }
 //System.out.println(apSize.size());
 System.out.print(count);
 } 

}