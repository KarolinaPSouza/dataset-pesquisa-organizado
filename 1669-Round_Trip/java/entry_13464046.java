import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class entry_13464046 {
    static int numNodos, numAristas;
    static List<List<Integer>> grafo;
    static boolean[] visitado;
    static int[] padre;
    static int inicioCiclo = -1, finCiclo = -1;

    public static void main(String[] args) throws IOException {

     BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter o = new PrintWriter(System.out);
        StringTokenizer st;
        st = new StringTokenizer(x.readLine());

        numNodos = Integer.parseInt(st.nextToken());
        numAristas = Integer.parseInt(st.nextToken());

        grafo = new ArrayList<>();
        for (int i = 0; i <= numNodos; i++) grafo.add(new ArrayList<>());

        visitado = new boolean[numNodos + 1];
        padre = new int[numNodos + 1];

        for (int i = 0; i < numAristas; i++) {
         st = new StringTokenizer(x.readLine());
            int desde = Integer.parseInt(st.nextToken());
            int hasta = Integer.parseInt(st.nextToken());
            grafo.get(desde).add(hasta);
            grafo.get(hasta).add(desde);
        }

        for (int nodo = 1; nodo <= numNodos; nodo++) {
            if (!visitado[nodo] && dfs(nodo, -1)) break;
        }

        if (inicioCiclo == -1) {
            o.println("IMPOSSIBLE");
        } else {
            List<Integer> ciclo = new ArrayList<>();
            for (int actual = finCiclo; actual != inicioCiclo; actual = padre[actual]) {
                ciclo.add(actual);
            }
            ciclo.add(inicioCiclo);
            ciclo.add(finCiclo);
            o.println(ciclo.size());
            for (int nodo : ciclo) o.print(nodo + " ");
        }
        o.flush();
    }

    static boolean dfs(int actual, int anterior) {
        visitado[actual] = true;
        for (int vecino : grafo.get(actual)) {
            if (vecino == anterior) continue;
            if (visitado[vecino]) {
                inicioCiclo = vecino;
                finCiclo = actual;
                return true;
            }
            padre[vecino] = actual;
            if (dfs(vecino, actual)) return true;
        }
        return false;
    }
}