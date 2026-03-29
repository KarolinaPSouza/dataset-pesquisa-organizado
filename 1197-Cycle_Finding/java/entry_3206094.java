import java.util.*;

class CycleFinding {

 static HashMap<Integer, List<int[]>> adj = new HashMap();

 public static void main(String[]  args) {

  Scanner sc = new Scanner(System.in);

  int n = sc.nextInt();
  int m = sc.nextInt();
  long[] dis = new long[n+1];
  int[] par = new int[n+1];

  Arrays.fill(par,-1);
  Arrays.fill(dis, (long)1e9);
  dis[1] = 0;

  for(int i=1;i<=n;i++) {
   adj.put(i, new ArrayList());
  }

  while(m-- > 0) {
   int a = sc.nextInt();
   int b = sc.nextInt();
   int c = sc.nextInt();
   adj.get(a).add(new int[] {b,c});
  }
  boolean change = false;
  int v = 0;

  for(int i=1;i<=n;i++) {
   change = false;
   v = 0;
   for(int j=1;j<=n;j++) {
    for(int[] next : adj.get(j)) {
     int b = next[0];
     long w = (long)next[1];
     if(dis[b] > dis[j]+w) {
      dis[b] = dis[j]+w;
      par[b] = j;
      change = true;
      v = b;
     }
    }
   }
  }

  String ans = (change == true) ? "YES" : "NO";
  System.out.println(ans);
  if(ans.equals("YES")) {

   // to get v which is guaranteed inside cycle
   for(int i=0;i<n;i++) {
    v = par[v];
   }

   int cur = v;
   Stack<Integer> s = new Stack<>();
   s.push(cur);
   cur = par[cur];
   //System.out.println(v + " " + cur);

   while(cur != v) {
    s.push(cur);
    cur = par[cur];
   // System.out.println(v + " kk " + cur);
   }
   s.push(cur);

   while(!s.isEmpty()) {
    System.out.print(s.pop() + " ");
   }
  }
 }
}