import java.lang.*;
import java.io.*;
import java.util.*;
public class entry_3359311
{
 public static void main(String[] args)
 {
       Scanner scn=new Scanner(System.in);
       long n=scn.nextLong();
       int arr[]=new int [(int)n];
       int k=scn.nextInt();
       boolean flag=false;
       for(int i=0;i<n;i++)
       {
        arr[i]=scn.nextInt();
       }
       HashMap<Integer,Integer>map=new HashMap<>();
       for(int i=0;i<n;i++)
       {
        if(map.containsKey(k-arr[i]))
        {
            flag=true;
            int x=map.get(k-arr[i]);
            System.out.print((x+1)+" "+(i+1));
            break;
        }
        else
          map.put(arr[i],i);
       }
       if(flag==false){
        System.out.print("IMPOSSIBLE");
       }
 }
}
