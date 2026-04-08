import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class entry_6961440 {

    static InputStream in = new BufferedInputStream(System.in);
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static int nextInt() {
        int r = 0;
        try {
            int c = in.read();
            while (c < '0' || c > '9') c = in.read();
            while (c >= '0' && c <= '9') {
                r = r * 10 + (c - '0');
                c = in.read();
            }

        } catch (Exception e) {
            // ignore
        }
        return r;
    }

    static class Pair{
        long start;
        long end;
        public Pair(long start, long end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();

        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int a = nextInt();
            int b = nextInt();
            list.add(new Pair(a, b));
        }

        long [] each_people_end = new long [k];
        for(int i = 0; i < k; i++){
            each_people_end[i] = 0;
        }

        Collections.sort(list, (a, b) -> {
            if (a.end == b.end) {
                return Long.compare(a.start, b.start);
            }
            return Long.compare(a.end, b.end);
        });

        long cnt = 0;

        TreeSet<Pair> candidates = new TreeSet<>((a, b) -> {
            if (a.end == b.end) {
                return Long.compare(a.start, b.start);
            }
                return Long.compare(a.end, b.end);
        });

        for(int i = 0; i < n; i ++){
            long start = list.get(i).start;
            /*
            下面會錯, 因為不能保證會先接在 end date
                for(int j = 0; j < k; j ++){
                    if(each_people_end[j] <= start){
                        each_people_end[j] = list.get(i).end;
                        cnt ++;
                        break;
                    }
                }
            */
            /*  選擇最長的結束時間, 優先加入, 但是會超時
                Arrays.sort(each_people_end);
                for(int j = k - 1; j >= 0; j --){
                    if(each_people_end[j] <= start){
                        each_people_end[j] = list.get(i).end;
                        cnt ++;
                        break;
                    }
                }
              */

            if(candidates.size() == 0){
                candidates.add(new Pair(i, list.get(i).end));
            }else{
                Pair p = candidates.floor(new Pair(Integer.MAX_VALUE, start));
                if(p == null){
                    if(candidates.size() < k){
                        candidates.add(new Pair(i, list.get(i).end));
                    }else{
                        cnt++;
                    }
                }else{
                    candidates.remove(p); // 不用 new Pair(i , end) 直接用
                    candidates.add(new Pair(i, list.get(i).end));
                }
            }
        }
        out.println(n - cnt);
        out.flush();
    }


}