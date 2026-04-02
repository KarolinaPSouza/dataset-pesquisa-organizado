import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_14861906 {
 // FastReader class for efficient input
    static class FastReader {
        // BufferedReader to read input
        BufferedReader b;
        // StringTokenizer to tokenize input
        StringTokenizer s; 
        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }
        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }
        // Method to read the next token as an integer
        int nextInt() { 
            return Integer.parseInt(next()); 
        }
        // Method to read the next token as a long
        long nextLong() { 
            return Long.parseLong(next()); 
        }
        // Method to read the next token as a double
        double nextDouble() { 
            return Double.parseDouble(next()); 
        }
        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            return str;
        }
    }
 public static void run() {
  /* Descricao do problema:
  Você recebe um array de n inteiros, 
  e a sua tarefa é encontrar dois valores (em posições distintas) 
  cuja soma seja igual a x.*/
  // Entrada
  FastReader sc = new FastReader();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        // Solucao
  HashMap<Integer, Integer> mapa = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int falta = x - a[i];
            if (mapa.containsKey(falta)) {
                System.out.println(mapa.get(falta) + " " + (i + 1));
                return;
            }
            mapa.put(a[i], i + 1);
        }
        System.out.println("IMPOSSIBLE");
    }
    public static void main(String[] args) {
        run();
    }
}