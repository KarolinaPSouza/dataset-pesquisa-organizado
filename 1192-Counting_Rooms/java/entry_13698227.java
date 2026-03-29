import java.util.*;
import java.io.*;
public class entry_13698227 {
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        char[][] ch=new char[n][m];
        for(int i=0;i<n;i++){
            String x=br.readLine();
            for(int j=0;j<m;j++){
                ch[i][j]=x.charAt(j);
            }
        }
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ch[i][j]=='.' && !visited[i][j]){
                    ans++;
                    helper(ch,i,j,visited);
                }
            }
        }
        System.out.println(ans);
    }
    public static void helper(char[][] ch,int row,int col,boolean[][] visited){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row,col));
        visited[row][col]=true;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int x=p.x;
            int y=p.y;
            for(int j=0;j<4;j++){
                int newX=x+dx[j];
                int newY=y+dy[j];
                if(newX>=0 && newX<ch.length && newY>=0 && newY<ch[0].length && ch[newX][newY]=='.' && !visited[newX][newY]){
                    q.add(new Pair(newX,newY));
                    visited[newX][newY]=true;
                }
            }
        }
    }
    static class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}