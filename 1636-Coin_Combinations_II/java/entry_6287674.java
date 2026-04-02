import java.util.Scanner;

public class entry_6287674 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] L = new int[n];
        for (int i = 0; i < n; i++) {
            L[i] = scanner.nextInt();
        }
        int[] M = new int[x + 1];
        for (int k = 0; k < L.length; k++) {
            for (int j = 0; j < M.length; j++) {
                if (L[k] == j) {
                    M[j] = M[j] + 1;
                }
                if (j >= L[k]) {
                    M[j] = M[j] + M[j - L[k]];
                }
                M[j] = M[j] % 1000000007;
            }
        }
        System.out.println(M[M.length - 1]);
    }
}