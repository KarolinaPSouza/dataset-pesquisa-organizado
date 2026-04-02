import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class entry_5863870 {
    static int[]vis;
    static ArrayList<Integer>temp;
    static ArrayList<Integer>[]graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PrintWriter pw = new PrintWriter(System.out);
        graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a-1].add(b-1);
            graph[b-1].add(a-1);
        }
        vis=new int[n];
        temp=new ArrayList<>();
        for(int j=0;j<n;j++){

            if(vis[j]==0&&dfs(j,-1) ){

                boolean flag=false;
                int s=temp.size();

                for(int i=0;i<temp.size();i++){
                    if((i!=temp.size()-1)&&(Objects.equals(temp.get(i), temp.get(temp.size() - 1)))){
                        flag=true;
                        pw.println(s);
                    }
                    if(flag){
                        pw.print(temp.get(i)+1);
                        pw.print(' ');
                    }
                    else{
                        s--;
                    }
                }
                pw.close();
                return;
            }
        }
        pw.println("IMPOSSIBLE");
        pw.close();
    }

    public static boolean dfs(int node, int par){
        vis[node]=1;
        temp.add(node);
        for(int child:graph[node]){
            if(vis[child]==0){
                if(dfs(child, node)){
                    return true;
                }
            }
            else{
                if(par!=child){
                    temp.add(child);
                    return true;
                }
            }
        }
        temp.remove(temp.size()-1);
        return false;
    }
}