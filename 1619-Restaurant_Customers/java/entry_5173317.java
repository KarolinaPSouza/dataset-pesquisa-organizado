import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
 public static void main (String[] args) throws java.lang.Exception
 {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
     int n=Integer.parseInt(br.readLine());
     HashSet<Integer>s=new HashSet<>();
     HashSet<Integer>e=new HashSet<>();
     int a[]=new int[2*n],index=0;
     StringTokenizer st;
     for(int i=0;i<n;i++){
         st=new StringTokenizer(br.readLine());
         int l=Integer.parseInt(st.nextToken());
         int r=Integer.parseInt(st.nextToken());
         a[index++]=l;
         a[index++]=r;
         s.add(l);
         e.add(r);
     }
     Arrays.sort(a);
     long max=0,cnt=0;
     for(int i=0;i<2*n;i++){
         if(s.contains(a[i])){
             cnt++;
         }
         if(e.contains(a[i])){
             cnt--;
         }
         max=Math.max(max,cnt);
     }
     System.out.println(max);
 }
}