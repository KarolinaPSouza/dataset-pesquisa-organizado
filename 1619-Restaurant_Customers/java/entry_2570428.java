import java.io.*;
import java.util.*;

public class entry_2570428 {
 static class User implements Comparable<User> {
  int arrival = 0;
  int leaving = 0;
  User(int arrival, int leaving){
   this.arrival = arrival;
   this.leaving = leaving;
  }

  @Override
  public int compareTo(User o) {
   return this.arrival - o.arrival;
  }
 }

 static class FastReader{
  BufferedReader br;
  StringTokenizer st;

  public FastReader(){
   br = new BufferedReader(new
     InputStreamReader(System.in));
  }

  String next(){
   while (st == null || !st.hasMoreElements()){
    try{
     st = new StringTokenizer(br.readLine());
    }
    catch (IOException  e){
     e.printStackTrace();
    }
   }
   return st.nextToken();
  }

  int nextInt(){
   return Integer.parseInt(next());
  }

  long nextLong(){
   return Long.parseLong(next());
  }

  double nextDouble(){
   return Double.parseDouble(next());
  }

  String nextLine(){
   String str = "";
   try{
    str = br.readLine();
   }
   catch (IOException e){
    e.printStackTrace();
   }
   return str;
  }
 }


 public static void main(String[] args){
  FastReader sc = new FastReader();
  int t = sc.nextInt();
  ArrayList<User> arr = new ArrayList<>();
  for(int i = 0; i< t; i++) {
   int x = sc.nextInt();
   User user = new User(x, 1);
   arr.add(user);

   int y = sc.nextInt();
   User user2 = new User(y, -1);
   arr.add(user2);
  }
  Collections.sort(arr);
  int cnt = 0;
  int max = 0;
  for(int i = 0; i < arr.size(); i++) {
   User x =  arr.get(i);
   cnt += x.leaving;
   if(cnt > max) max = cnt;
  }
  System.out.println(max);
 }
}