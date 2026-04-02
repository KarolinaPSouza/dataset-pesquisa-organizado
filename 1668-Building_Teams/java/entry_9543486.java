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
//class Node{
//    int vertex;
//    StringBuilder path;
//    public Node(int vertex,StringBuilder path){
//       this.vertex=vertex;
//        this.path=path;
//    }
//}
//class Computer{
//    int vertex;
//    StringBuilder path;
//    int count;
//    public Pupil(int vertex,StringBuilder path,int count){
//        this.vertex=vertex;
//        this.path=path;
//        this.count=count;
//    }
//}

public class entry_9543486 {
    public static void main(String[] args) {
        FastIO sc = new FastIO();


        int n = sc.nextInt();
        int m = sc.nextInt();

       ArrayList<Integer> graph[]=new ArrayList[n+1];
       for(int i=0;i<n+1;i++){
           graph[i]=new ArrayList<>();
       }
       for(int i=0;i<m;i++){
           int src=sc.nextInt();
           int dest=sc.nextInt();
           graph[src].add(dest);
           graph[dest].add(src);
       }
       int colors[]=new int[n+1];
       boolean found=true;
       for(int i=1;i<n;i++){
           if(colors[i]==0){
               boolean currentStatus=bfs(i,graph,colors);
               if(currentStatus==false){
                   found=false;
                   break;
               }
           }
       }
       if(found){
           for(int i=1;i<n+1;i++){
               sc.print(colors[i]+" ");
           }

       }else{
           sc.println("IMPOSSIBLE");
       }
       sc.flush();



    }
    public static boolean bfs(int src,ArrayList<Integer> graph[],int colors[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        colors[src]=1;
        while(!q.isEmpty()){
            int curr=q.remove();

            for(int i=0;i<graph[curr].size();i++){
                if(colors[graph[curr].get(i)]==colors[curr]){
                    return false;
                }else{
                    if(colors[graph[curr].get(i)]==0){
                        colors[graph[curr].get(i)]=(colors[curr]==1?2:1);
                        q.add(graph[curr].get(i));
                    }
                }
            }
        }
        return true;
    }
}
