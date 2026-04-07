import java.util.*;
import java.lang.*;
import java.io.*;
public class entry_5522100 {

 public static void main(String args[]){

 Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  HashSet<Integer> hs = new HashSet<>();
  for(int i=0;i<n;i++)hs.add(sc.nextInt());
  print(hs.size());

 }
 public static void print(int n){
  System.out.println(n);
 }
 public static void print(String msg){
  System.out.println(msg);
 }
}