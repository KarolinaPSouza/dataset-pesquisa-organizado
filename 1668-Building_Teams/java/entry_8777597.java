import java.util.*;
import java.io.*;
public class entry_8777597 {
    public static void main(String[] args)throws IOException {
        BufferedReader cans=new BufferedReader(new InputStreamReader(System.in));
        String str=cans.readLine();
        String[] s1=str.split(" ");
        int n=Integer.parseInt(s1[0]);
        int m=Integer.parseInt(s1[1]);
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            String st=cans.readLine();
            String[] s2=st.split(" ");
            int u=Integer.parseInt(s2[0]);
            int v=Integer.parseInt(s2[1]);
            adj.get(v).add(u);
            adj.get(u).add(v);
        }
        boolean[] vis=new boolean[n+1];
        boolean[] marking=new boolean[n+1];
        boolean[] plag=new boolean[1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                vis[i]=true;
                marking[i]=true;
                dfs(adj,vis,i,true,marking,plag);
            }
            if(plag[0]==true)break;
        }
        if(plag[0]){
            System.out.println("IMPOSSIBLE");
        }else{
            StringBuilder str1=new StringBuilder();
            for(int i=1;i<=n;i++){
                if(marking[i])
                str1.append(1).append(" ");
                else{
                    str1.append(2).append(" ");
                }
            }
            System.out.println(str1);
        }
    }
    public static void dfs(List<List<Integer>> adj,boolean[] vis,int src,boolean flag,boolean[] marking,boolean[] plag){
        for(int idx:adj.get(src)){
            if(!vis[idx]){
                vis[idx]=true;
                marking[idx]=!flag;
                dfs(adj,vis,idx,!flag,marking,plag);
            }else{
                if(marking[idx]==marking[src])plag[0]=true;
            }
        }
    }
}