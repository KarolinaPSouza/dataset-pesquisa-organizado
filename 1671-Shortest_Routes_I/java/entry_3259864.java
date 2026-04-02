/* 
    Ejercicio02: Shortest Routes I
     Descripción: Existen n ciudades y m vuelos entre ellas,
    debemos de buscar la longitud minima de la desde Syrjälä
    a cada ciudad
 */

import java.util.*;
import java.io.*;

public class entry_3259864 {
    static class Path {
        int end, weight;
        Path(int end, int weight) {
            this.end = end; this.weight = weight;
        }
    }
    static ArrayList[] all;
    static long[] dd;
    static final long INF = 0x3f3f3f3f3f3f3f3fL;

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
                l = is.read(bb); //if (l < 0) return -1;
            }
            return bb[k++];
        }
        byte skip() throws IOException {
            byte b;
            while ((b = getc()) <= 32)
                ;
            return b;
        }
        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (byte b = skip(); b > 32; b = getc())
                sb.append((char) b);
            return sb.toString();
        }
        int nextInt() throws IOException {
            int n = 0;
            for (byte b = skip(); b > 32; b = getc())
                n = n * 10 + b - '0';
            return n;
        }
    }

    public static void main(String[] args) throws IOException{
        _Scanner s = new _Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        all = new ArrayList[n];

        for(int i = 0; i < n; i++) 
            all[i] = new ArrayList<Path>();

        while(m-- > 0) {
            int i = s.nextInt() - 1;
            int e = s.nextInt() - 1;
            int w = s.nextInt();
            all[i].add(new Path(e, w));
        }

        dd = new long[n];
        Arrays.fill(dd, INF);
        dd[0] = 0;

        TreeSet<Integer> pq = new TreeSet<>((i, e) -> dd[i] == dd[e]? i - e: dd[i] < dd[e] ? -1 : 1);
        pq.add(0);
        Integer j;

        while((j = pq.pollFirst()) != null) {
            int i = j;
            ArrayList<Path> adj = all[i];
            for(Path p : adj) {
                long d = dd[i] + p.weight;
                if(dd[p.end] > d) {
                    if(dd[p.end] != INF)
                        pq.remove(p.end);
                    dd[p.end] = d;
                    pq.add(p.end);
                }
            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(dd[i] + " ");
        System.out.println();
    }
}