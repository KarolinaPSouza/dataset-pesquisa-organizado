import java.io.*;
import java.util.*;
import java.lang.reflect.Array;

public class entry_15820349 {

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


    public static void main(String[] args) {
        ///////////////////////////////////////

        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = in.nextLong();
        int k = in.nextInt();
        long[] primes = new long[k+1];// 1-based
        for (int i=1; i<=k; i++) {
            primes[i] = in.nextLong();
        }

        long res = 0;
        for (int mask=1; mask<(1<<k); mask++) {// todas las combinaciones de primos de la lista
            long cantPrimosSeleccionados = 0;
            long prodPrimos = 1;
            boolean divide = true;
            for (int i=0; i<k; i++) {// recorro la lista de primos quedándome con los que se seleccionan en esta cobinación dada por la mask actual
                if ((mask & (1<<i)) > 0) {// si es que se usa el i'ésimo primo en la combinación dada mask
                    cantPrimosSeleccionados++;
                    if (prodPrimos > n / primes[i+1]) {// en realidad sería prodPrimos * primes[j] > n (el número
                                            // prodPrimos * primes[j] ya no puede ser divisor de n), pero n es 1e18, 
                                            // entonces el producto puede pasar de long
                        divide = false;
                    }
                    prodPrimos *= primes[i+1];
                }
            }

            if (!divide) continue;

            // la contribución del valor prodPrimos es floor(n/prodPrimos) (prodPrimos es divisor de n/prodPrimos 
            // números de entre 1 y n)
            if ((cantPrimosSeleccionados & 1) > 0) {
                res += n / prodPrimos;
            } else {
                res -= n / prodPrimos;
            }
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