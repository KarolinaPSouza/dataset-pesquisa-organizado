import java.io.*;
import java.util.*;
public class entry_3180456 {
    static ArrayList<Integer>v;
    static int n, m;
    static boolean b[][];
    static int ans;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        b=new boolean[n][m];
        for(int i=0;i<n;i++) {
            st=new StringTokenizer(br.readLine());
            String str=st.nextToken();
            for(int j=0;j<m;j++) {
                char c=str.charAt(j);
                if(c=='#') {
                    b[i][j]=true;
                }else {
                    b[i][j]=false;
                }
            }
        }
        int ans=0;
        int []dx=new int[] {-1,0,1,0};
  int []dy=new int[] {0,1,0,-1};
  for(int i=0;i<b.length;i++) {
   for(int j=0;j<b[i].length;j++) {
    if(b[i][j]) {
     continue;
    }
    ans++;
    ArrayDeque<Integer> x=new ArrayDeque<Integer>();
    ArrayDeque<Integer> y=new ArrayDeque<Integer>();
    x.add(i);
    y.add(j);
    while(!x.isEmpty()) {
     int x1=x.poll();
     int y1=y.poll();
     for(int c=0;c<4;c++) {
      int nextX=x1+dx[c];
      int nextY=y1+dy[c];
      if(nextX<n&&nextX>=0&&nextY<m&&nextY>=0) {
       if(!b[nextX][nextY]) {
        b[nextX][nextY]=true;
        x.addLast(nextX);
        y.addLast(nextY);
       }
      }
     }
    }
   }
  }
  System.out.println(ans);
    }

}