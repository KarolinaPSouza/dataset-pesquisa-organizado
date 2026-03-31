import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Pair {
    int time, status;

    Pair(int time, int status) {
        this.time = time;
        this.status = status;
    }
}

class PairComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair lhs, Pair rhs) {
        if (lhs.time == rhs.time) {
            return rhs.status - lhs.status;
        }
        return lhs.time - rhs.time;
    }
}

public class entry_11017321 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new Pair(l, 1));
            list.add(new Pair(r, -1));
        }


        Collections.sort(list, new PairComparator());

        int ans = 0;
        int cur = 0;
        for (Pair p : list) {
            cur += p.status;
            ans = Math.max(ans, cur);
        }

        System.out.println(ans);
    }
}