import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class entry_1142043 {
 public static long max(long[] a) {
  int n=a.length;
  long max_ends=0;
  long max_so=Integer.MIN_VALUE;
  for(int i=0;i<n;i++){
   max_ends=max_ends+a[i];
   if(max_so<max_ends) {
    max_so=max_ends;
   }
   if(max_ends<0) {
    max_ends=0;
   }

  }
  return max_so;
 }




 public static void solve(){
  try(Scanner in=new Scanner(System.in)){
   int n=in.nextInt();


   long [] a=new long[n];
   for(int i=0;i<n;i++) {
    a[i]=in.nextLong();

   }

   System.out.println(max(a));


  }


  }

 public static void main(String[] args) throws IOException {

  solve();


 }

}