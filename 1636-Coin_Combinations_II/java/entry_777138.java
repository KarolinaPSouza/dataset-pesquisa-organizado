import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
public class entry_777138 {

 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int coins[]=new int[n];
        for(int i=0;i<n;i++)
         coins[i]=sc.nextInt();
        int arr[]=new int[x+1];
        arr[0]=1;
        for(int i=0;i<n;i++)
        {
         for(int j=1;j<=x;j++)
         {
          if(j-coins[i]>=0)
          {
           arr[j]=(arr[j]+arr[j-coins[i]])%1000000007;
          }
  //        System.out.print(arr[j]+" ");
         }
        }
        System.out.println(arr[x]);

 }

}