
import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class entry_12050988 {
    static int[][] adj;
    static int[] dist;
    static int n;

    // Realiza el recorrido DFS desde el nodo indicado
    public static void dfsTranverse(int start) {
        // Marcamos todos los nodos como no visitados
        Arrays.fill(dist, -1); 

        // Inicializamos el nodo de inicio
        dist[start] = 0;

        // asamos ana pila para simalar el recorrido DFS
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        // Recorremos el grafo. Mientras haya nodos en la pila seguimos recorriendo.
        while (!stack.isEmpty()) {   // Mientras la pila no este vacia
            int node = stack.pop();  // Saca el nodo de la pila y lo evalua
            for (int child : adj[node]) {  // Recorre cada nodo adyacente
                if (dist[child] == -1) {   // Si el nodo no se ha visitado
                    dist[child] = dist[node] + 1; // Aumenta la distancia del nodo entre el nodo inicial y el evaluado 
                    stack.push(child); // Empuja a la plia el nodo evaluado para visitar sus nodos asyacentes
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(System.out));

        // Leer el numero de nodos
        n = Integer.parseInt(read.readLine());


        adj = new int[n + 1][];   // Matriz de adyacencia. Maestra los nodos con los qae se relaciona
        dist = new int[n + 1];   // Distancia de an nodo a los demas

        // Inicializar el grado de los nodos y las aristas.
        int[] degree = new int[n + 1];   // Almacena el namero de nodos con los qae se relaciona
        int[][] edges = new int[2 * (n - 1)][2];   // Almacena cada ano de los pares qae difenen las aristas


        // Lee las aristas y las almacena en forma de par en la matriz edges de 2*(n-1)x2 filas y 2 colamnas
        for (int i = 0, idx = 0; i < n - 1; i++) 
        {
            String[] s = read.readLine().split(" "); // Lee los nodos que conforman la arista
            int a = Integer.parseInt(s[0]); // Nodo a
            int b = Integer.parseInt(s[1]); // Nodo b

            // Almacenar las aristas en ambas direcciones.
            edges[idx][0] = a;
            edges[idx][1] = b;
            idx++;
            edges[idx][0] = b;
            edges[idx][1] = a;
            idx++;

            // Incrementar el grado o nameor de nodos con los que se relaciona
            degree[a]++; // Aumento dle grado del nodo a
            degree[b]++; // Aumento del grado del nodo b
        }

        // Constrair la matriz de adyacencia.
        for (int i = 1; i <= n; i++) {
            adj[i] = new int[degree[i]]; // Cada fila de la matriz tiene el tamaño del grado del nodo
            degree[i] = 0; // Reinicia el grado
        }

        // Llenar la lista de adyacencia.
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1]; //Definicion de los elementos del par arista  x-->y
            adj[a][degree[a]++] = b;   // Almacena el nodo a en la lista de adyacencia en la posicion conforme aamenta el grado del nodo a
        }

        // Primer recorrido DFS desde el nodo 1 para encontrar el nodo mas lejano del nodo raiz
        dfsTranverse(1);

        // Encontrar el nodo mas lejano al nodo 1
        int farthestNode = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[farthestNode]) {
                farthestNode = i;
            }
        }

        // Segundo recorrido DFS desde el nodo mas lejano.
        dfsTranverse(farthestNode);

        // Encontrar la distancia máxima.
        int maxDistancia = 0;
        for (int i = 1; i <= n; i++) {
            maxDistancia = Math.max(maxDistancia, dist[i]);
        }


        // Imprimir el resaltado y cerrar los flajos.
        escritor.write(maxDistancia + "\n");
        escritor.flush(); escritor.close(); read.close();
    }
}