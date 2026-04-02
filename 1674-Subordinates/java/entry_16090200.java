import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Node{
  int val ;
  List<Node> al;
  Node(int val){
    this.val = val;
    al = new ArrayList<>();
  }
}
public class entry_16090200 {
  public static void main(String[] args)  throws  IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine().trim());
    Node mp[] = new Node[n+1];
    // HashMap<Integer , Node> mp = new HashMap<>();
    for(int i=0;i<n;i++){
      mp[i+1] = new Node(i+1);
      // mp.put(i+1,new Node(i+1));
    }
    // System.out.println(mp);
    String s[] = br.readLine().trim().split(" ");
    for(int i=0;i<s.length;i++){
      int val = Integer.parseInt(s[i]);
      Node  node = mp[val];
      node.al.add(mp[i+2]);     
    }
    int ans[] = new int[n+1];
    Stack<Node> stk1 = new Stack<>();
    Stack<Node> stk2 = new Stack<>();
    stk1.add(mp[1]);
    while(!stk1.isEmpty()){
      Node root = stk1.pop();
      stk2.push(root);
      for(Node val : root.al){
        stk1.push(val);
      }
    }
    while(!stk2.isEmpty()){
      Node cur =  stk2.pop();
      for (Node child : cur.al) {
          ans[cur.val] += ans[child.val] + 1;
      }
    }
    StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.print(sb.toString());
  }
}