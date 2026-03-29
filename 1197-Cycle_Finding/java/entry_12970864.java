import java.util.*;
class Pair{
    int a;
    int b;
    long c;
     Pair(int d, int e, long f){
         a = d;
         b = e;
         c = f;
     }
}
public class entry_12970864 {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int m = sc.nextInt();
  // Making list
  List<Pair> list = new ArrayList<>();
  for(int i = 0; i < m; i++){
   list.add(new Pair(sc.nextInt(), sc.nextInt(), sc.nextLong()));
  }
  //Adding dummy Node
        for(int i = 1; i <= n; i++){
            list.add(new Pair(0, i, 0));
        }
  // logic

  long vis[] = new long[n + 1]; 
  Arrays.fill(vis, (long)(1e12));
  vis[0] = 0;
  int parent[] = new int[n + 1];
  for(int i = 0; i < n; i++){
   for(int j = 0; j < list.size(); j++){
    int src = list.get(j).a;
    int des = list.get(j).b;
    long weight = list.get(j).c; 
    long tempWeight = weight + vis[src];
    if((vis[src] != (long)(1e12) ) && vis[des] > tempWeight){
     vis[des] = tempWeight;
     parent[des] = src;
    }
   }
  }
  // Check cycle
  int index = -1;
  boolean isCycle = false;

        for(int j = 0; j < list.size(); j++){
    int src = list.get(j).a;
    int des = list.get(j).b;
    long weight = list.get(j).c; 
    long tempWeight = weight + vis[src];
    if((vis[src] != (long)(1e12) ) && vis[des] > tempWeight){
     isCycle = true;
     index = des;
     parent[des] = src;
     break;
    }
   }
   if(isCycle){
    System.out.println("YES");
    int v = index;
                for(int i = 0; i < n; i++){
                    v = parent[v];
                }
    Stack<Integer> st = new Stack<>();
    int u = v;
    do{
        st.push(u);
        u = parent[u];
    }while(u != v);
    st.push(u);
    while(!st.isEmpty()){
        System.out.print(st.pop()+" ");
    }

   }
   else{
    System.out.println("NO");
   }


 }
}