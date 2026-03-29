import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class entry_10170098 {
    static int n,m;
    static class Pair{
        int f,s;
        public Pair(int f,int s){
            this.f=f;
            this.s=s;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
                arr[i] = br.readLine().toCharArray();
        }
        int cnt=0;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j=0;j<m;j++) {
                if (arr[i][j]=='.' && vis[i][j]==0) {
                    bfs(i,j,q,vis,arr);
                    cnt++;
                }
            }
        }
            System.out.println(cnt);
    }

    private static void bfs(int i, int j, Queue<Pair> q, int[][] vis, char[][] arr) {
        q.add(new Pair(i,j));
        vis[i][j]=1;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int r=p.f;
            int c=p.s;
            if(r+1<n && vis[r+1][c]==0 && arr[r+1][c]=='.'){
                vis[r+1][c]=1;
                q.add(new Pair(r+1,c));
            }
            if(r-1>=0 && vis[r-1][c]==0 && arr[r-1][c]=='.'){
                vis[r-1][c]=1;
                q.add(new Pair(r-1,c));
            }
            if(c+1<m && vis[r][c+1]==0 && arr[r][c+1]=='.'){
                vis[r][c+1]=1;
                q.add(new Pair(r,c+1));
            }
            if(c-1>=0 && vis[r][c-1]==0 && arr[r][c-1]=='.'){
                vis[r][c-1]=1;
                q.add(new Pair(r,c-1));
            }
        }
    }
}