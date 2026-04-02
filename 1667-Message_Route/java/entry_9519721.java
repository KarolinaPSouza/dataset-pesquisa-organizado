import java.util.*;
import java.io.*;
public class entry_9519721 {

        public static void main(String[] args) throws Exception{

            _Scanner reader = new _Scanner(System.in);
            FastWriter writer = new FastWriter();

            int n = reader.nextInt();
            int m = reader.nextInt();

            ArrayList<AristaExt> aristas = new ArrayList<>();
            for(int i = 0; i < m; i++){

                int a = reader.nextInt();
                int b = reader.nextInt();

                AristaExt d = new AristaExt(a-1,b-1, 1);
                AristaExt d1 = new AristaExt(b-1,a-1, 1);
                aristas.add(d) ;
                aristas.add(d1) ;

            }
            GrafoListaAdy g = new GrafoListaAdy(n , aristas) ;

            try {

                int[] padres = g.caminoMConPesosPositivos(0 + "");
                if (padres[n - 1] == -1) {
                    throw new VerticeNoEncontradoException();
                }
                ArrayList<Integer> orden = new ArrayList<>();

                orden.add(n - 1);
                int ini = n - 1;

                while (padres[ini] != -1) {

                    orden.add(padres[ini]);
                    ini = padres[ini];
                }

                Collections.reverse(orden);
                writer.println(orden.size());
                for (int i = 0; i < orden.size(); i++) {
                    writer.print((orden.get(i) + 1) + " ");
                }
                writer.flush();

            } catch (VerticeNoEncontradoException e){
                writer.println("IMPOSSIBLE");
                writer.flush();
            }

        }


    static class _Scanner {
        InputStream is;

        _Scanner(InputStream is) {
            this.is = is;
        }

        byte[] bb = new byte[1 << 15];
        int k, l;

        byte getc() throws IOException {
            if (k >= l) {
                k = 0;
                l = is.read(bb);
                if (l < 0) return -1;
            }
            return bb[k++];
        }

        byte skip() throws IOException {
            byte b;
            while ((b = getc()) <= 32) ;
            return b;
        }

        int nextInt() throws IOException {
            int n = 0;
            for (byte b = skip(); b > 32; b = getc()) n = n * 10 + b - '0';
            return n;
        }

        float nextFloat() throws IOException {
            int integerPart = 0;
            float decimalPart = 0.0f;
            int divisor = 1;
            boolean isNegative = false;

            byte b = skip();
            if (b == '-') {
                isNegative = true;
                b = getc();
            }

            while ('0' <= b && b <= '9') {
                integerPart = integerPart * 10 + b - '0';
                b = getc();
            }

            if (b == '.') {
                b = getc();
                while ('0' <= b && b <= '9') {
                    decimalPart = decimalPart * 10 + b - '0';
                    divisor *= 10;
                    b = getc();
                }
            }

            float result = integerPart + decimalPart / divisor;
            return isNegative ? -result : result;
        }

        String nextString() throws IOException {
            StringBuilder sb = new StringBuilder();
            byte b = skip();
            while (b > 32) {
                sb.append((char) b);
                b = getc();
            }
            return sb.toString();
        }
    }
    static class FastWriter {
        BufferedWriter bw;

        public FastWriter() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object o) throws IOException {
            bw.write(o.toString());
        }

        public void println(Object o) throws IOException {
            print(o);
            bw.newLine();
        }

        public void flush() throws IOException {
            bw.flush();
        }

        public void close() throws IOException {
            bw.close();
        }
    }

        interface Grafo {
            /**
             * Inserta un nodo en el grafo, si no existe
             * @param nombre Este es el nombre del nodo
             * @return Retorna el id del nodo
             */
            int insVertice(String nombre);

            /**
             * Agrega una arista CON peso en el grafo
             * @param origen Este es el nodo origen de la arista
             * @param destino Este es el nodo final de la arista
             * @param peso Este es el peso de la arista
             */
            void insArista(String origen, String destino, float peso);

            /**
             * Agrega una arista SIN peso en el grafo
             * @param origen Este es el nodo origen de la arista
             * @param destino Este es el nodo final de la arista
             */
            void insArista(String origen, String destino);

            /**
             * Elimina un nodo del grafo
             * @param nombre Este es el nombre del grafo
             */
            void elimVertice(String nombre) throws VerticeNoEncontradoException;

            /**
             * Elimina una arista del grafo
             * @param origen Este es el nodo origen de la arista
             * @param destino Este es el nodo final de la arista
             */
            void elimArista(String origen, String destino) throws VerticeNoEncontradoException;

            /**
             * Busca el id de un vertice
             * @param nombre Este es el nombre del vertice
             * @return Retorna el id del vertice buscado
             */
            int buscar(String nombre) throws VerticeNoEncontradoException;


            String getNombre(int idNodo);

            /**
             * Comprueba que dos nodos estan unidos por una arista
             * @param origen Nodo origen
             * @param destino Nodo final
             * @return Retorna true si los nodos estan unidos por una arista. En caso contrario retorna falso.
             */
            boolean esAdyacente(String origen, String destino) throws VerticeNoEncontradoException;

            /**
             * Realiza un recorrido del primero a lo ancho, en el grafo
             * @param verticeOrigen Vertice donde comineza el recorrido
             * @return Retorna una lista con los ids de los vertices, en el orden en que se recorrieron
             */
            List recorridoAmplitud(String verticeOrigen) throws VerticeNoEncontradoException;

            /**
             * Realiza un recorrido del primero en profundidad, en el grafo
             * @param verticeOrigen Vertice donde comineza el recorrido
             * @return Retorna una lista con los ids de los vertices, en el orden en que se recorrieron
             */
            List recorridoProfundidad(String verticeOrigen) throws VerticeNoEncontradoException;

            //  float[] caminoMSinPesos(String verticeOrigen);

            int[] caminoMConPesosPositivosGrafoDenso(String verticeOrigen) throws VerticeNoEncontradoException;

            int[] caminoMConPesosPositivos(String verticeOrigen) throws VerticeNoEncontradoException;

            float[] caminoMConPesosNegativos(String verticeOrigen) throws VerticeNoEncontradoException, CicloNegativoException;

            float[] caminoMAciclico(String verticeOrigen) throws CicleDetectedException, VerticeNoEncontradoException;

            float arbolExpansionMinimoPrim();

            float arbolExpansionMinimoKruskal();
        }
        static class GrafoListaAdy implements Grafo {
            /* Constante que representa el valor infinito */
            private final static float INF = Float.MAX_VALUE;

            /* Cantidad de Vertices */
            private int cantVert;

            /* Lista de Adyacencia */
            private List<List<Arista>> adj;

            /* Lista de Nombres de los Nodos */
            private List<String> nombresVert;

            public GrafoListaAdy() {
                this.cantVert = 0;
                nombresVert = new ArrayList<>();
                adj = new ArrayList<>();
            }
            public GrafoListaAdy(int cn ,ArrayList<AristaExt> aristas) {
                this.cantVert = cn;
                this.nombresVert = new  ArrayList<>();
                this.adj = new ArrayList<>();
                for(int i = 0; i < cantVert; i++) {
                    nombresVert.add(i+"");
                    adj.add(new ArrayList<>());
                }
                for(AristaExt arista : aristas) {
                    this.adj.get(arista.getInicio()).add(new Arista(arista.getDestino() , arista.getPeso())) ;
                }
            }

            @Override
            public int buscar(String nombre) throws VerticeNoEncontradoException {
                int id = 0;
                for(String nodo: nombresVert){
                    if (nodo.equals(nombre))
                        return id;
                    id++;
                }
                throw new  VerticeNoEncontradoException();
            }

            @Override
            public int insVertice(String nombre) {
                try{
                    int id = buscar(nombre);
                    return id;
                } catch (VerticeNoEncontradoException e) {
                    nombresVert.add(nombre);
                    adj.add(new LinkedList<>());
                    cantVert++;
                    return cantVert - 1;
                }
            }

            @Override
            public void insArista(String origen, String destino, float peso) {
                int idOrigen = insVertice(origen);
                int idDestino = insVertice(destino);

                Arista arista = new Arista(idDestino, peso);

                adj.get(idOrigen).add(arista);
            }

            @Override
            public void insArista(String origen, String destino) {
                insArista(origen, destino, 1);
            }

            @Override
            public void elimVertice(String nombre) throws VerticeNoEncontradoException {
                int idNodo = buscar(nombre);
                List<String> tmpNombresVert = new ArrayList<>();
                List<List<Arista>> tmpAdj = new ArrayList<>();

                for (int i = 0; i < nombresVert.size(); i++) {
                    if (!nombre.equals(nombresVert.get(i))) {
                        tmpNombresVert.add(nombresVert.get(i));
                    }
                }
                nombresVert = tmpNombresVert;

                for (int i = 0; i < cantVert; i++) {
                    if (i != idNodo) {
                        tmpAdj.add(new LinkedList<>());

                        for (Arista arista: adj.get(i)){
                            int idDestino = arista.getDestino();

                            if (idDestino != idNodo){
                                if(idDestino >= idNodo){
                                    arista.setDestino(idDestino - 1);
                                }
                                tmpAdj.get(tmpAdj.size() - 1).add(arista);
                            }
                        }
                    }
                }
                adj = tmpAdj;
                cantVert--;
            }

            @Override
            public void elimArista(String origen, String destino) throws VerticeNoEncontradoException {
                int idOrigen = buscar(origen);
                int idDestino = buscar(destino);

                List<Arista> tmp = new LinkedList<>();
                Iterator it = adj.get(idOrigen).iterator();

                while (it.hasNext()) {
                    Arista arista = (Arista) it.next();

                    if (arista.getDestino() != idDestino)
                        tmp.add(arista);
                }
                adj.set(idOrigen, tmp);
            }

            @Override
            public boolean esAdyacente(String origen, String destino) throws VerticeNoEncontradoException {
                int idOrigen = buscar(origen);
                int idDestino = buscar(destino);

                for(Arista arista: adj.get(idOrigen)){
                    if (arista.getDestino() == idDestino)
                        return true;
                }
                return false;
            }

            @Override
            public List<Integer> recorridoAmplitud(String verticeOrigen) throws VerticeNoEncontradoException {
                int idOrigen = buscar(verticeOrigen);
                Queue<Integer> Q = new LinkedList<>();
                List<Integer> orden = new LinkedList<>();
                boolean[] marca = new boolean[cantVert];

                Q.add(idOrigen);
                marca[idOrigen] = true;
                while (!Q.isEmpty()) {
                    int nod = Q.remove();
                    orden.add(nod);

                    for (Arista arista: adj.get(nod)){
                        int idNuevoNodo = arista.getDestino();

                        if (!marca[idNuevoNodo]) {
                            marca[idNuevoNodo] = true;
                            Q.add(idNuevoNodo);
                        }
                    }
                }
                return orden;
            }

            @Override
            public List<Integer> recorridoProfundidad(String verticeOrigen) throws VerticeNoEncontradoException {
                boolean[] marca = new boolean[cantVert];
                List<Integer> orden = new LinkedList<>();

                recorridoProfundidadRecursivo(buscar(verticeOrigen), orden, marca);
                return orden;
            }


            private void recorridoProfundidadRecursivo(int idNodo, List<Integer> orden, boolean[] marca) {
                marca[idNodo] = true;
                orden.add(idNodo);

                for(Arista arista: adj.get(idNodo)){
                    int idNuevoNodo = arista.getDestino();

                    if (!marca[idNuevoNodo]) {
                        recorridoProfundidadRecursivo(idNuevoNodo, orden, marca);
                    }
                }
            }

            /**
             * Algoritmo de Dijkstra en O(|V|^2)
             * @param verticeOrigen Es el vertice desde donde se calculan los caminos minimos
             * @return Retorna un arreglo de tipo float con las distancias desde verticeOrigen hasta cada uno de los nodos.
             * @throws VerticeNoEncontradoException
             * Tested on: https://dmoj.uclv.cu/problem/bparty
             */
            @Override
            public int[] caminoMConPesosPositivosGrafoDenso(String verticeOrigen) throws VerticeNoEncontradoException {
                int idOrigen = buscar(verticeOrigen);
                float[] dist = new float[cantVert];
                boolean[] marca = new boolean[cantVert];
                int[] padres = new int[cantVert];

                for(int i=0; i < cantVert; i++)
                    dist[i] = INF;
                dist[idOrigen] = 0;

                for (int i=0; i < cantVert; i++){
                    int nod = -1;

                    for(int j=0; j < cantVert; j++){
                        if( !marca[j] && (nod == -1 || dist[j] < dist[nod]) )
                            nod = j;
                    }
                    marca[nod] = true;

                    for(Arista arista: adj.get(nod)){
                        int destino = arista.getDestino();
                        float peso = arista.getPeso();

                        if( dist[destino] > dist[nod] + peso ) {
                            dist[destino] = dist[nod] + peso;
                            padres[destino] = nod;
                        }
                    }
                }
                return padres;
            }

            @Override
            public int[] caminoMConPesosPositivos(String verticeOrigen) throws VerticeNoEncontradoException {
                int idOrigen = buscar(verticeOrigen);
                float[] dist = new float[cantVert];
                PriorityQueue<Camino> Q = new PriorityQueue<>();
                int[] padres = new int[cantVert];
                //padres[idOrigen] = -1;
                for(int i=0; i < cantVert; i++) {
                    dist[i] = INF;
                    dist[idOrigen] = 0;
                    padres[i] = -1;
                }
                Q.add(new Camino(idOrigen, 0f));
                while( !Q.isEmpty() ){
                    int nod = Q.peek().getDestino();

                    if( dist[nod] < Q.peek().getPeso() ){
                        Q.poll();
                        continue;
                    }
                    Q.poll();

                    for(Arista arista: adj.get(nod)){
                        int destino = arista.getDestino();
                        float peso = arista.getPeso();

                        if( dist[destino] > dist[nod] + peso ){
                            dist[destino] = dist[nod] + peso;
                            Q.add(new Camino(destino, dist[destino]));
                            padres[destino] = nod;
                        }
                    }
                }
                return padres;
            }

            int gradoSalida(String vertice) throws VerticeNoEncontradoException {
                int idNodo = buscar(vertice);

                return adj.get(idNodo).size();
            }

            int gradoEntrada(String vertice) throws VerticeNoEncontradoException {
                int idNodo = buscar(vertice);

                int grado = 0;
                for(int i=0; i < cantVert; i++){
                    for(Arista arista: adj.get(i)){
                        if( arista.getDestino() == idNodo )
                            grado++;
                    }
                }
                return grado;
            }

            @Override
            public float[] caminoMConPesosNegativos(String verticeOrigen) throws VerticeNoEncontradoException, CicloNegativoException {
                int idOrigen = buscar(verticeOrigen);
                float[] dist = new float[cantVert];

                for(int i=0; i < cantVert; i++)
                    dist[i] = INF;
                dist[idOrigen] = 0;

                for(int fase=1; fase<=cantVert; fase++){
                    for(int nodo=0; nodo < cantVert; nodo++){
                        for(Arista arista: adj.get(nodo)){
                            int destino = arista.getDestino();
                            float peso = arista.getPeso();

                            if( dist[destino] > dist[nodo] + peso ){
                                dist[destino] = dist[nodo] + peso;

                                if( fase == cantVert )
                                    throw new CicloNegativoException();
                            }
                        }
                    }
                }
                return dist;
            }

            public List<Integer> ordenTopologico() throws CicleDetectedException {
                int[] grado = new int[cantVert];
                boolean[] marca = new boolean[cantVert];

                for(int nod=0; nod < cantVert; nod++)
                    for(Arista arista: adj.get(nod))
                        grado[arista.getDestino()]++;

                Queue<Integer> Q = new LinkedList<>();
                for(int nod=0; nod < cantVert; nod++)
                    if( grado[nod] == 0 )
                        Q.add(nod);

                List<Integer> orden = new ArrayList<>();
                while( !Q.isEmpty() ){
                    int nod = Q.poll();
                    orden.add(nod);

                    marca[nod] = true;
                    for(Arista arista: adj.get(nod)){
                        int destino = arista.getDestino();
                        grado[destino]--;

                        if( grado[destino] == 0 && !marca[destino] )
                            Q.add(destino);
                    }
                }

                if( orden.size() != cantVert )
                    throw new CicleDetectedException();

                return orden;
            }

            @Override
            public float[] caminoMAciclico(String verticeOrigen) throws CicleDetectedException, VerticeNoEncontradoException {
                int idOrigen = buscar(verticeOrigen);
                float[] dist = new float[cantVert];

                for(int i=0; i < cantVert; i++)
                    dist[i] = INF;
                dist[idOrigen] = 0;

                List<Integer> orden = ordenTopologico();
                for(Integer nod: orden){
                    for(Arista arista: adj.get(nod)){
                        int destino = arista.getDestino();
                        float peso = arista.getPeso();

                        if( dist[destino] > dist[nod] + peso )
                            dist[destino] = dist[nod] + peso;
                    }
                }
                return dist;
            }

            public long[] cantCaminosGrafoDirigidoSinCiclos(String verticeOrigen) throws VerticeNoEncontradoException, CicleDetectedException {
                int idOrigen = buscar(verticeOrigen);
                long[] cant = new long[cantVert];

        /* En aristasEnt vamos a guardar, para cada nodo, una lista de los nodos desde
        los que se puede llegar a este. No hace falta guardar la arista completa */
                List<List<Integer>> aristasEnt = new ArrayList<>();
                for(int i=0; i < cantVert; i++)
                    aristasEnt.add(new ArrayList<>());

                for(int nodo=0; nodo < cantVert; nodo++)
                    for(Arista arista: adj.get(nodo))
                        aristasEnt.get(arista.getDestino()).add(nodo);

                cant[idOrigen] = 1;
                List<Integer> orden = ordenTopologico();

                for(Integer nodo: orden){
                    for(Integer nodoAnterior: aristasEnt.get(nodo))
                        cant[nodo] += cant[nodoAnterior];
                }

                return cant;
            }

            public String getNombre(int idNodo) {
                return nombresVert.get(idNodo);
            }

            public int getCantVert() {
                return cantVert;
            }

            public List<List<Arista>> getAdj() {
                return adj;
            }

            public List<String> getNombresVert() {
                return nombresVert;
            }

            @Override
            public float arbolExpansionMinimoPrim() {
                return 0;
            }

            @Override
            public float arbolExpansionMinimoKruskal() {
                List<AristaExt> listaAristas = new ArrayList<>();

                for (int nod=0; nod < cantVert; nod++){
                    for(Arista arista: adj.get(nod)){
                        listaAristas.add(new AristaExt(nod, arista.getDestino(), arista.getPeso()));
                    }
                }

                Collections.sort(listaAristas);
                ConjuntoDisjunto S = new ConjuntoDisjunto(cantVert);

                float mst = 0.0f;
                for(AristaExt arista: listaAristas){
                    int conjIni = S.buscarConjunto(arista.getInicio());
                    int conjDest = S.buscarConjunto(arista.getDestino());

                    if( conjIni != conjDest ){
                        mst += arista.getPeso();

                        S.unirConjuntos(conjIni, conjDest);
                    }
                }
                return mst;
            }

            /* Helper Method */
            public void imprimirListaAdyacencia(){
                for(int i=0; i < cantVert; i++){
                    System.out.printf("%s (%d) => ", nombresVert.get(i), i);

                    for(Arista arista: adj.get(i)){
                        int destino = arista.getDestino();
                        System.out.printf("%s (%d) | ",     nombresVert.get(destino), destino);
                    }
                    System.out.println();
                }
            }
        }


        static class Arista {
            protected int destino;
            protected float peso;

            public Arista(int destino, float peso) {
                this.destino = destino;
                this.peso = peso;
            }

            public int getDestino() {
                return destino;
            }

            public void setDestino(int destino) {
                this.destino = destino;
            }

            public float getPeso() {
                return peso;
            }

            public void setPeso(float peso) {
                this.peso = peso;
            }
        }
        static class AristaExt extends Arista implements Comparable<AristaExt>{
            private final static float EPS = 1e-9f;

            private int inicio;

            public AristaExt(int inicio, int destino, float peso) {
                super(destino, peso);
                this.inicio = inicio;
            }

            public int getInicio() {
                return inicio;
            }

            @Override
            public int compareTo(AristaExt otro) {
                if( Math.abs(this.peso - otro.peso) < EPS )
                    return 0;
                else if( this.peso < otro.peso )
                    return -1;
                else
                    return 1;
            }
        }

        static class Camino implements Comparable<Camino>{
            private final static float EPS = 1e-9f;

            private int destino;
            private float peso;

            public Camino(int destino, float peso) {
                this.destino = destino;
                this.peso = peso;
            }

            @Override
            public int compareTo(Camino camino) {
                if( Math.abs(this.peso - camino.peso) < EPS )
                    return 0;
                else if( this.peso < camino.peso )
                    return -1;
                else
                    return 1;
            }

            public int getDestino() {
                return destino;
            }

            public float getPeso() {
                return peso;
            }
        }
        static class ConjuntoDisjunto {
            private int[] padre, rango;

            public ConjuntoDisjunto(int cantConjuntos) {
                padre = new int[cantConjuntos];
                rango = new int[cantConjuntos];

                for(int i=0; i < cantConjuntos; i++){
                    padre[i] = i;
                    rango[i] = 1;
                }
            }

            public int buscarConjunto(int nod) {
                if( padre[nod] != nod )
                    return padre[nod] = buscarConjunto(padre[nod]);
                return nod;
            }

            public void unirConjuntos(int a, int b) {
                if( rango[a] > rango[b] ){
                    padre[b] = a;
                    rango[a]++;
                }
                else{
                    padre[a] = b;
                    rango[b]++;
                }
            }
        }

        static class CicleDetectedException extends Exception {
        }

        static class CicloNegativoException extends Exception {
        }
        static class VerticeNoEncontradoException extends Exception {
        }






}