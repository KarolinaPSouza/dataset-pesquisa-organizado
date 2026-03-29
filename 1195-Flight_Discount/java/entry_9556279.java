import java.io.*;
import java.util.*;

class FastIO extends PrintWriter {
    private InputStream stream;private byte[]buf=new byte[1<<16];
    private int curChar,numChars;public FastIO(){this(System.in,System.out);}
    public FastIO(InputStream i, OutputStream o){super(o);stream=i;}
    public FastIO(String i,String o)throws IOException {super(new FileWriter(o));stream=new FileInputStream(i);}
    private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return -1;}return buf[curChar++];}
    public String nextLine(){int c;do{c=nextByte();}while(c<='\n');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>'\n');return res.toString();}
    public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}
    public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public long nextLong(){int c;do{c=nextByte();}while(c<=' ');long sgn=1;if(c=='-'){sgn=-1;c=nextByte();}long res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public double nextDouble(){return Double.parseDouble(next());
    }

}
class Edge{

    int dest;
    int weight;
    public Edge(int dest,int weight){

        this.dest=dest;
        this.weight=weight;
    }
}
class Node implements Comparable<Node>{
    int vertex;
    long dist;
    int used;
    public Node(int vertex,long dist,int used){
        this.vertex=vertex;
        this.dist=dist;
        this.used=used;
    }
    @Override
    public int compareTo(Node n){
        return Long.compare(this.dist,n.dist);
    }
}


public class entry_9556279 {
    public static void main(String[] args) {
        FastIO sc = new FastIO();


        int n = sc.nextInt();
        int m = sc.nextInt();
//
        ArrayList<Edge> graph[]=new ArrayList[n];
        long dist[][] = new long[n][2];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int wt = sc.nextInt();
//            edges.add(new Edge(src, dest, wt));
            graph[src].add(new Edge(dest,wt));
//
        }
        for (int i = 1; i < n; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1]=Long.MAX_VALUE;
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        //0- unused
        //1- used
        //we wont use the vis wla thing here because mulitple times visit krna h
        //instead vis wle nodes ko condition check krke pehle hi remove kr denge
        pq.add(new Node(0,0,0));
        while(!pq.isEmpty()){
            Node curr=pq.remove();
            if(dist[curr.vertex][curr.used]< curr.dist){
                continue;
            }
            for(int i=0;i<graph[curr.vertex].size();i++){
                //agr ticket not used h to use it rn
                Edge neig=graph[curr.vertex].get(i);

                if(curr.used==0){
                    if(dist[curr.vertex][0]+neig.weight/2<dist[neig.dest][1]){
                        dist[neig.dest][1]=dist[curr.vertex][0]+neig.weight/2;
                        pq.add(new Node(neig.dest,dist[neig.dest][1],1));
                    }
                }
                //bina use kre daalna h
                if(dist[curr.vertex][curr.used]+neig.weight<dist[neig.dest][curr.used]){
                    dist[neig.dest][curr.used]=dist[curr.vertex][curr.used]+neig.weight;
                    pq.add(new Node(neig.dest, dist[neig.dest][curr.used], curr.used));
                }

            }

        }
        sc.println(dist[n-1][1]);
        sc.flush();












        sc.flush();
    }
    public static boolean dfs(int src,boolean vis[],ArrayList<Edge> graph[],int n){
        vis[src]=true;
        if(src==n-1){
            return true;
        }
        for(int i=0;i<graph[src].size();i++){
//
                if(vis[graph[src].get(i).dest]==false){
                if(dfs(graph[src].get(i).dest,vis,graph,n)){
                    return true;
                }

            }
        }
        return false;
    }

}
