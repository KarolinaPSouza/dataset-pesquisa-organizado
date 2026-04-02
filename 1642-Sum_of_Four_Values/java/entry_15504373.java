import java.io.*;
import java.util.*;

public class entry_15504373 {

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


    public static class Elemento {

        int index;
        long value;

        public Elemento(int index, long value) {
            this.index = index;
            this.value = value;
        }

    }

    public static class Par {

        int uno, dos;

        public Par (int uno, int dos) {
            this.uno = uno;
            this.dos = dos;
        }

    }

    public static void main(String[] args) {
        ///////////////////////////////////////

        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int x = in.nextInt();
        Elemento[] arr = new Elemento[n+1];// 1-based
        HashMap<Long,ArrayList<Par>> sumas = new HashMap();// hash entre valores e índices donde aparece el valor
        for (int i=1; i<=n; i++) {
            long value = in.nextInt();
            arr[i] = new Elemento(i,value);
        }

        // genero todas las sumas posibles de dos números y guardo sus respectivos pares de índices
        // en O(n^2) ya que n<=1000
        for (int i=1; i<=n; i++) {
            for (int j=i+1; j<=n; j++) {
                long sum = arr[i].value + arr[j].value;
                if (!sumas.containsKey(sum)) sumas.put(sum,new ArrayList<>());
                sumas.get(sum).add(new Par(i,j));
            }
        }

        for (int uno=1; uno<=n; uno++) {// O(n^2) ya que n<=1000
            for (int dos=uno+1; dos<=n; dos++) {

                long restante = x - (arr[uno].value + arr[dos].value);
                if (sumas.containsKey(restante)) {
                    ArrayList<Par> pares = sumas.get(restante);
                    for (int i=0; i<pares.size(); i++) {
                        Par parActual = pares.get(i);
                        if (parActual.uno != uno && parActual.uno != dos && parActual.dos != uno && parActual.dos != dos) {
                            out.println(uno + " " + dos + " " + parActual.uno + " " + parActual.dos);
                            out.flush();
                            return;
                        }
                    }
                }

            }
        }
        out.println("IMPOSSIBLE");





        ///////////////////////////////////////
        out.flush();
    }

    // Depuración rápida
    static void dbg(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }
}