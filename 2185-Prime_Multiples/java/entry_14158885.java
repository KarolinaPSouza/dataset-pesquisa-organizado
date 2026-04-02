import java.util.Scanner;

public class entry_14158885 {
    public static void main(String[] args) {
        long final_num;
        int qtd_primos;
        long[] vector;
        // Read inputs
        try (Scanner scanner = new Scanner(System.in)) {
            // Read inputs
            final_num = scanner.nextLong();
            qtd_primos = scanner.nextInt();
            vector = new long[qtd_primos];
            for (int i = 0; i < qtd_primos; i++) {
                vector[i] = scanner.nextLong();
            }
        }

        long possiveis = 0;
        int limit = 1 << qtd_primos;

        for (int mask = 1; mask < limit; mask++) {
            long divisor = 1;
            int int_exc = 1;
            boolean overflow = false;

            for (int i = 0; i < qtd_primos; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (divisor > final_num / vector[i]) {
                        overflow = true;
                        break;
                    }
                    divisor *= vector[i];
                    int_exc += 1;
                }
            }

            if (overflow || divisor > final_num) {
                continue;
            }

            // Calcular sinal: (-1)^int_exc
            // int_exc = count of bits + 1
            // So sign = (-1)^(int_exc)
            int sign = (int_exc % 2 == 0) ? 1 : -1;

            possiveis += sign * (final_num / divisor);

        }

        System.out.println(possiveis);
    }
}