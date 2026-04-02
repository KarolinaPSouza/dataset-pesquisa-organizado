import java.util.Scanner;
import java.util.Arrays;

public class entry_9577650 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] moedas = new int[n];
        for (int i = 0; i < n; i++) {
            moedas[i] = scanner.nextInt();
        }

        int resultado = calculaMinimoMoedas(moedas, x);
        System.out.println(resultado);
        scanner.close();
    }

    private static int calculaMinimoMoedas(int[] moedas, int x) {
        int[] contaMoedas = new int[x + 1];
        Arrays.fill(contaMoedas, Integer.MAX_VALUE);
        contaMoedas[0] = 0;

        for (int valorAtual = 1; valorAtual <= x; valorAtual++) {
            for (int moeda : moedas) {
                if (moeda <= valorAtual) {
                    int moedasAnteriores = contaMoedas[valorAtual - moeda];
                    if (moedasAnteriores != Integer.MAX_VALUE) {
                        contaMoedas[valorAtual] = Math.min(contaMoedas[valorAtual], moedasAnteriores + 1);
                    }
                }
            }
        }
        return contaMoedas[x] == Integer.MAX_VALUE ? -1 : contaMoedas[x];
    }
}