
import java.util.Scanner;

public class entry_6380850 {
 static Scanner scanner=new Scanner(System.in);
 static StringBuilder builder=new StringBuilder();
 static int n,m;
 static G[] g=new G[100005];

 static class Node{
  int d;
  Node link;
  public Node(int d) {
   super();
   this.d = d;
  }

 }

 static class G{
  Node node;
  void add(Node node) {
   node.link=this.node;
   this.node=node;
  }
 }

 static class Queue{
  Node front,rear;
  int n;
  void push(Node node) {
   n++;
   if(front==null) {
    front=rear=node;
    return;
   }
   rear.link=node;
   rear=node;
  }
  void pop() {
   if(front==null)
    return;
   n--;
   front=front.link;
   if(front==null)
    rear=null;
  }
 }

 static int ti(String s) {
  return Integer.parseInt(s);
 }

 static void exec() {
  //n thanh pho 
  //m con duong
  //tim con duong min tu 1->n
  n=ti(scanner.next());
  m=ti(scanner.next());

  for(int u=1;u<=n;++u)
   g[u]=new G();

  for(int i=0;i<m;++i) {
   int u=ti(scanner.next()),v=ti(scanner.next());
   g[u].add(new Node(v));
   g[v].add(new Node(u));
  }

  Queue queue=new Queue();
  boolean[] P=new boolean[n+1];
  int pre[]=new int[n+1];
  pre[1]=-1;
  P[1]=true;
  queue.push(new Node(1));


  while(queue.n>0) {
   int u=queue.front.d;
   queue.pop();


   if(u==n) {
    int p=u,cnt=0;
    int[] tmp=new int[n+1];

    while(p!=-1) {
     tmp[cnt++]=p;
     p=pre[p];
    }

    for(int i=cnt-1;i>=0;--i)
     builder.append(tmp[i]).append(' ');

    System.out.printf("%d\n%s",cnt,builder);

    return;
   }

   Node node=g[u].node;
   while(node!=null) {
    if(!P[node.d]) {
     P[node.d]=true;
     pre[node.d]=u;
     queue.push(new Node(node.d));
    }
    node=node.link;
   }
  }

  System.out.println("IMPOSSIBLE");
 }

 public static void main(String[] args) {
//  int t=Integer.parseInt(scanner.nextLine());
//  
//  while(t-->0)
   exec();

//  System.out.print(builder);

  scanner.close();
 }
}