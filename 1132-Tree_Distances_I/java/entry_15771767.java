import java.io.*;
import java.util.*;

public class entry_15771767 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer>[] edges = new ArrayList[n];

        for(int i=0;i<n;i++){
            edges[i]=new ArrayList<>();
        }



        for(int i=1;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            edges[a].add(b);
            edges[b].add(a);
        }



        int[] ans = new int[n];
        int start=0;


        Queue<int[]> q = new ArrayDeque<>();
        int max=0;
        q.add(new int[]{0,0});
        int[] visited = new int[n];

        while(!q.isEmpty()){
            int[] parts = q.poll();
            if(visited[parts[0]]==0){
                visited[parts[0]]=1;
                if(max<parts[1]){
                    start=parts[0];
                    max=parts[1];
                }
                for(int i:edges[parts[0]]){
                    if(visited[i]==0) {
                        q.add(new int[]{i,parts[1]+1});
                    }
                }
            }
        }

        int end=0;
         max=0;
        q.add(new int[]{start,0});
         visited = new int[n];

        while(!q.isEmpty()){
            int[] parts = q.poll();
            if(visited[parts[0]]==0){
                ans[parts[0]]=parts[1];
                visited[parts[0]]=1;
                if(max<parts[1]){
                    end=parts[0];
                    max=parts[1];
                }
                for(int i:edges[parts[0]]){
                    if(visited[i]==0) {
                        q.add(new int[]{i,parts[1]+1});
                    }
                }
            }
        }

        visited = new int[n];
        q.add(new int[]{end,0});
        while(!q.isEmpty()){
            int[] parts = q.poll();
            if(visited[parts[0]]==0){
                ans[parts[0]]=Math.max(parts[1],ans[parts[0]]);
                visited[parts[0]]=1;
                for(int i:edges[parts[0]]){
                    if(visited[i]==0) {
                        q.add(new int[]{i,parts[1]+1});
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i:ans){
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());

    }
}