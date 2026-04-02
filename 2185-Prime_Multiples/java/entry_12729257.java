import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_12729257 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] a = new long[k];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < k; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        long resultado = 0;
        // Recorremos todas las submáscaras de [0..(1<<k)-1], exceptuando la 0
        int totalMasks = 1 << k;
        for (int mask = 1; mask < totalMasks; mask++) {
            long lcm = 1;
            int bits = Integer.bitCount(mask);
            boolean overflow = false;

            // Para cada bit i en mask, incorporamos el primo a[i]
            for (int i = 0; i < k; i++) {
                if ((mask & (1 << i)) != 0) {
                    // Como todos son primos distintos, el LCM es producto directo
                    // pero comprobamos overflow respecto a n
                    if (lcm > n / a[i]) {
                        overflow = true;
                        break;
                    }
                    lcm *= a[i];
                }
            }

            if (overflow || lcm == 0) {
                // Si el LCM excede n, entonces n / lcm == 0, podemos saltar
                continue;
            }

            long cnt = n / lcm;
            // Si el número de primos en la submáscara es impar sumamos; si es par restamos
            if ((bits & 1) == 1) {
                resultado += cnt;
            } else {
                resultado -= cnt;
            }
        }

        System.out.println(resultado);
    }
}