import java.io.*;
import java.util.*;

public class entry_13590261 {
    static class Arista {
        int desde, hacia;
        long peso;
        Arista(int desde, int hacia, long peso) {
            this.desde = desde;
            this.hacia = hacia;
            this.peso = peso;
        }
    }

    static int nodos, aristas;
    static List<Arista> listaAristas = new ArrayList<>();
    static long[] distancia;
    static int[] anterior;
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter salida = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(lector.readLine());

        nodos = Integer.parseInt(st.nextToken());
        aristas = Integer.parseInt(st.nextToken());

        distancia = new long[nodos + 1];
        anterior = new int[nodos + 1];
        Arrays.fill(distancia, 0);      // todos inician desde 0
        Arrays.fill(anterior, -1);

        for (int i = 0; i < aristas; i++) {
            st = new StringTokenizer(lector.readLine());
            int desde = Integer.parseInt(st.nextToken());
            int hacia = Integer.parseInt(st.nextToken());
            long peso = Long.parseLong(st.nextToken());
            listaAristas.add(new Arista(desde, hacia, peso));
        }

        int cicloInicio = -1;
        for (int i = 0; i < nodos; i++) {
            cicloInicio = -1;
            for (Arista a : listaAristas) {
                if (distancia[a.desde] + a.peso < distancia[a.hacia]) {
                    distancia[a.hacia] = distancia[a.desde] + a.peso;
                    anterior[a.hacia] = a.desde;
                    cicloInicio = a.hacia;
                }
            }
        }

        if (cicloInicio == -1) {
            salida.println("NO");
        } else {

            for (int i = 0; i < nodos; i++) {
                cicloInicio = anterior[cicloInicio];
            }

            List<Integer> ciclo = new ArrayList<>();
            int actual = cicloInicio;
            Set<Integer> visitados = new HashSet<>();

            while (!visitados.contains(actual)) {
                ciclo.add(actual);
                visitados.add(actual);
                actual = anterior[actual];
            }

            List<Integer> cicloFinal = new ArrayList<>();
            cicloFinal.add(actual);
            int temp = anterior[actual];
            while (temp != actual) {
                cicloFinal.add(temp);
                temp = anterior[temp];
            }
            cicloFinal.add(actual);
            Collections.reverse(cicloFinal);

            salida.println("YES");
            for (int nodo : cicloFinal) {
                salida.print(nodo + " ");
            }
            salida.println();
        }
        salida.flush();
    }
}