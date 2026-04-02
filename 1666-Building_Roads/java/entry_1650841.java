import java.io.*;
import java.util.*;

public class entry_1650841 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] ids;

    static void dfs(int i, int id) {
        ids[i]=id;
        for(int n : adj[i]) {
            if(ids[n]==0)
                dfs(n, id);
        }
    }

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj=new ArrayList[N];
        ids=new int[N];
        for(int i = 0; i < N; i++)
            adj[i]=new ArrayList<Integer>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken())-1;

            adj[f].add(s);
            adj[s].add(f);
        }

        int id = 1;
        ArrayList<Integer> rep = new ArrayList<>();
        for(int i = 0; i < N; i++){
            if(ids[i]==0){
                rep.add(i);
                dfs(i, id++);
            }
        }

        System.out.println(rep.size()-1);
        for(int i = 1; i < rep.size(); i++) 
                System.out.println((rep.get(i-1)+1) + " " + (rep.get(i)+1));


    } 

}