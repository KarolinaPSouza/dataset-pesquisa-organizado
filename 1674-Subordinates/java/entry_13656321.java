import java.util.*;
import java.io.*;

public class entry_13656321 {

 public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int n = Integer.parseInt(br.readLine());
  List<List<Integer>> adj = new ArrayList<>();
  int s[] = new int[n+1];
  for(int i = 0; i <= n; ++i) {
   adj.add(new ArrayList<>());
  }
  int[] par = new int[n-1];
  String[] input = br.readLine().split(" ");
  for(int i = 0; i < n - 1; ++i) {
   par[i] = Integer.parseInt(input[i]);
   adj.get(par[i]).add(i + 2);
  }
  Stack<int[]> st = new Stack<>();
  st.push(new int[]{1, 0});
  while(!st.isEmpty()) {
   int[] top = st.pop();
   if(top[1] == 0) {
    top[1] = 1;
    st.push(top);
    for(int child: adj.get(top[0])) {
     st.push(new int[]{child, 0});
    }
   } else {
    if(top[0] != 1)
     s[par[top[0]-2]] += 1 + s[top[0]];
   }
  }
  StringBuilder ans = new StringBuilder();
  for(int i = 1; i <= n; ++i) {
   ans.append(s[i] + " ");
  }
  System.out.println(ans);
 }
}