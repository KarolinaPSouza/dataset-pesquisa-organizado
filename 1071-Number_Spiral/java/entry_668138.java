import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class entry_668138 {
 public static void main(String[] args) throws RuntimeException, IOException {
  BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter out= new BufferedWriter(new OutputStreamWriter(System.out));
  int n= Integer.parseInt(br.readLine());
  String str[]=new String[(int)n];
  //Integer ar[]= new Integer[(int)n];
  int m=n;
  while(m!=0) {
   str[(n-m)]=br.readLine();
   //String tokens[]=str[(int)(n-m)].split(" ");
   //ar[(int)(n-m)]=Integer.valueOf(tokens[0])+Integer.valueOf(tokens[1]);
   m--;
  }
  br.close();
  long res=0;
  for(int i=1;i<=n;i++) {
   String t[]=str[i-1].split(" ");
   int row=Integer.parseInt(t[0]);
   int col=Integer.parseInt(t[1]);
   res=((long)((row>col)?row:col))*((long)((row>col)?row:col));
   if(row>col && row%2==0)
    res=res-col+1;
   else if(row>col && row%2!=0)
    res=res-(row-1)-(row-col);
   else if(col>row && col%2==0)
    res=res-(col-1)-(col-row);
   else
    res=res-row+1;
   out.write(Long.toString(res));
   out.write("\n");


  }

  out.flush();
 }
}