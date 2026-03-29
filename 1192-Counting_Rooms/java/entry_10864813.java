import java.util.*;

public class entry_10864813 {

    static int [][] dirns = {{0,1}, {1,0}, {-1,0}, {0,-1}};

    static class Pair {
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char [][] map = new char[n][m];
        sc.nextLine();
        for(int i=0; i<n; i++){
            String line = sc.nextLine();
            for(int j=0; j<m; j++){
                map[i][j] = line.charAt(j);
            }
        }

        int rooms = 0;
        boolean [][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == '.' && !visited[i][j]){
                    // System.out.println(i + " " + j);
                    rooms++;
                    BFS(map, i, j, visited);
                }
            }
        }

        System.out.println(rooms);  // Added output
        sc.close();
    }


    private static void BFS(char [][] map, int r, int c, boolean[][] visited){
        LinkedList<Pair> q = new LinkedList<>();

        q.addLast(new Pair(r, c));

        while(q.size()>0){
            Pair rem = q.remove();
            for(int [] dirn : dirns){
            int nr = rem.x + dirn[0];
            int nc = rem.y + dirn[1];

            if(nr > -1 && nc > -1 && nr < map.length && nc < map[0].length){
                if(map[nr][nc] == '.' && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        }
    }


    // stack overflow

    // private static void DFS(char [][] map, int r, int c, boolean [][] visited){

    //     if(map[r][c] == '#' || visited[r][c])
    //         return;

    //     visited[r][c] = true;

    //     for(int [] dirn : dirns){
    //         int nr = r + dirn[0];
    //         int nc = c + dirn[1];

    //         if(nr > -1 && nc > -1 && nr < map.length && nc < map[0].length){
    //             if(map[nr][nc] == '.')
    //                 DFS(map, nr, nc, visited);
    //         }
    //     }
    // }
}