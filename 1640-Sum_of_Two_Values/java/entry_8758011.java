import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Mapp implements Comparable<Mapp> {

    private int v;
    private int i;

    public Mapp(int v, int i) {
        this.v = v;
        this.i = i;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public int compareTo(Mapp o) {
        if (this.v < o.v) {
            return -1;
        } else if (this.v > o.v) {
            return 1;
        } else {
            return 0;
        }
    }

}

public class entry_8758011 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        List<Integer> lista = new ArrayList<>();
        Stream.of(bf.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(i -> lista.add(i));
        // int[] a = Arrays.stream(bf.readLine().split(" "))
        // .mapToInt(Integer::parseInt)
        // .toArray();

        Map<Integer, Integer> map = new HashMap<>();
        // map.put(a[0], 1);
        for (int i = 0; i < n; ++i) {
            if (map.containsKey(x - lista.get(i))) {
                System.out.println((i + 1) + " " + map.get(x - lista.get(i)));
                return;
            }
            map.put(lista.get(i), i + 1);
        }
        System.out.println("IMPOSSIBLE");
    }
}