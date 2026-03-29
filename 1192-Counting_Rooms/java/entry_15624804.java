import java.util.*;
import java.io.*;

public class entry_15624804 {
    static int []xQueue;
    static int []yQueue;
    static int n,m;
    static char [][]grid;
    static int []dx={-1,1,0,0};
    static int []dy={0,0,1,-1};

    static boolean isValid(int x,int y){
        return x>=0 && x<n && y>=0 && y<m && grid[x][y]=='.';
    }
    static void bfs(int start_x,int start_y){
        int head=0,tail=0;
        xQueue[tail]=start_x;
        yQueue[tail]=start_y;
        grid[start_x][start_y]='#';
        tail++;

        while (head<tail){
            int x=xQueue[head],y=yQueue[head];
            head++;
            for(int d=0;d<4;d++){
                int nx=x+dx[d],ny=y+dy[d];
                if(isValid(nx,ny)){
                    xQueue[tail]=nx;
                    yQueue[tail]=ny;
                    grid[nx][ny]='#';
                    tail++;
                }
            }
        }
    }
    public static void main(String []args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        grid=new char[n][m];
        xQueue=new int[n*m];
        yQueue=new int[n*m];
        int res=0;

        for(int i=0;i<n;i++){
            grid[i]=br.readLine().toCharArray();
        }

        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
                char cell=grid[x][y];
                if (cell == '.'){
                  res++;
                  bfs(x,y);
                }
            }
        }

        System.out.println(res);
        br.close();
    }
}