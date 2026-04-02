import java.io.*;
import java.util.*;

public class entry_14529756 {

    /**
     * Clase auxiliar para lectura rápida de enteros desde la entrada estándar.
     */
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16]; // 64 KB buffer
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        // Lee un byte, recarga el buffer si es necesario
        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        // Lee el siguiente entero de la entrada
        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            // saltar espacios en blanco
            do {
                c = readByte();
            } while (c <= ' ');
            // manejar signo negativo
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            // construir el número
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        // Leer n (cantidad de monedas) y x (suma objetivo)
        int n = fs.nextInt();
        int x = fs.nextInt();

        // Leer valores de las monedas
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = fs.nextInt();
        }

        // Constante para el módulo
        int MOD = 1_000_000_007;

        // número de formas de hacer la suma i 
        int[] dp = new int[x + 1];
        dp[0] = 1; // caso base

        // Para cada suma de 1 hasta x
        for (int i = 1; i <= x; i++) {
            long ways = 0; // evita overflow 
            // Intentar cada moneda como última
            for (int c : coins) {
                if (c <= i) {
                    ways += dp[i - c];
                }
            }
            dp[i] = (int) (ways % MOD); // guardar en dp[i] con módulo
        }

        // Imprimir el resultado final: número de formas de hacer suma x
        System.out.println(dp[x]);
    }
}