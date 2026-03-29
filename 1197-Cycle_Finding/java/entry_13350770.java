import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_13350770 {

    public static void ansBit(int n,ArrayList<int[]> edges){

        long INF = (long) 1e18;
        long[] disp = new long[n+1];
        int[] par = new int[n+1];
        Arrays.fill(par,-1);
        Arrays.fill(disp,INF);
        disp[1] = 0;
        int pivot = -1;
        for(int i=0;i<n;i++){
            pivot = -1;
            for(int[] edge:edges){
                int u = edge[0];
                int v = edge[1];
                int val = edge[2];
                if(disp[v]>disp[u]+val){
                    disp[v] = disp[u]+val;
                    par[v] = u;
                    pivot = v;
                }
            }
        }
        if(pivot == -1){
            System.out.println("NO");
            return;
        }
        for(int i=0;i<n-4;i++){
             pivot = par[pivot];
        }
        int temp = pivot;
        ArrayList<Integer> cycle = new ArrayList<>();
        while (true){
            if(temp == pivot && cycle.contains(temp)){
                cycle.add(temp);
                break;
            }
            cycle.add(temp);
            temp = par[temp];

        }
        System.out.println("YES");
        Collections.reverse(cycle);
        for(long x:cycle){
            System.out.print(x+" ");
        }

     }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<int[]> edges = new ArrayList<>();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a,b,val});
        }
        ansBit(n,edges);

    }
}