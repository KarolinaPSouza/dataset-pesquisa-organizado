import java.io.*;
import java.util.*;

public class entry_14810035 {

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

    private static <T> ArrayList<ArrayList<T>> vvt(int n, int m, T value) {
        ArrayList<ArrayList<T>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<T> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(value);
            }
            res.add(row);
        }
        return res;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    static class Fila {
        int from;
        int to;
        int dinero;

        // Constructor
        public Fila(int valor1, int valor2, int valor3) {
            this.from = valor1;
            this.to = valor2;
            this.dinero = valor3;
        }
    }

    public static void main(String[] args) {
        ///////////////////////////////////////

        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        ArrayList<Fila> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int dinero = in.nextInt();
            arr.add(new Fila(from, to, dinero));
        }

        Collections.sort(arr, new Comparator<Fila>() {
            @Override
            public int compare(Fila f1, Fila f2) {
                return Integer.compare(f1.to, f2.to);// ordenado ascendente en tiempo de finalización (to)
            }
        });

        long dp[] = new long[n];

        for (int i=0; i<n; i++) {
            // busco el índice del último que termina antes de que empiece la actividad i-'esima
            int a=0, b=n;
            int res = -1;
            while (a<=b) {
                int mid = (a+b)/2;
                if (arr.get(mid).to < arr.get(i).from) {// al parecer con "You can only attend one project during a day" se 
                                                        // refieren a que no solo no se solapan, sino que una no puede iniciar 
                                                        // justo cuando otra termina
                    res = mid;
                    a = mid+1;
                } else {
                    b = mid-1;
                }
            }
            // Caso en que no se toma el proyecto actial (conservamos el monto ganado hasta la actividad i-1)
            long notake = 0;
            if (i>0) notake = dp[i-1];
            // Caso en que se toma el proyecto actual (pasamos desde el proyecto res (último en terminar previo al inicio 
            // del proyecto actual i) al actual i)
            long take = arr.get(i).dinero;
            if (res >= 0) take += dp[res];

            dp[i] = Math.max(take, notake);

        }

        out.println(dp[n-1]);





        ///////////////////////////////////////
        out.flush();
    }

    // Depuración rápida
    static void dbg(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }
}