import java.io.*;
import java.util.*;

/* Irei deixar um comentário no final dos códigos para explicar o raciocinio */
public class entry_13409948 {

    static class Projeto implements Comparable<Projeto> {
        int inicio, fim, premio;
        Projeto(int inicio, int fim, int premio) {
            this.inicio = inicio;
            this.fim = fim;
            this.premio = premio;
        }
        public int compareTo(Projeto o) {
            return Integer.compare(this.fim, o.fim);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        int n = Integer.parseInt(br.readLine());
        Projeto[] projetos = new Projeto[n];

        int idx = 0;
        while (idx < n) {
            String linha = br.readLine();
            int ini = 0, fim = 0, premio = 0;

            int num = 0, sinal = 1;
            int campo = 0;
            for (int i = 0; i <= linha.length(); i++) {
                char c = (i == linha.length() ? ' ' : linha.charAt(i));
                if (c == '-') {
                    sinal = -1;
                } else if (c >= '0' && c <= '9') {
                    num = num * 10 + (c - '0');
                } else if (c == ' ') {
                    if (campo == 0) ini = num * sinal;
                    else if (campo == 1) fim = num * sinal;
                    else if (campo == 2) premio = num * sinal;
                    campo++;
                    num = 0;
                    sinal = 1;
                }
            }
            projetos[idx++] = new Projeto(ini, fim, premio);
        }

        Arrays.sort(projetos);

        long[] dp = new long[n];
        int[] fins = new int[n];
        for (int i = 0; i < n; i++) fins[i] = projetos[i].fim;

        for (int i = 0; i < n; i++) {
            int id = buscaBinaria(fins, projetos[i].inicio - 1);
            long melhorAte = (id == -1) ? 0 : dp[id];
            long comAtual = melhorAte + projetos[i].premio;
            long semAtual = (i == 0) ? 0 : dp[i - 1];
            dp[i] = Math.max(comAtual, semAtual);
        }
        System.out.println(dp[n - 1]);
    }

    static int buscaBinaria(int[] fins, int val) {
        int esquerda = 0, direita = fins.length - 1, res = -1;
        while (esquerda <= direita) {
            int meio = (esquerda + direita) >>> 1;
            if (fins[meio] <= val) {
                res = meio;
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return res;
    }

    // Para cada valor, decide onde encaixar ele na sequência ótima parcial usando busca binária
    // mantendo só as melhores soluções de cada tamanho.
    // Com isso, construo a solução ótima aproveitando subproblemas resolvidos
}