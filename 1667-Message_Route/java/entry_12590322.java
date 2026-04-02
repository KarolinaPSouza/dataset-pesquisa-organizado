import java.io.*;
import java.util.*;
public class entry_12590322 {
    public static ArrayList<Integer>[] ar;
    public static int[] dist;
    public static int[] par;
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1]=1;
        par[1]=-1;
        while(!q.isEmpty()){
            int i = q.remove();
            for(int j:ar[i]){
                if(dist[j]==-1){
                    dist[j]= dist[i]+1;
                    par[j] = i;
                    q.add(j);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);
        ar = new ArrayList[n+1];
        dist = new int[n+1];
        par = new int[n+1];
        for(int i=1;i<=n;i++){
            ar[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            String[] p = br.readLine().split(" ");
            int a = Integer.parseInt(p[0]);
            int b = Integer.parseInt(p[1]);
            ar[a].add(b);
            ar[b].add(a);
        }
        Arrays.fill(dist,-1);
        bfs();
        if(dist[n]!=-1){
            System.out.println(dist[n]);
            ArrayList<Integer> path = new ArrayList<>();
            int i =n;
            while(i!=-1){
                path.add(i);
                i= par[i];
            }
            Collections.reverse(path);
            for(int j:path){
                System.out.print(j+" ");
            }
        }
        else{
            System.out.println("IMPOSSIBLE");
        }
    }
}