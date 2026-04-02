import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.* ;
public class entry_11502828{ 
 public static void MessageRoute(List<List<Integer>> adj , boolean vis[] , int start , int n ){
  Queue<Integer> q = new LinkedList<>();
  int parent[] = new int[n+1];
  parent[start] = -1;
  q.add(start);
  vis[start] = true;
  while(!q.isEmpty()){
   int size = q.size();
   for(int i = 0 ; i < size ; i++){
    int ele = q.poll();
    if(ele == n){
     ArrayList<Integer> al = new ArrayList<>();
     int x = ele ;
     al.add(x);
     while(parent[x] != -1){
      int el = parent[x];
      al.add(el);
      x = parent[x];
     }
     System.out.println(al.size());
     for(int ii = al.size() - 1 ; ii >= 0 ; ii--){
      System.out.print(al.get(ii)+ " ");
     }
     return ;
    }
    for(int child : adj.get(ele)){
     if(vis[child] == false){
      q.add(child);
      vis[child] = true;
      parent[child] = ele;
     }
    }
   }
  }
  System.out.println("IMPOSSIBLE");
 }
 public static void main(String args[]) throws IOException{ 
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st = new StringTokenizer("");
   st = new StringTokenizer(br.readLine());
   int n = Integer.parseInt(st.nextToken());
   int m = Integer.parseInt(st.nextToken());
   List<List<Integer>> adj = new ArrayList<>();
   for(int i = 0 ; i <= n ; i++){
    adj.add(new ArrayList<>());
   }
   for(int i = 0 ; i < m ; i++){
    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    adj.get(a).add(b);
    adj.get(b).add(a);
   }

   boolean vis[] = new boolean[n+1];
   MessageRoute(adj , vis , 1 , n );

 }
}
