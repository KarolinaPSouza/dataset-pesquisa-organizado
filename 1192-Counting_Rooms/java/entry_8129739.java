import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class entry_8129739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        String[] grid = new String[n];

        for(int i=0;i<n;i++){
            String row = scanner.nextLine();
            grid[i] = row;
        }

        scanner.close();

        int result = new entry_8129739().countRooms(n,m,grid);
        System.out.println(result);
    }

    int countRooms(int n, int m,String[] grid){
        int result = 0;
        boolean[][] marked = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i].charAt(j)=='.' && !marked[i][j]){
                    bfs(i,j,grid,marked,n,m);
                    result++;
                }
            }
        }
        return result;
    }

    void dfs(int i,int j, String[] grid, boolean[][] marked,int n, int m){
        if(j+1<m && grid[i].charAt(j+1)=='.' && !marked[i][j+1]){
            marked[i][j+1] = true;
            dfs(i,j+1,grid,marked,n,m);
        }
        if(i+1<n && grid[i+1].charAt(j)=='.' && !marked[i+1][j]){
            marked[i+1][j] = true;
            dfs(i+1,j,grid,marked,n,m);
        }
        if(j-1>=0 && grid[i].charAt(j-1)=='.' && !marked[i][j-1]){
            marked[i][j-1] = true;
            dfs(i,j-1,grid,marked,n,m);
        }
        if(i-1>=0 && grid[i-1].charAt(j)=='.' && !marked[i-1][j]){
            marked[i-1][j] = true;
            dfs(i-1,j,grid,marked,n,m);
        }
    }

    void bfs(int i, int j, String[] grid, boolean[][] marked, int n, int m){
        Queue<Pair> q = new LinkedList<>();
        int x,y;
        q.add(new Pair(i,j));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            x = curr.getKey();
            y = curr.getValue();

            if(y+1<m && grid[x].charAt(y+1)=='.' && !marked[x][y+1]){
                marked[x][y+1] = true;
                q.add(new Pair(x,y+1));
            }
            if(y-1>=0 && grid[x].charAt(y-1)=='.' && !marked[x][y-1]){
                marked[x][y-1] = true;
                q.add(new Pair(x,y-1));
            }
            if(x+1<n && grid[x+1].charAt(y)=='.' && !marked[x+1][y]){
                marked[x+1][y] = true;
                q.add(new Pair(x+1,y));
            }
            if(x-1>=0 && grid[x-1].charAt(y)=='.' && !marked[x-1][y]){
                marked[x-1][y] = true;
                q.add(new Pair(x-1,y));
            }
        }
    }

    class Pair{
        private int key,value;

        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }

        public int getKey(){
            return this.key;
        }

        public int getValue(){
            return this.value;
        }
    }
}

        // int n = 10, m = 10;
        // String[] grid = {"##..###..#","..#.#.....","..#...####","#.....##..","..#...#..#",".##.#.##..",".......#..","..........","...#.#....","..#..#...#"};