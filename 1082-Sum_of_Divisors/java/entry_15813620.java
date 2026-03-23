import java.io.*;
import java.util.*;
import java.lang.reflect.Array;

public class entry_15813620 {

    // Entrada rápida
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try { return br.readLine(); }
            catch (IOException e) { e.printStackTrace(); return null; }
        }

        boolean hasNext() {
            try {
                while (st == null || !st.hasMoreElements()) {
                    String line = br.readLine();
                    if (line == null) return false;
                    st = new StringTokenizer(line);
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    static int MOD = 1_000_000_007;

    public static void main(String[] args) {
        ///////////////////////////////////////

        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // sum(1,n)(sigma(x)) = sum(1,n)(d*floor(n/d)) donde d aparece como divisor de exactamente floor(n/d) números entre 1 y n
        // sumar directamente sería O(n) -> TLE
        // el problema se reduce a separar por bloques de d's con el mismo k, es decir, todos los d entre 1 y n tales que floor(n/d) = k
        // tal bloque de d's va desde i (primer valor d desde 1 encontrado tal que k = floor(n/d) hasta last = n/k = n/floor(n/d))
        // para una noción rápida de que last es el último d tal que k = floor(n/d), podemos ver rápidamente que k depende inversamente 
        // de d, y si es que d crece lo suficiente entonces k se hace k = floor(n/d') = floor(n/d)-1 para  un d'>d suficientemente grande
        // entonces last = max d tal que floor(n/d) = k -> last = floor(n/k)
        // -> tenemos las contribuciones (i + (i+1) + ... + last) * k = (i+last) * (last-i+1) / 2 por progresión aritmética
        // luego la iteración del próximo bloque se inicia desde i' = last+1 ...
        // el valor floor(n/i) toma solo O(sqrt(n)) distintos
        long n = in.nextLong();

        long res = 0;
        long i = 1;

        while (i <= n) {
            long k = n / i;// floor(n / i) // k es la cantidad de veces que i aparece como divisor de algún número hasta n
            long last = n / k;// último i con ese mismo k (last = n / floor(n / i))

            // suma de i..last con módulo MOD
            long sum = ( (i + last) % MOD ) * ((last - i + 1) % MOD) % MOD;// Calcula la suma de todos los números desde i hasta 
                                                                           // last (progresión aritmética):
                                                                           // suma = (i + (i+1) + ... + last) = (i+last) * (last-i+1) / 2
            sum = sum * ((MOD + 1) / 2) % MOD;// dividir por 2 módulo MOD -> * ((MOD + 1) / 2): la regla práctica es (a*b^(-1)) mod MOD 
                                              // donde b^(-1) es el inverso modular de b

            res = (res + (k % MOD) * sum) % MOD;

            i = last + 1;
        }
        out.println(res);





        ///////////////////////////////////////
        out.flush();
    }

    // Depuración rápida
    static void dbg(Object o) {
        if (o == null) {
            System.err.println("null");
            return;
        }

        Class<?> c = o.getClass();

        if (c.isArray()) {
            if (c.getComponentType().isArray()) {
                // Arreglo 2D (o más)
                int len = Array.getLength(o);
                for (int i = 0; i < len; i++) {
                    Object fila = Array.get(o, i);
                    System.err.println(Arrays.deepToString(new Object[]{fila}));
                }
            } else {
                // Arreglo 1D
                int len = Array.getLength(o);
                Object[] tmp = new Object[len];
                for (int i = 0; i < len; i++) {
                    tmp[i] = Array.get(o, i);
                }
                System.err.println(Arrays.toString(tmp));
            }
        } else {
            System.err.println(o);
        }
    }

}