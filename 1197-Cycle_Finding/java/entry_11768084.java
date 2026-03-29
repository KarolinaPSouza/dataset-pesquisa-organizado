import java.util.*;
import java.io.*;
public class entry_11768084 {
    public static class Pair2{
        int a;
        int b;
        long c;
        public Pair2(int i,int j,long k){
            a=i;
            b=j;
            c=k;

        }

    }
    // private static void dfs(List<List<Pair>>list,int i,boolean[]vis){
    //     vis[i]=true;
    //     for(Pair p:list.get(i)){
    //         if(!vis[p.a]){
    //             dfs(list,p.a,vis);
    //         }
    //     }
    // }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        List<Pair2>list=new ArrayList<>();
        int[]in=new int[n+1];

        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            long c=sc.nextLong();
            in[b]++;
            list.add(new Pair2(a,b,c));
        }

        // System.out.println("hhh");
        // return;
        int[]pred=new int[n+1];
        Arrays.fill(pred,-1);

        long[]dis=new long[n+1];
        for(int i=1;i<=n;i++){
            // if(in[i]==0){
                list.add(new Pair2(0,i,0));
                // dis[i]=0;
            // }
        }
        // list.add(new Pair2(0,1,0));
        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0]=0;
        dis[1]=0;
        m=list.size();
        int flag=0;
        int var=-1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<m;j++){
                Pair2 p=list.get(j);
                int tar=p.b;
                int st=p.a;
                long val=p.c;
                if((dis[st]!=Long.MAX_VALUE)&&(dis[st]+val<dis[tar])){
                    flag=i;
                    var=tar;
                    dis[tar]=val+dis[st];
                    pred[tar]=st;
                    // System.out.println("flag="+flag);
                }
            }
        }
        if(flag==n){
            System.out.println("YES");
            List<Integer>ans=new ArrayList<>();
            for(int i=0;i<n;i++){
                var=pred[var];
            }
            int start=var;


            while(pred[var]!=start){
                ans.add(var);
                var=pred[var];
            }
            ans.add(var);
            ans.add(start);
            Collections.reverse(ans);
            for(int i:ans){
                System.out.print(i+" ");
            }
            // so
            System.out.println("");

        }
        else{
            System.out.println("NO");
        }
    }
}