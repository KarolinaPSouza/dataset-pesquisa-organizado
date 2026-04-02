import java.util.*;
import java.io.*;
public class entry_14331661 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int roads= Integer.parseInt(st.nextToken());
        disjoint ds= new disjoint(n+1);
        for(int i=0;i<roads;i++){
            st= new StringTokenizer(br.readLine());
            int v1= Integer.parseInt(st.nextToken());
            int v2= Integer.parseInt(st.nextToken());
            ds.unionByRank(v1, v2);
        }
        HashSet<Integer> hs= new HashSet();
        for(int i=1;i<=n;i++){
            hs.add(ds.findPar(i));
        }
        List<Integer> l= new ArrayList<>(hs);
int ans= hs.size();
StringBuilder sb = new StringBuilder();
for(int i=1;i<l.size();i++){
    sb.append(l.get(0)).append(" ").append(l.get(i)).append("\n");
}
System.out.println(ans-1);
System.out.println(sb);
    }
}
class disjoint{
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size= new ArrayList<>();
    public disjoint(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findPar(int node){
        if(node==parent.get(node)) return node;
        int par= findPar(parent.get(node));
        parent.set(node,par);
        return par;
    }
    public void unionByRank(int u ,int v){
        int ul_u=findPar(u);
        int ul_v=findPar(v);
        if(ul_u==ul_v) return;
        if(rank.get(ul_u)>rank.get(ul_v)){
            parent.set(ul_v,ul_u);}
            else{
                if(rank.get(ul_u)<rank.get(ul_v)){
                    parent.set(ul_u,ul_v);
                }
                else{
                    if(rank.get(ul_u)==rank.get(ul_v)){
                        parent.set(ul_u,ul_v);
                        rank.set(ul_v,rank.get(ul_v)+1);
                    }
                }
            }
    }
    public void unionBySize(int u,int v){
        int ul_u=findPar(u);
        int ul_v=findPar(v);
        if(ul_u==ul_v) return;
        if(size.get(ul_u)>size.get(ul_v)){
            parent.set(ul_v,ul_u);
            size.set(ul_u,size.get(ul_u)+size.get(ul_v));
        }
        else{
               parent.set(ul_u,ul_v);
            size.set(ul_v,size.get(ul_v)+size.get(ul_u));
        }

    }
}