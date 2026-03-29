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
    int src;
    int dest;
    int weight;
    public Edge(int src,int dest,int weight){
        this.src=src;
        this.dest=dest;
        this.weight=weight;
    }
}




public class entry_9565702 {
    public static void main(String[] args) {
        FastIO sc = new FastIO();


        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Edge> graph[]=new ArrayList[n];
        long dist[] = new long[n];
        int prevNode[]=new int[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int wt = sc.nextInt();

            graph[src].add(new Edge(src,dest,wt));

        }
        for (int i = 1; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n - 1; i++) {
            for(int j=0;j<n;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    int src=e.src;
                    int dest=e.dest;
                    int wt=e.weight;
                    if (dist[e.src] + e.weight < dist[e.dest]) {
                        dist[e.dest] = dist[e.src] + e.weight;
                        prevNode[e.dest]=e.src;
                    }
                }
            }

        }
        boolean negCycleDetectedA=false;
        ArrayList<Integer> path=new ArrayList<>();
        for(int j=0;j<n;j++){
            if(negCycleDetectedA==true){
                break;
            }
            for(int k=0;k<graph[j].size();k++){
                Edge e=graph[j].get(k);
                int src=e.src;
                int dest=e.dest;
                int wt=e.weight;
                if (dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.dest]) {

                    int slow=prevNode[e.src];
                    int fast=prevNode[slow];
                    while(slow!=fast){
                        fast=prevNode[prevNode[fast]];
                        slow=prevNode[slow];
                    }
                    int start=slow;
                    int end=prevNode[slow];
                    path.add(start);
                    while(end!=start){
                        path.add(end);
                        end=prevNode[end];
                    }
                    path.add(end);
//                    path.add(end);
                    negCycleDetectedA=true;
                    break;

                }
            }
        }
        if(negCycleDetectedA){
            sc.println("YES");
            for(int i=path.size()-1;i>=0;i--){
                sc.print(path.get(i)+1+" ");
            }
        }else{
            sc.println("NO");
        }
        sc.flush();

    }
//    public static boolean printCycle(int ultimateSrc,int src,boolean vis[],ArrayList<Edge> graph[],ArrayList<Integer> path){
//        vis[src]=true;
//        path.add(src);
//
//        for(int i=0;i<graph[src].size();i++){
//            if(graph[src].get(i).dest==ultimateSrc){
//                path.add(graph[src].get(i).dest);
//                return true;
//            }else if(vis[graph[src].get(i).dest]!=true){
//
//                if(printCycle(ultimateSrc,graph[src].get(i).dest,vis,graph,path)){
//                    return true;
//                }else{
//                    path.remove(path.size()-1);
//
//                }
//            }
////
//
//        }
//
//        path.remove(path.size() - 1); // Backtrack
//        return false;
//    }

}