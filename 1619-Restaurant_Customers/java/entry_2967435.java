import java.util.*;
import java.io.*;

public class entry_2967435 {


 ModReader reader = new ModReader();
 ModWriter writer = new ModWriter();

 private class ModReader {
  BufferedReader br;
  StringTokenizer st;

  public ModReader() {
   br = new BufferedReader(new InputStreamReader(System.in));
  }

  String nextToken() throws Exception {
   while (st == null || !st.hasMoreElements()) {
   st = new StringTokenizer(br.readLine());

   }
   return st.nextToken();
  }

  int nextInt() throws Exception, Exception {
   return Integer.parseInt(nextToken());
  }

  long nextLong() throws Exception {
   return Long.parseLong(nextToken());
  }

  double nextDouble() throws Exception {
   return Double.parseDouble(nextToken());
  }

  String[] nextStringArray() throws Exception {
   return nextToken().split(" ");
  }

  int[] nextIntArray(int n) throws Exception {
   int[] result = new int[n];

   for(int i = 0 ; i < n; i++){
    result[i] = Integer.valueOf(nextToken());
   }
   return result;
  }
 }

 private class ModWriter {

  BufferedWriter out;

  public ModWriter() {
          out = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public void print(Object obj) throws Exception{
   out.write(obj.toString() + "");
  }

  public void println(Object obj) throws Exception {
   out.write(obj.toString() + "\n");
  }

  public void flush() throws Exception {
   out.flush();
  }

  public void close() throws Exception {
   out.close();
  }

 }

 private void print(Object obj){
  try {
   writer.print(obj);
  } catch(Exception ex){

  }
 }

 private void println(Object obj){
  try {
   writer.println(obj);
  } catch (Exception e) {
   //TODO: handle exception
  }
 }

 private class TempObj implements Comparable<TempObj>{
  int val;
  boolean flag;

  @Override
  public int compareTo(TempObj o) {
   return this.val - o.val;
  }
 } 

 public void solve() throws Exception {
  int n = reader.nextInt();
  List<TempObj> list = new ArrayList<>();

  for(int i = 0 ; i < n; i++){
   TempObj obj = new TempObj();
   obj.val = reader.nextInt();
   obj.flag = true;

   TempObj obj1 = new TempObj();
   obj1.val = reader.nextInt();
   obj1.flag = false;

   list.add(obj);
   list.add(obj1);
  }

  Collections.sort(list);

  int result = 0;
  int max = 0;

  for(TempObj obj : list){
   if(obj.flag){
    result++;
    if(max < result){
     max =result;
    }
   } else {
    result--;
   }
  }
  print(max);
     }

 public static void main(String[] args) throws Exception{
  entry_2967435 obj = new entry_2967435();
  obj.solve();
  obj.writer.close();
 }
}