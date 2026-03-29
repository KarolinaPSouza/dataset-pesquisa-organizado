import java.util.*;
public class entry_13456835 {
 static class Node{
  long x;
  long y;
  long wt;
  Node(long x,long y,long wt){
   this.x = x;
   this.y = y;
   this.wt= wt;
  }
 }
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  long n = sc.nextLong();
  long e = sc.nextLong();
  ArrayList<Node> adj = new ArrayList<>();
  for(int i=1;i<=e;i++) {
   long x = sc.nextLong();
   long y = sc.nextLong();
   long wt= sc.nextLong();
   adj.add(new Node(x,y,wt));
  }

  // Adding Dummy Node and connecting to all the Nodes
  for(int i=1;i<=n;i++) {
   adj.add(new Node(0L,i,0L));
  }

  long[] parent  = new long[(int)n+1];
  long[] distance = new long[(int)n+1];
  Arrays.fill(distance, Long.MAX_VALUE);
  distance[0] = 0L;
  // Relaxing N times
  for(int i=0;i<=n;i++) {
   for(int j=0;j<adj.size();j++) {
    Node node = adj.get(j);
    long x = node.x;
    long y = node.y;
    long wt = node.wt;

    if(distance[(int)x] != Long.MAX_VALUE && distance[(int)y] > distance[(int)x]+wt) {
     distance[(int)y] = distance[(int)x]+wt;
     parent[(int)y]   = x;
    }
   }
  }

  boolean isCycle = false;
  long lastUpdated = -1;
  //Relaxing One more time to detect the cycle 
  for(int j=0;j<adj.size();j++) {
   Node node = adj.get(j);
   long x = node.x;
   long y = node.y;
   long wt = node.wt;

   if(distance[(int)x] != Long.MAX_VALUE && distance[(int)y] > distance[(int)x]+wt) {
    distance[(int)y] = distance[(int)x]+wt;
    parent[(int)y]   = x;
    isCycle = true;
    lastUpdated  = y;
   }
  }

  if(isCycle) {
   System.out.println("YES");
   long v = lastUpdated;
   for(int i=0;i<=n;i++) {
    v = parent[(int)v];
   }

   long start = v;
   ArrayList<Long> ans = new ArrayList<>();
   ans.add(start);
   v = parent[(int)start];

   while(v != start) {
    ans.add(v);
    v = parent[(int)v];
   }
   ans.add(start); // To close the cycle

   Collections.reverse(ans);
   for(long i : ans) {
    System.out.print(i + " ");
   }
   System.out.println();
  }else {
   System.out.println("NO");
  }
 }

}