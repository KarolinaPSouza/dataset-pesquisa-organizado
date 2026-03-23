
import java.io.*;
import java.util.*;
public class entry_12121784 {

    static List<Integer>[] arbol;
    static int nodoPadre;
    static int maximaDistancia;
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            arbol = new ArrayList[n + 1];

            Arrays.setAll(arbol, i -> new ArrayList<>());

            for (int i = 0; i < n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arbol[a].add(b);
                arbol[b].add(a);
            }

        bfs(1);

        bfs(nodoPadre);
        System.out.println(maximaDistancia);
    }

    static void bfs(int inicio) {
        Queue<Integer> cola = new LinkedList<>();
        boolean[] visto = new boolean[arbol.length];

        int[] distancia = new int[arbol.length];

        cola.add(inicio);

        visto[inicio] = true;
        maximaDistancia = 0;

        while (!cola.isEmpty()) {

                int nodo = cola.poll();
                for (int vecino : arbol[nodo]) {

                    if (!visto[vecino]) {
                        visto[vecino] = true;
                        distancia[vecino] = distancia[nodo] + 1;
                        cola.add(vecino);

                        if (distancia[vecino] > maximaDistancia) {
                            maximaDistancia = distancia[vecino];

                            nodoPadre = vecino;


                        }

                    }
                }
        }



    }
}