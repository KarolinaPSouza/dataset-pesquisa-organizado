import java.util.*;
import java.io.*;

public class entry_14437537{
    public static void main(String args[]) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int n=Integer.parseInt(br.readLine());
  int arr[]=new int[n];
  if (n > 1) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }
  int ans[]=new int[n];
  List<List<Integer>> adj=new ArrayList<>();
  for(int i=0;i<n;i++) adj.add(new ArrayList<>());
  for(int i=1;i<n;i++){
   adj.get(arr[i]-1).add(i);
  }
  Stack<Integer> st=new Stack<>();
  st.push(0);
  List<Integer> order=new ArrayList<>();
  while(!st.isEmpty()){
   int x=st.pop();
   order.add(x);
   for(int i:adj.get(x)) st.push(i);
  }
  for(int i=order.size()-1;i>=0;i--){
   int node=order.get(i);
   for(int x:adj.get(node)){
    ans[node]+=1+ans[x];
   }
  }
  StringBuilder sb = new StringBuilder();
        for (int x : ans) sb.append(x).append(" ");
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out.println(sb.toString().trim());
        out.flush();
 }
}
