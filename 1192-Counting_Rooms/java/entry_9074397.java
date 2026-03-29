import java.util.Scanner;

public class entry_9074397 {

    static final char AR = '.'; // Representação de espaço vazio
    static final char QUEIJO = '#'; // Representação de queijo
    static int n, m; // Altura e largura da matriz
    static char[][] matriz; // Matriz representando a fatia de queijo
    static boolean[][] visitado; // Matriz para marcar células visitadas durante a DFS
    static int buracos; // Contador de buracos

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // Lê a altura da matriz
        m = sc.nextInt(); // Lê a largura da matriz

        matriz = new char[n][m]; // Inicializa a matriz
        visitado = new boolean[n][m]; // Inicializa a matriz de visitados

        // Lê a matriz
        for (int i = 0; i < n; i++) {
            String linha = sc.next();
            for (int j = 0; j < m; j++) {
                matriz[i][j] = linha.charAt(j);
            }
        }

        // Inicializa o contador de buracos
        buracos = 0;

        // Percorre a matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visitado[i][j] && matriz[i][j] == AR) { // Se a célula não foi visitada e é um espaço vazio
                    buracos++; // Incrementa o contador de buracos
                    dfs(i, j); // Executa a DFS a partir dessa célula
                }
            }
        }

        System.out.println(buracos); // Imprime o número de buracos
    }

    // Função DFS para explorar os buracos
    static void dfs(int i, int j) {
        // Verifica se a célula está dentro dos limites da matriz e se é um espaço vazio não visitado
        if (i < 0 || i >= n || j < 0 || j >= m || visitado[i][j] || matriz[i][j] == QUEIJO) {
            return;
        }

        visitado[i][j] = true; // Marca a célula como visitada

        // Executa a DFS nas células adjacentes (cima, baixo, esquerda, direita)
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}