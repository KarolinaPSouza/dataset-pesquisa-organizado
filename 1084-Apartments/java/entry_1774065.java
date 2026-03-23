import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class entry_1774065 {
    public static void main(String[] args) throws IOException {
        int n, m;
        long k;

//        File file = new File("C:\\Users\\shsingh\\Downloads\\test_input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
//        long[] desiredSize = new long[n];
        ArrayList<Long> desiredSize = new ArrayList<>(n);
        long[] size = new long[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            desiredSize.add(Long.parseLong(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            size[i] = Long.parseLong(st.nextToken());
        }
        Collections.sort(desiredSize);
        Arrays.sort(size);

        int cus = 0;
        int room = 0;
        int cusWithRoom = 0;

        while (cus < n && room < m) {
            //  System.out.println(cus+" "+room+" "+k+" "+(desiredSize[cus]-size[room]));
            if (Math.abs(desiredSize.get(cus) - size[room]) <= k) {
                cus++;
                room++;
                cusWithRoom++;
            } else {
                if (desiredSize.get(cus) > size[room]) {
                    room++;
                } else {
                    cus++;
                }
            }
        }
        System.out.println(cusWithRoom);
    }
}