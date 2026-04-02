// package sorting_searching.sum_of_four;

import java.util.*;

class Pair {
    public int f;
    public int s;

    public Pair(int x, int y) {
        f = x;
        s = y;
    }

}

public class entry_11140010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        long x;
        n = sc.nextInt();
        x = sc.nextLong();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        HashMap<Integer, ArrayList<Pair>> hp = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = a[i] + a[j];
                if (sum < x) {
                    Pair obj = new Pair(i, j);
                    ArrayList<Pair> list;
                    if (hp.containsKey(sum)) {
                        list = hp.get(sum);
                    } else {
                        list = new ArrayList<>();
                    }
                    list.add(obj);
                    hp.put(sum, list);
                }
            }
        }
        ArrayList<Integer> find = new ArrayList<>();
        for (Integer key : hp.keySet()) {
            int val = (hp.get(key)).size();
            while (val > 0) {
                find.add(key);
                val--;
            }
        }

        Collections.sort(find);
        int i = 0;
        int j = find.size() - 1;
        int sum = 0;
        int b = -1, c = -1;
        boolean found = false;
        while (i <= j) {
            sum = find.get(i) + find.get(j);
            if (sum == x) {
                b = find.get(i);
                c = find.get(j);
                found = true;
                break;
            } else if (sum > x) {
                j--;
            } else {
                i++;
            }
        }
        // System.out.println(found);
        // System.out.println(b + " " + c);
        if (found) {
            // for (Integer ch : find) {
            // System.out.print(ch + " ");
            // }

            // System.out.println();
            ArrayList<Pair> l1 = hp.get(b);
            ArrayList<Pair> l2 = hp.get(c);
            found = false;
            for (Pair obj : l1) {
                long a1 = obj.f;
                long b1 = obj.s;
                // System.out.println(a1 + " " + b1);
                for (Pair obj2 : l2) {
                    long c1 = obj2.f;
                    long d1 = obj2.s;
                    if (a1 != c1 && a1 != d1 && b1 != c1 && b1 != d1) {
                        System.out.println((a1 + 1) + " " + (b1 + 1) + " " + (c1 + 1) + " " + (d1 +
                                1));
                        found = true;
                        break;
                    }
                }
                if (found)
                    break;
            }

        }
        if (!found)
            System.out.println("IMPOSSIBLE");
    }
}