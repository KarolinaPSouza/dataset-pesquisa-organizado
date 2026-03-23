//package introductoryProblems;
import java.io.IOException;
import java.util.*;
public class entry_7209602 {

// public static void main(String[] args) throws IOException{
//  Scanner sc = new Scanner(System.in);
//     int t = Integer.parseInt(sc.nextLine());
//     StringBuilder sb = new StringBuilder();
//     for (int i = 0; i < t; i++) {
//       String[] line = sc.nextLine().split(" ");
//       long[] a = Arrays.stream(line).mapToLong(Long::parseLong).toArray();
//       sb.append(algorithm(a));
//       if(i < t-1) {
//         sb.append(System.lineSeparator());
//       }
//     }
//     System.out.println(sb.toString());
//     sc.close();
//   }
//  public static long algorithm(long[] a) {
//      long res;
//      long x = a[1]; // column
//      long y = a[0]; // row
//      if(x >= y) {
//        if(x%2 == 0) {
//          x--;
//          res = (x*x + y);
//        } else {
//          res = x*x - y + 1;
//        }
//      } else {
//        if(y%2 == 0) {
//          res = y*y - x + 1;
//        } else {
//          y--;
//          res = y*y + x;
//        }
//      }
//      return res;
//    }
//
 public static void main(String[] args) throws IOException{
  // TODO Auto-generated method stub
  Scanner sc=new Scanner(System.in);
  int t=Integer.parseInt(sc.nextLine());
  StringBuilder res=new StringBuilder("");
  for(int i=0;i<t;i++) {
   String[] str=sc.nextLine().split(" ");

   long x=Long.parseLong(str[0]);
   long y=Long.parseLong(str[1]);
   if(x<y) {
    long ans;
    if(y%2!=0) {
     ans=(y*y)-x+1;
    }else {
     ans=((y-1)*(y-1))+x;
    }
    res.append(ans);
    res.append(System.lineSeparator());
//    System.out.println(ans);
   }else{
    long ans;
    if(x%2!=0) {
     ans=((x-1)*(x-1))+y;
    }else {
     ans=(x*x)-y+1;
    }
    res.append(ans);
    res.append(System.lineSeparator());
   }
  }
  System.out.print(res);
  sc.close();

 }

}