import java.util.Arrays;
import java.util.Scanner;

public class entry_507126 {
    static int[] dsu;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        byte[][] chars = new byte[n][];

        for(int i = 0; i < n; i++){
            chars[i] = sc.next().getBytes();
        }

        int vertices = n * m;
        dsu = new int[vertices];

        Arrays.fill(dsu, -1);

        int dotCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(chars[i][j]=='.'){
                    dotCount++;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                if(chars[i][j-1]=='.' && chars[i][j]=='.'){
                    int u = (i*m) + j - 1; //cc[i][j-1]
                    int v = (i*m) + j; //cc[i][j]
                    if(join(u,v)){
                        dotCount--;
                    }
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(chars[i-1][j]=='.' && chars[i][j]=='.'){
                    int u = ((i-1)*m) + j; //cc[i][j-1]
                    int v = (i*m) + j; //cc[i][j]
                    if(join(u,v)){
                        dotCount--;
                    }
                }
            }
        }

        System.out.println(dotCount);
    }

    static boolean join(int u, int v){
        u = find(u);
        v = find(v);

        if(u==v){
            return false;
        }

        if(dsu[u] > dsu[v]){
            dsu[u] = v;
        }
        else{
            if(dsu[u]==dsu[v]){
                dsu[u]--;
            }
            dsu[v] = u;
        }

        return true;
    }

    static int find(int loc){
        return dsu[loc]<0 ? loc : (dsu[loc] = find(dsu[loc]));
    }
}