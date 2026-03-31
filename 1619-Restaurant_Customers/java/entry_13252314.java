import java.io.*;

public class entry_13252314 {
    static final int MAX = 400000;
    static int[] tiempos = new int[MAX];
    static int[] tipos = new int[MAX];
    static int[] auxTiempo = new int[MAX];
    static int[] auxTipo = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] partes = br.readLine().split(" ");
            int a = Integer.parseInt(partes[0]);
            int b = Integer.parseInt(partes[1]);
            tiempos[2 * i] = a; tipos[2 * i] = 1;
            tiempos[2 * i + 1] = b; tipos[2 * i + 1] = -1;
        }

        radixSort(tiempos, tipos, 2 * N);

        int cur = 0, ans = 0;
        for (int i = 0; i < 2 * N; i++) {
            cur += tipos[i];
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }

    // Radix sort adaptado a pares (tiempo, tipo)
    static void radixSort(int[] tiempo, int[] tipo, int n) {
        for (int shift = 0; shift < 32; shift += 8) {
            int[] count = new int[256];
            for (int i = 0; i < n; i++) {
                int val = (tiempo[i] >> shift) & 255;
                count[val]++;
            }
            for (int i = 1; i < 256; i++) {
                count[i] += count[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int val = (tiempo[i] >> shift) & 255;
                int pos = --count[val];
                auxTiempo[pos] = tiempo[i];
                auxTipo[pos] = tipo[i];
            }
            // Copiar de vuelta
            System.arraycopy(auxTiempo, 0, tiempo, 0, n);
            System.arraycopy(auxTipo, 0, tipo, 0, n);
        }

        // Empate por tiempo: tipo 1 antes que -1
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && tiempo[i] == tiempo[j]) j++;
            // Ordenar tipo en [i, j) por tipo (1 antes que -1)
            int a = i, b = j - 1;
            while (a < b) {
                while (a < b && tipo[a] <= tipo[i]) a++;
                while (a < b && tipo[b] > tipo[i]) b--;
                if (a < b) {
                    int tmp = tipo[a];
                    tipo[a] = tipo[b];
                    tipo[b] = tmp;
                }
            }
            i = j;
        }
    }
}
