import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class entry_9955790 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al.get(a).add(b);
            al.get(b).add(a);
        }
        ArrayList<Integer>start=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        boolean[] visited=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(visited[i]==false){
                start.add(i);
                q.offer(i);
                visited[i]=true;
                while(!q.isEmpty()){
                    int p=q.poll();
                    for(int j=0;j<al.get(p).size();j++){
                        if(visited[al.get(p).get(j)]==false){
                            q.offer(al.get(p).get(j));
                            visited[al.get(p).get(j)]=true;
                        }
                    }
                }
            }
        }
        System.out.println(start.size()-1);
        if(start.size()!=1){
            for(int i=0;i<start.size()-1;i++){
                System.out.println(start.get(i)+" "+start.get(i+1));
            }
        }
    }
}