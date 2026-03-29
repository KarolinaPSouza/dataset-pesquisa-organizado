import java.io.*;
import java.util.*;

public class entry_15270694 {

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


    public static class Edge {
        int u, v;
        long w;
        public Edge (int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        ///////////////////////////////////////

        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i=0; i<m; i++) {
            edges.add(new Edge(in.nextInt(), in.nextInt(), in.nextLong()));
        }

        int[] padre = new int[n+1];// 1-based
        Arrays.fill(padre, -1);

        long[] distancia = new long[n+1];// 1-based
        Arrays.fill(distancia, 0);// hago que todos los nodos sean alcanzables desde cualquier otro, ya que para los fines del 
                                       // problema solo importa que se pueda seguir relajando luego de n iteraciones (el problema 
                                       // no garantiza que el grafo sea conexo, y si empiezo de, por ejemplo, el nodo 1, distancias 
                                       // Long.MAX_VALUE para u!=1 y distancia[1]=0, puede haber un ciclo negativo en otra componente 
                                       // conexa y nunca alcanzarlo)

        int x = -1;
        for (int i=0; i<n; i++) {// relajamos n veces, si es que en la n-ésima x==-1, hubo modificación en el ciclo n -> ciclo negativo
            x = -1;
            for (Edge e : edges) {
                int u = e.u;
                int v = e.v;
                long w = e.w;
                if (distancia[v] > distancia[u] + w) {// se puede relajar a través de u
                    distancia[v] = distancia[u] + w;
                    x = v;
                    padre[v] = u;
                }
            }
        }

        if (x == -1) {
            out.println("NO");
        } else {
            out.println("YES");

            // nos aseguramos de estar en el ciclo y no estar en un nodo externo que fue afectado por la disminución en la distancia 
            // de alguno de los nodos del ciclo
            // cualquier camino simple en un grafo de V vértices tiene a lo sumo V-1 aristas -> al retroceder V veces hacia los padres 
            // estaremos en el ciclo (el padre de un nodo del ciclo siempre estará en el ciclo, ya que este sigue disminuyendo su 
            // distancia solo a través de nodos del ciclo)
            for (int i=0; i<n; i++) {
                x = padre[x];
            }

            // encontramos el ciclo al hallar dos veces el nodo x (al recorrer los padres la lista quedará invertida)
            int cantX = 0;
            int ini = x;
            ArrayList<Integer> res = new ArrayList<>();
            while (cantX < 2) {
                res.add(x);
                if (x == ini) cantX++;
                x = padre[x];
            }
            // imprimimos el ciclo en su orden original
            for (int i=res.size()-1; i>=0; i--) {
                out.print(res.get(i));
                if (i>0) out.print(" ");
            }

        }





        ///////////////////////////////////////
        out.flush();
    }

    // Depuración rápida
    static void dbg(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }
}