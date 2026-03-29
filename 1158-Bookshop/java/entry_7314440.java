// Martin Schoenig 245714 Nicolas Rosa 225609 Joaquin Marquez 239919
import java.util.*;

public class entry_7314440 {

    public static Integer puroVerso(int N, int X, int[] precios, int[] paginas){
        int [] dp = new int[X+1];
        int maxPaginas = 0;
        for(int i=1; i<=N; i++){
            for(int j=X; j>=1; j--){
                if(precios[i] <= j){
                    dp[j] = Math.max(dp[j], dp[j-precios[i]] + paginas[i]);
                    maxPaginas = Math.max(maxPaginas, dp[j]);
                }
            }
        }
        return maxPaginas;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int[] precios = new int[N+1];
        int[] paginas = new int[N+1];
        for(int i = 1; i <= N; i++){
            precios[i] = sc.nextInt();
        }
        for(int i = 1; i <= N; i++){
            paginas[i] = sc.nextInt();
        }
        int result = puroVerso(N, X, precios, paginas);
        System.out.println(result);
    }

}