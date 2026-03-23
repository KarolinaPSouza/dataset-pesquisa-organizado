import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_14151639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long resultado;

            long max = Math.max(y, x);

            if (max % 2 == 1) { // Capa impar
                if (y == max) { // Lado derecho
                    resultado = (max - 1) * (max - 1) + x;
                } else { // Lado de abajo
                    resultado = max * max - (y - 1);
                }
            } else { // Capa par
                if (x == max) { // Lado de arriba
                    resultado = (max - 1) * (max - 1) + y;
                } else { // Lado izquierdo
                    resultado = max * max - (x - 1);
                }
            }
            pw.println(resultado);
        }

        pw.flush();
        pw.close();
        br.close();
    }
}