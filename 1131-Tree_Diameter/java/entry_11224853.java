import java.io.*;
import java.util.*;

public class entry_11224853 {
    static boolean [] visited;
    static List<Integer>[] adjList;
    static int maxdist;
    static int furthest;

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        adjList = new List[n+1];
        int cout = 0;
        maxdist=Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b); adjList[b].add(a);
        }
        if(n==1){
            cout=0;
        }
        else{
            dfs(1, 0);
            Arrays.fill(visited, false);
            dfs(furthest, 0);
            cout+=maxdist;
        }
        pr.println(cout);
        pr.close();
    }
    static void dfs(int node, int dist ){
        Stack<int []> stk = new Stack<>();
        stk.push(new int[]{node, 0});
        visited[node]=true;
        while(!stk.isEmpty()){
            int[] top = stk.pop();

            if (top[1]>maxdist) {
                maxdist=top[1];
                furthest=top[0];
            }
            for(int j: adjList[top[0]]){
                if(!visited[j]) {
                    visited[j]=true;
                    stk.push(new int[]{j, top[1]+1});
                }
            }
        }
    }
}