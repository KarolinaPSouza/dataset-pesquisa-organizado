import java.util.*;
public class entry_7592717 {
    static char [][] arr;
    static int n, m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[n][m];
        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j]=='.'){
                    floodfill(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);


    }
    public static void floodfill(int x, int y){
        if((x<0)||(x>=n)||(y<0)||(y>=m)){
            return;
        }
        if(arr[x][y]=='#'){
            return;
        }

        arr[x][y]='#';
        floodfill(x+1, y);
        floodfill(x-1, y);
        floodfill(x, y+1);
        floodfill(x, y-1);
    }
}